import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserInstrumentService {

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }
}
