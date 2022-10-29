import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../models/customer";
import {District} from "../models/district";

@Injectable({
  providedIn: 'root'
})
export class DistrictService {

  // tslint:disable-next-line:variable-name
  ApiUrl_8080 = `${environment.apiUrl}/address`;

  constructor(private httpClient: HttpClient) {
  }

  /**
   * Create by DuyNT
   */
  getAllDistrict(): Observable<District[]> {
    return this.httpClient.get<District[]>(this.ApiUrl_8080 + '/district-list');
  }
}
