import { ProfileService } from 'src/app/services/profile.service';
import { Profile } from './../../models/profile';
import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-gregs-test-page',
  templateUrl: './gregs-test-page.component.html',
  styleUrls: ['./gregs-test-page.component.css']
})
export class GregsTestPageComponent implements OnInit {

  iAm = '';
  profile: Profile = null;

  constructor(
    private auth: AuthService,
    private profileSvc: ProfileService
  ) { }

  ngOnInit() {
    this.getUserName();
  }

  getUserName() {
  // this.auth.getUserProfile().subscribe(
  //   data => {
  //     this.iAm = data;
  //   },
  //   err => {
  //     console.error('WTF');
  //     console.error(err);
  //   }
  // );

  this.iAm = this.auth.getUsername();
  this.profileSvc.showProfileByUsername(this.iAm).subscribe(
    data => {
      this.profile = data;
    },
    err => {
      console.error('COULD NOT FIND PROFILE BY USER');
      console.error(err);
    }
  );

  }

}
