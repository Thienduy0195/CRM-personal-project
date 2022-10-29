import {Injectable} from '@angular/core';
import {environment} from '../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Manufacture} from '../models/manufacture';
import {Car} from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  // tslint:disable-next-line:variable-name
  ApiUrl_8080 = `${environment.apiUrl}/car`;

  constructor(private httpClient: HttpClient) {
  }

  /**
   * Create by DuyNT
   */
  getAllCar(): Observable<Car[]> {
    return this.httpClient.get<Car[]>(this.ApiUrl_8080 + '/list');
  }

  /**
   * Create by DuyNT
   */
  getAllManufacture(): Observable<Manufacture[]> {
    return this.httpClient.get<Manufacture[]>(this.ApiUrl_8080 + '/manufacture-list');
  }

  getCarByManufactureId(id: number): Observable<Car[]> {
    return this.httpClient.get<Car[]>(this.ApiUrl_8080 + '/manufacture/' + id);
  }
}
