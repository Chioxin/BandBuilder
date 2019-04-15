import { ProfileService } from './../../services/profile.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { Profile } from 'src/app/models/profile';
import { Instrument } from 'src/app/models/instrument';
import { instantiateRootComponent } from '@angular/core/src/render3/instructions';
import { Image } from 'src/app/models/image';
import { InstrumentService } from 'src/app/services/instrument.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  // Constructor
  constructor(private auth: AuthService,
    private router: Router,
    private profileSrv: ProfileService,
    private instrumentSrv: InstrumentService) { }
  // Fields
  adminProfile: Profile = new Profile();
  isLoggedIn = false;
  profiles: Profile[] = [];
  instruments: Instrument[] = [];
  selected: Profile = null;
  profile: Profile = null;
  username: '';
  // Methods
  ngOnInit() {
    this.isLoggedIn = this.auth.checkLogin();
    this.loadInstruments();
  }

  reload() {
    this.profileSrv.index().subscribe(
      data => {
        this.profiles = data;
      },
      err => {
        console.error('AdminComponent.reload() ERROR');
        console.error(err);
      }
    );
  }
  loadInstruments() {
    this.instrumentSrv.index().subscribe(
      data => {
        this.instruments = data;
      },
      err => {
        console.error('AdminComponent.loadInstruments(): ERROR');
        console.error(err);
      }
    );

  }
  deleteInstrument(instrument: Instrument) {

  }
  acceptInstrument() {

  }
  setInstrumentSelected(instrument) {
    this.selected = instrument;
  }
  setProfileSelected(profile) {
    this.selected = profile;
  }
  formatCompletedProfile(profile) {
    if (profile.completed) {
      return 'completed';
    }
    return '';
  }
  formatCompletedInstrument(instrument) {
    if (instrument.completed) {
      return 'completed';
    }
    return '';
  }

  loadProfile() {
    const username = this.auth.getUsername;
    this.profileSrv.showProfileByUsername(this.username).subscribe(
      data => {
        this.adminProfile = data;
      },
      err => {
        console.error('AdminComponent.loadProfile(): Error');
        console.error(err);
      }
    );
  }
}
