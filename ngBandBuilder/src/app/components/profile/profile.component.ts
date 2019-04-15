import { User } from 'src/app/models/user';
import { Address } from './../../models/address';
import { Router, ActivatedRoute } from '@angular/router';
import { BandMemberService } from './../../services/band-member.service';
import { BandServiceService } from './../../services/band-service.service';
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

  editUser = new User();
  editAddress = new Address();
  editProfile = new Profile();
  editImage = new Image();
  editUserInstrument = new UserInstrument();
  newUserInstrument = new UserInstrument();

  myUsername = '';
  myProfile: Profile = null;
  viewerIsOwner = false;
  isEditingProfile = false;
  myInstruments: UserInstrument[] = [];

  // CONSTRUCTOR

  constructor(
    private auth: AuthService,
    private userInstrumentSvc: UserInstrumentService,
    private profileSvc: ProfileService,
    private bandSvc: BandServiceService,
    private bMemberSvc: BandMemberService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  // INIT

  ngOnInit() {
    this.myUsername = this.auth.getUsername();
    this.loadProfile(this.getRoute());
  }

  // METHODS

  getRoute() {
    const aNumber = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (aNumber) {
      return aNumber;
    } else {
      return this.myUsername;
    }
  }

  checkViewerIsOwner() {
    if (this.myUsername === this.myProfile.user.username) {
      this.viewerIsOwner = true;
    } else {
      this.viewerIsOwner = false;
    }
  }

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
        this.loadInstruments(this.myProfile.id);
        this.checkViewerIsOwner();
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
        this.loadInstruments(this.myProfile.id);
        this.checkViewerIsOwner();
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

  loadBandsByProfileId(pid: number) {
    // Will need to be able to get bands by profile ID
  }

  loadBandsProfileIsMemberTo(pid: number) {
    // Will need to be able to get bands profile is a band member of, by profile ID
  }

}
