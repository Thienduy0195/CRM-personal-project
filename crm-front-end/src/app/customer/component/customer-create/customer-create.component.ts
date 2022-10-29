import {Component, OnInit} from '@angular/core';
import {CustomerDTO} from '../../models/customerDTO';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {CustomerService} from '../../services/customer.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {Manufacture} from '../../../car/models/manufacture';
import {CarService} from '../../../car/services/car.service';
import {Car} from '../../../car/models/car';
import {DistrictService} from '../../services/district.service';
import {District} from '../../models/district';

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {

  customerDto: CustomerDTO;
  createDate: string;
  carList: Car [];
  manufactureList: Manufacture[];
  districtList: District[];
  yearList: string [];
  carColorList: string [];
  customerStatusList: string [];
  currentYear: any;
  isExitsUser = false;
  isExitsEmail = false;
  isExitsPhone = false;
  customerForm: FormGroup;
  name = '';

  constructor(private customerService: CustomerService,
              private districtService: DistrictService,
              private carService: CarService,
              private router: Router,
              private toast: ToastrService,
              private titleService: Title) {
    this.titleService.setTitle('Thêm mới');
  }

  ngOnInit(): void {
    this.getAllCar();
    this.getManufactureList();
    this.getHardData();
    this.getAllDistrict();
    this.loadCustomerForm();
  }

  // ngOnChange(): void{
  //   if (this.customerForm.)
  // }

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

  loadCustomerForm() {
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
      // dateOfBirth: new FormControl('', Validators.pattern('^[a-zA-Z\\s?]+$')),
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
    this.customerDto = this.customerForm.value;
    this.customerDto.createDate = this.createDate;
    console.log(this.customerDto);
    this.customerService.createCustomer(this.customerDto).subscribe(
      value => {
        this.router.navigateByUrl('/list');
        this.toast.success('Thêm mới thành công!');
      },
      error => {
        console.log(error);
        this.toast.error('Thêm mới thật bại!');
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

  checkPhoneNumber(value: any) {
    if (value === '') {
      value = 'phone ';
    } else {
      this.name = this.customerForm.value.name;
      console.log(this.name);
      this.customerService.checkExistPhoneNumber(value).subscribe(result => {
        if (result !== null) {
          this.isExitsPhone = true;
          // this.customerDto.address = result.district.name;
          this.customerForm.patchValue(result);
          this.customerForm.patchValue({district: result.district.name});
          this.customerForm.patchValue({car: ''});
          this.customerForm.patchValue({yearOfManufacture: ''});
        } else {
          // this.getAllCar();
          // this.getManufactureList();
          // this.getHardData();
          // this.getAllDistrict();
          this.loadCustomerForm();
          this.customerForm.patchValue({firstPhoneNumber: value});
          this.customerForm.patchValue({name: this.name});
        }
      });
    }
  }

  setCheckExistPhone(value: string) {
    this.isExitsPhone = false;
  }
}
