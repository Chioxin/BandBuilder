import { Component, OnInit } from '@angular/core';
import { UserInstrumentService } from 'src/app/services/user-instrument.service';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-user-instrument',
  templateUrl: './user-instrument.component.html',
  styleUrls: ['./user-instrument.component.css']
})
export class UserInstrumentComponent implements OnInit {

  constructor(
    private userInstrumentService: UserInstrumentService,
    private auth: AuthService
    ) { }

  ngOnInit() {
  }

}
