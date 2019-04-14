import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { Image } from './../models/image';
@Injectable({
  providedIn: 'root'
})
export class ImageService {

  // FIELDS
  private apiRoute = 'api/images/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR

  constructor(private http: HttpClient,
              private auth: AuthService) { }


  // METHODS
  showById(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.get<Image>(this.url + id, httpOptions);
  }
  update(id: number, image: Image) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application / json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.put<Image>(this.url + '/' + id, image, httpOptions);
  }
}
