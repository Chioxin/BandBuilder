import { Address } from './../models/address';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  // FIELDS

  private apiRoute = 'api/addresses/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR

  constructor(
    private http: HttpClient,
    private auth: AuthService
    ) { }

  // METHODS

  show(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Address>(this.url + id, httpOptions);
  }

  udpate(id: number, address: Address) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.put<Address>(this.url + id, address, httpOptions);
  }
}
