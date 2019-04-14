import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { SocialMedia } from '../models/social-media';

@Injectable({
  providedIn: 'root'
})
export class SocialMediaService {

  // FIELDS

  private apiRoute = 'api/socialmedia';
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

    return this.http.get<SocialMedia[]>(this.url, httpOptions);
  }

}
