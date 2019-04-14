import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { BandSocialMedia } from '../models/band-social-media';

@Injectable({
  providedIn: 'root'
})
export class BandSocialMediaService {

  // FIELDS

  private apiRoute = 'api/bandsocialmedia';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  showById() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.get<BandSocialMedia[]>(this.url, httpOptions);
  }

  create(bandSocialMedia: BandSocialMedia) {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};
    return this.http.post<BandSocialMedia>(this.url, bandSocialMedia, httpOptions);
  }

  update() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.put<BandSocialMedia[]>(this.url, httpOptions);
  }

  delete() {
    const httpOptions = {headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: 'Basic ' + this.auth.getCredentials()
    })};

    return this.http.delete<BandSocialMedia[]>(this.url, httpOptions);
  }


}
