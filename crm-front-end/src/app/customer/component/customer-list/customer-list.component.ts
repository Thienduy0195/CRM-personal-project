import {Component, OnInit} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {CustomerService} from '../../services/customer.service';
import {Customer} from '../../models/customer';
import {InformationSheet} from '../../models/information-sheet';
import {Router} from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  informationSheetList: InformationSheet[];
  customer: Customer;
  color = 'red';
  page = 1;
  pageNumber = 0;
  totalPages = 0;

  constructor(private customerService: CustomerService,
              private toast: ToastrService,
              private router: Router,
              private title: Title) {
    this.title.setTitle('Customer list');
  }

  ngOnInit(): void {
    // this.toast.success('Welcome to ustomer list!', 'CUSTOMER LIST');
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.customerService.getAllCustomer(this.page).subscribe(value => {
      console.log(value);
      // @ts-ignore
      console.log(value.content);
      // @ts-ignore
      this.customerList = value.content;
      console.log(this.customerList);
      // @ts-ignore
      this.totalPages = result.length;
      // @ts-ignore
      this.pageNumber = result.pageable.pageNumber;
    }, error => {
      this.toast.error('Load danh sách thất bại.');
    });
  }

  getCustomerById(id: number) {
    this.customerService.getCustomerById(id).subscribe(value => {
      this.customer = value;
      console.log(this.customer);
    }, error => {
      this.toast.error('Khách hàng không tồn tại');
    });
  }

  showInformationList(id: number) {
    this.customerService.getCustomerById(id).subscribe(value => {
      this.informationSheetList = value.informationSheets;
      console.log(this.informationSheetList);
    }, error => {
      this.toast.error('KHÔNG TÌM THẤY!');
    });
  }

  deletecustomer() {
    this.customerService.deleteCustomerById(this.customer.id).subscribe(value => {
      // this.router.navigateByUrl('');
      this.getAllCustomer();
      this.informationSheetList = undefined;
      this.toast.success('XÓA THÀNH CÔNG');
    }, error => {
      this.toast.error('XÓA KHÔNG THÀNH CÔNG');
    });
  }

  getPage(page) {
    this.page = page - 1;
  }
}
