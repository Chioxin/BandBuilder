import { ProfileService } from 'src/app/services/profile.service';
import { Profile } from './../../models/profile';
import { UserInstrument } from './../../models/user-instrument';
import { UserInstrumentService } from './../../services/user-instrument.service';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { isNumber } from 'util';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  // FIELDS

  myUsername = '';
  myProfile: Profile = null;
  myInstruments: UserInstrument[] = [];

  // CONSTRUCTOR

  constructor(
    private auth: AuthService,
    private userInstrumentSvc: UserInstrumentService,
    private profileSvc: ProfileService
  ) { }

  // INIT

  ngOnInit() {
    this.myUsername = this.auth.getUsername();
    this.loadProfile(this.myUsername);
  }

  // METHODS

  loadProfile(target: any) {
    if (isNumber(target)) {
      this.loadProfileById(target);
    } else {
      this.loadProfileByUser(target);
    }
  }

  loadProfileById(id: number) {
    this.profileSvc.show(id).subscribe(
      data => {
        this.myProfile = data;
      },
      err => {
        console.error('ERROR GETTING PROFILE BY ID (' + id + ')');
        console.error(err);
      }
    );
  }

  loadProfileByUser(username: string) {
    this.profileSvc.showProfileByUsername(username).subscribe(
      data => {
        this.myProfile = data;
      },
      err => {
        console.error('ERROR GETTING PROFILE BY USERNAME (' + username + ')');
        console.error(err);
      }
    );
  }

  loadInstruments(pid: number) {
    this.userInstrumentSvc.showByProfileId(pid).subscribe(
      data => {
        this.myInstruments = data;
      },
      err => {
        console.error('ERROR GETTING USER INTRUMENTS BY PROFILE ID (' + pid + ')');
      }
    );
  }

}
