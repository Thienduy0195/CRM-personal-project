import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {Customer} from '../models/customer';
import {CustomerDTO} from '../models/customerDTO';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  // tslint:disable-next-line:variable-name
  ApiUrl_8080 = `${environment.apiUrl}/customer`;

  constructor(private httpClient: HttpClient) {
  }

  /**
   * Create by DuyNT
   */
  public getAllCustomer(page: number): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.ApiUrl_8080 + '/list?page=' + page);
  }

  createCustomer(customerDTO: CustomerDTO): Observable<void> {
    return this.httpClient.post<void>(this.ApiUrl_8080 + '/create', customerDTO);
  }

  getCustomerById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.ApiUrl_8080 + '/' + id);
  }

  updateCustomer(id: number, customer: CustomerDTO): Observable<void> {
    // console.log('herreeeee');
    return this.httpClient.post<void>(this.ApiUrl_8080 + '/update/' + id, customer);
  }

  checkExistPhoneNumber(phoneNumber: string): Observable<Customer> {
    return this.httpClient.get<Customer>(this.ApiUrl_8080 + '/phone/' + phoneNumber);
  }

  public deleteCustomerById(id): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.ApiUrl_8080 + '/deleteCustomerBy?id=' + id);
  }
}
