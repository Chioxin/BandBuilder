import { UserInstrument } from './../models/user-instrument';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class UserInstrumentService {

  // FIELDS

  private apiRoute = 'api/userinstruments/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  // METHODS

  showByProfileId(pid: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<UserInstrument[]>(this.url + 'profiles/' + pid, httpOptions);
  }

  select(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<UserInstrument>(this.url + id, httpOptions);
  }

  update(id: number, userInstrument: UserInstrument) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.put<UserInstrument>(this.url + id, userInstrument, httpOptions);
  }

  create(userInstrument: UserInstrument) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.post<UserInstrument>(this.url, userInstrument, httpOptions);
  }

  delete(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.delete<UserInstrument>(this.url + id, httpOptions);
  }
}
