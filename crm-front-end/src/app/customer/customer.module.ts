import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CustomerRoutingModule} from './customer-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomerListComponent} from './component/customer-list/customer-list.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerCreateComponent } from './component/customer-create/customer-create.component';
import { CustomerEditComponent } from './component/customer-edit/customer-edit.component';



@NgModule({

  declarations: [CustomerListComponent, CustomerCreateComponent, CustomerEditComponent],
  imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule
  ]
})
export class CustomerModule {
}
