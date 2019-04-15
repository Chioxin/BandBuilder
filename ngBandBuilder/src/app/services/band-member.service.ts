import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService } from './auth.service';
import { BandMember } from '../models/band-member';

@Injectable({
  providedIn: 'root'
})
export class BandMemberService {
  // FIELDS
  private apiRoute = 'api/bandmembers/';
  private baseUrl = environment.baseUrl;
  private url = this.baseUrl + this.apiRoute;

  // CONSTRUCTOR
  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }
  showByBandId(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };

    return this.http.get<BandMember[]>(`/api/bands/${id}/bandmembers/`, httpOptions);
  }

  showByProfileId(pid: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };

    return this.http.get<BandMember[]>(`${this.url}profiles/${pid}`, httpOptions);
  }

  create(bandMember: BandMember) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.post<BandMember>(this.url, bandMember, httpOptions);
  }
  update(id: number, bandMember: BandMember) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };

    return this.http.put<BandMember[]>(this.url + id, bandMember, httpOptions);
  }
  delete(id: number) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Basic ' + this.auth.getCredentials()
      })
    };
    return this.http.delete<BandMember>(this.url + id, httpOptions);
  }
}
