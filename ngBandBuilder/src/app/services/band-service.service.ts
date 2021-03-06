import { AddressService } from './address.service';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Band } from '../models/band';
import { BandRegistrationForm } from '../models/band-registration-form';
import { Address } from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class BandServiceService {
  // api routes
  private profileRoute = 'api/profiles/';
  private bandRoute = 'api/bands/';
  private baseUrl = environment.baseUrl;
  private profileURL = this.baseUrl + this.profileRoute;
  private bandURL = this.baseUrl + this.bandRoute;
  private concat = '/bands';

  // address api routes
  private addressRoute = 'api/addresses/';
  private addressURL = this.baseUrl + this.addressRoute;

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  index(user: string) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Band[]>(this.profileURL + user + this.concat, httpOptions);
  }

  indexAll() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Band[]>(this.bandURL, httpOptions);
  }

  show(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Band>(this.bandURL + id, httpOptions);
  }

  create(band: BandRegistrationForm) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};
    return this.http.post<Band>(this.bandURL, band, httpOptions);
  }

  update(id: number, band: Band) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};
    return this.http.put<Band>(this.bandURL + id, band, httpOptions);
  }

  delete(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};
    return this.http.delete<Band>(this.bandURL + id, httpOptions);
  }

}
