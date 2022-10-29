import {Component, OnInit} from '@angular/core';
import {CustomerDTO} from '../../models/customerDTO';
import {Car} from '../../../car/models/car';
import {Manufacture} from '../../../car/models/manufacture';
import {District} from '../../models/district';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../services/customer.service';
import {DistrictService} from '../../services/district.service';
import {CarService} from '../../../car/services/car.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {Customer} from '../../models/customer';
import {InformationSheet} from '../../models/information-sheet';

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerDto: CustomerDTO;
  customer: Customer;
  createDate: string;
  informationSheetList: InformationSheet [];
  carList: Car [];
  manufactureList: Manufacture[];
  districtList: District[];
  yearList: string [];
  carColorList: string [];
  customerStatusList: string [];
  currentYear: any;
  isUpdate = false;
  isExitsUser = false;
  isExitsEmail = false;
  isExitsPhone = false;
  provinceForm: FormGroup = new FormGroup({
    province: new FormControl('', Validators.required)
  });
  customerForm: FormGroup;

  constructor(private customerService: CustomerService,
              private districtService: DistrictService,
              private carService: CarService,
              private router: Router,
              private activateRoute: ActivatedRoute,
              private toast: ToastrService,
              private titleService: Title) {
    this.titleService.setTitle('Cập nhật');
  }

  ngOnInit(): void {
    this.getAllCar();
    this.getManufactureList();
    this.getHardData();
    this.getAllDistrict();
    this.loadCustomerInfo();
  }

  /**
   * Create by: DuyNT
   * Date Create: 11/08/2022
   * function: load customer form DB
   */
  loadCustomerInfo() {
    this.customerForm = new FormGroup({
      id: new FormControl(),
      // tslint:disable-next-line:max-line-length
      name: new FormControl('', [Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]' +
        '[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*' +
        '(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]' +
        '[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$'), Validators.required]),
      firstPhoneNumber: new FormControl('', [Validators.pattern('^[0-9]{9,12}$'), Validators.required]),
      secondPhoneNumber: new FormControl('', Validators.pattern('^[0-9]{9,12}$')),
      dateOfBirth: new FormControl(''),
      gender: new FormControl(''),
      address: new FormControl(''),
      email: new FormControl('', Validators.pattern('^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$')),
      occupation: new FormControl(''),
      salesMethod: new FormControl('Lẻ'),
      paymentMethod: new FormControl('TM'),
      informationSource: new FormControl('Internet'),
      createDate: new FormControl(this.createDate),
      updateDate: new FormControl(this.createDate),
      car: new FormControl('', Validators.required),
      district: new FormControl('', Validators.required),
      carColor: new FormControl(''),
      yearOfManufacture: new FormControl(''),
      content: new FormControl('', Validators.required),
      customerStatus: new FormControl('COOL'),
    });
    const id = Number(this.activateRoute.snapshot.params.id);
    this.customerService.getCustomerById(Number(id)).subscribe(value => {
      this.customer = value;
      this.customerForm.patchValue(this.customer);
      this.customerForm.patchValue({district: value.district.name});
      this.customerForm.patchValue({car: ''});
      this.informationSheetList = value.informationSheets;
    });
  }

  getHardData() {
    this.carColorList = ['Trắng', 'Đen', 'Đỏ', 'Vàng', 'Xanh', 'Cam', 'Xám', 'Bạc', 'Nâu'];
    this.yearList = ['2019', '2020', '2021', '2022', '2023', '2024', '2025', '2026', '2027'];
    this.customerStatusList = ['COOL', 'WARM', 'HOT', 'KHĐ', 'HỦY'];
    const currentDate = new Date();
    this.createDate = currentDate.getFullYear() + '-' + currentDate.getDate() + '-' + `${currentDate.getMonth() + 1}`;
    this.currentYear = currentDate.getFullYear();
  }

  getManufactureList() {
    this.carService.getAllManufacture().subscribe(value => {
      this.manufactureList = value;
    });
  }

  getAllCar() {
    this.carService.getAllCar().subscribe(value => {
      this.carList = value;
    });
  }

  getAllDistrict() {
    this.districtService.getAllDistrict().subscribe(value => {
      this.districtList = value;
    });
  }

  getCarListByManufactureId(id: any) {
    this.carService.getCarByManufactureId(Number(id)).subscribe(value => {
      this.carList = value;
    });
  }

  private check16Age(abstractControl: AbstractControl): any {
    if (abstractControl.value === '') {
      return null;
    }
    const today = new Date();
    const birthDate = new Date(abstractControl.value);
    if (birthDate === undefined) {
      return null;
    }
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    if (age <= 16) {
      return {not16: true};
    } else if (age >= 100) {
      return {after100: true};
    } else {
      return null;
    }
  }

  private notBlank(abstractControl: AbstractControl): any {
    // tslint:disable-next-line:variable-name
    const string: string = abstractControl.value;
    return (string.charAt(0) === ' ' || string.charAt(string.length - 1) === ' ') ? {notBlank: true} : null;
  }


  getFirstPhoneNumber() {
    return this.customerForm.get('firstPhoneNumber');
  }

  getSecondPhoneNumber() {
    return this.customerForm.get('secondPhoneNumber');
  }

  getEmail() {
    return this.customerForm.get('email').get('email');
  }

  submit() {
    const customerDTO: CustomerDTO = this.customerForm.value;
    customerDTO.id = this.customer.id;
    customerDTO.createDate = this.createDate;
    console.log(customerDTO);
    console.log(this.customer.id);
    this.customerService.updateCustomer(Number(this.customer.id), customerDTO).subscribe(
      value => {
        // this.router.navigateByUrl('/list');
        this.toast.success('Cập nhật thành công!');
      },
      error => {
        this.toast.error('Cập nhật thật bại!');
        console.log(error);
      }
    );
  }

  cancel() {
    this.toast.success('Cancelled');
    // this.customerForm = new FormGroup({
    //   id: new FormControl(),
    // tslint:disable-next-line:max-line-length
    //   name: new FormControl('', [Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$'),
    //     Validators.required, this.notBlank, Validators.minLength(5), Validators.maxLength(50)]),
    //   dateOfBirth: new FormControl('', [Validators.pattern('^[a-zA-Z\\s?]+$'), this.check16Age]),
    //   email: new FormGroup({
    //     email: new FormControl('', [Validators.pattern('^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$'), Validators.required])
    //   }),
    //   phoneNumber: new FormGroup({
    // tslint:disable-next-line:max-line-length
    //     phone: new FormControl('', [Validators.pattern('^(0|84+)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$'), Validators.required])
    //   }),
    //   userName: new FormGroup({
    //     userName: new FormControl('', [Validators.required, this.notBlank, Validators.pattern('[a-zA-z0-9]{5,50}')])
    //   }),
    //   password: new FormGroup({
    //     // tslint:disable-next-line:max-line-length
    //     password: new FormControl('', [Validators.pattern('^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,50}'),
    //       Validators.required]),
    //     // tslint:disable-next-line:max-line-length
    //     confirmPassword: new FormControl('', Validators.required)
    //   }, this.checkConfirmPassword),
    //   province: new FormControl('', Validators.required),
    //   district: new FormControl('', Validators.required),
    //   commune: new FormControl('', Validators.required)
    // });
  }

  checkUserName($event: Event) {
    // this.customerService.checkUserName(String($event)).subscribe(
    //   value => {
    //     this.isExitsUser = !!value;
    //   }
    // );
    // if (String($event) === '') {
    //   this.isExitsUser = false;
    // }
  }

  checkEmail($event: Event) {
    // this.customerService.checkEmail(String($event)).subscribe(
    //   value => {
    //     console.log(value);
    //     if (value) {
    //       this.isExitsEmail = true;
    //     } else {
    //       this.isExitsEmail = false;
    //     }
    //   }
    // );
    // if (String($event) === '') {
    //   this.isExitsEmail = false;
    // }
  }

  checkPhone($event: Event) {
    // this.customerService.checkPhone(String($event)).subscribe(
    //   value => {
    //     if (value) {
    //       this.isExitsPhone = true;
    //     } else {
    //       this.isExitsPhone = false;
    //     }
    //   }
    // );
    // if (String($event) === '') {
    //   this.isExitsPhone = false;
    // }
  }

  addOrDeleteUpdateRow() {
    this.isUpdate = !this.isUpdate;
  }
}
