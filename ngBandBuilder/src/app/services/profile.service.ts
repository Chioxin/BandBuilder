import { RegistrationForm } from './../models/registration-form';
import { Profile } from './../models/profile';
import { AuthService } from './auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  // FIELDS

  private apiRoute = 'api/profiles/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR

  constructor(private http: HttpClient,
              private auth: AuthService) { }

  // METHODS

  index() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Profile[]>(this.url, httpOptions);
  }

  show(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Profile>(this.url + id, httpOptions);

  }

  create(profile: RegistrationForm) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials() // When creating a profile you should not need to authenticate. Right?
    })};
    return this.http.post<Profile>(this.url, profile, httpOptions);
  }

  update(id: number, profile: Profile) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.put<Profile>(this.url + id, profile, httpOptions);
  }

  delete(id: number) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.delete<Profile>(this.url + id, httpOptions);
  }

  showProfileByUsername(username: string) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<Profile>(this.url + 'users/' + username, httpOptions);
  }

}
