import { Instrument } from './../models/instrument';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { InstrumentForm } from '../models/instrument-form';
@Injectable({
  providedIn: 'root'
})
export class InstrumentService {

  // FIELDS

  private apiRoute = 'api/instruments/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR

  constructor(private http: HttpClient,
              private auth: AuthService) { }

  // METHODS

  index() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };

    return this.http.get<Instrument[]>(this.url, httpOptions);
  }

  show(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };

    return this.http.get<Instrument>(this.url + id, httpOptions);

  }

  create(newInstrument: InstrumentForm) {
    console.log(newInstrument);

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials() // When creating a profile you should not need to authenticate. Right?
      })
    };
    return this.http.post<Instrument>(this.url, newInstrument, httpOptions);
  }

  update(id: number, instrument: Instrument) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application / json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.put<Instrument>(this.url + id, instrument, httpOptions);
  }
  delete(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.delete<Instrument>(this.url + id, httpOptions);
  }
}
