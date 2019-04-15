import { Profile } from './../models/profile';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // private baseUrl = 'http://localhost:8090/';
  private baseUrl = environment.baseUrl;

  constructor(private http: HttpClient) { }

  login(username, password) {

    // Make credentials
    const credentials = this.generateBasicAuthCredentials(username, password);
    // Send credentials as Authorization header (this is spring security convention for basic auth)
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest'
      })
    };

    // create request to authenticate credentials
    return this.http
      .get(this.baseUrl + 'authenticate', httpOptions)
      .pipe(
        tap((res) => {
          localStorage.setItem('credentials' , credentials);
          return res;
        }),
        catchError((err: any) => {
          console.log(err);
          return throwError('AuthService.login(): Error logging in.');
        })
      );
  }

  register(user) {
    // YOU DID SOMETHING WRONG, INCLUDE A httpOptions.
    // create request to register a new account
    return this.http.post<User>(this.baseUrl + 'register', user)
    .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('AuthService.register(): error registering user.');
        })
      );

  }

  logout() {
    localStorage.removeItem('credentials');
    localStorage.removeItem('username');
    localStorage.removeItem('password');
  }

  checkLogin() {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }

  generateBasicAuthCredentials(username, password) {
    return btoa(`${username}:${password}`);
  }

  getCredentials() {
    return localStorage.getItem('credentials');
  }

  setUsernamePassword(username, password) {
    localStorage.setItem('username', username);
    localStorage.setItem('password', password);
  }

  getUsernamePassword() {
    return {username: localStorage.getItem('username'), password: localStorage.getItem('password')};
  }

  getUsername() {
    const creds = atob(localStorage.credentials);
    const username = creds.substring(0, creds.indexOf(':'));
    return username;
  }
}
