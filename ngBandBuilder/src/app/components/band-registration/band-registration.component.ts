import { ProfileService } from './../../services/profile.service';
import { Component, OnInit } from '@angular/core';
import { BandRegistrationForm } from 'src/app/models/band-registration-form';
import { AuthService } from 'src/app/services/auth.service';
import { BandServiceService } from 'src/app/services/band-service.service';
import { Profile } from 'src/app/models/profile';
import { Router } from '@angular/router';


@Component({
  selector: 'app-band-registration',
  templateUrl: './band-registration.component.html',
  styleUrls: ['./band-registration.component.css']
})
export class BandRegistrationComponent implements OnInit {
  // FIELDS
  bandRegistrationForm: BandRegistrationForm = new BandRegistrationForm();
  myProfile: Profile;

  constructor(
    private bandSvc: BandServiceService,
    private auth: AuthService,
    private profileService: ProfileService,
    private router: Router
    ) { }

  ngOnInit() {
    this.getProfile();
  }

  redirectBand(id: number) {
    this.router.navigate(['/bands/' + id]);
  }

  redirectProfile() {
    this.router.navigate(['/profiles/']);
  }

  getProfile() {
    const tempUser = this.auth.getUsername();
    this.findProfileByUserName(tempUser);
  }

  findProfileByUserName(username: string) {
    this.profileService.showProfileByUsername(username).subscribe(
      data => {
        this.myProfile = data;
      },
      err => {
        console.error(err);
      }
    );
  }

  createBand() {
    this.bandRegistrationForm.bandLeader = this.myProfile.id;
    this.bandSvc.create(this.bandRegistrationForm).subscribe(
      dataBand => {
        this.redirectBand(dataBand.id);
      },
      err => {
        console.error(err);
      }
    );
  }

}
