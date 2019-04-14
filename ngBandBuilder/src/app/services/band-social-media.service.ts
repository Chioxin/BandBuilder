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

  private apiRoute = 'api/bands';
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

}
