import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Band } from '../models/band';
import { BandRegistrationForm } from '../models/band-registration-form';

@Injectable({
  providedIn: 'root'
})
export class BandServiceService {

  // FIELDS

  private apiRoute = 'api/bands';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  index() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Band[]>(this.url, httpOptions);
  }

  createBand(band: BandRegistrationForm) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials() // When creating a profile you should not need to authenticate. Right?
    })};
    return this.http.post<Band>(this.url, band, httpOptions);
  }

}
