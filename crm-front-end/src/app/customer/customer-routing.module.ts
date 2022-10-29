import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {CustomerListComponent} from './component/customer-list/customer-list.component';
import {CustomerCreateComponent} from './component/customer-create/customer-create.component';
import {CustomerEditComponent} from './component/customer-edit/customer-edit.component';
// import {AuthGuardCustomerService} from '../authentication/services/auth-guard-customer.services';
// import {AuthGuardEmployeeAdminService} from '../authentication/services/auth-guard-employee-admin.services';

const routes: Routes = [
  {
    path: 'customers',
    component: CustomerListComponent
  },
  {
    path: 'create',
    component: CustomerCreateComponent
  },
  {
    path: 'customer/update/:id',
    component: CustomerEditComponent
  },
  // {
  //   path: 'customers/edit/:id', component: EditCustomerComponent,
  //   canActivate: [AuthGuardEmployeeAdminService]
  // },
  // {
  //   path: 'customers/home-page',
  //   component: HomePageCustomerComponent,
  //   canActivate: [AuthGuardCustomerService]
  // },
  // {
  //   path: 'customers/home-page/info',
  //   component: CustomerInformationComponent,
  //   canActivate: [AuthGuardCustomerService]
  // },
  {
    path: 'customers',
    component: CustomerListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule {
}
