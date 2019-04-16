import { UserInstrument } from './../../models/user-instrument';
import { Image } from './../../models/image';
import { ImageService } from './../../services/image.service';
import { AddressService } from './../../services/address.service';
import { BandMember } from './../../models/band-member';
import { Band } from './../../models/band';
import { User } from 'src/app/models/user';
import { Address } from './../../models/address';
import { Router, ActivatedRoute } from '@angular/router';
import { BandMemberService } from './../../services/band-member.service';
import { BandServiceService } from './../../services/band-service.service';
import { ProfileService } from 'src/app/services/profile.service';
import { Profile } from './../../models/profile';
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

  editUser = null;
  editAddress = null;
  editProfile = null;
  editImage = null;
  editUserInstrument: UserInstrument[] = [];
  newUserInstrument = new UserInstrument();

  myViewerUsername = '';
  myProfile: Profile = null;
  myBands: Band[] = [];
  myBandMembers: BandMember[] = [];
  myInstruments: UserInstrument[] = [];

  viewerIsOwner = false;
  isEditingProfile = false;

  // CONSTRUCTOR

  constructor(
    private auth: AuthService,
    private userInstrumentSvc: UserInstrumentService,
    private profileSvc: ProfileService,
    private addressSvc: AddressService,
    private imageSvc: ImageService,
    // private userSvc: UserService,
    private bandSvc: BandServiceService,
    private bMemberSvc: BandMemberService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  // INIT

  ngOnInit() {
    this.myViewerUsername = this.auth.getUsername();
    this.loadProfile(this.getRoute());
  }

  // METHODS

  flipIsEditingProfile() {
    this.setEditObjects();
    this.isEditingProfile = !this.isEditingProfile;
  }

  profileCancelEdit() {
    this.flipIsEditingProfile();
    this.setEditObjects();
  }

  profileSaveEdit() {
    this.flipIsEditingProfile();
    this.udpateProfile();
  }

  setEditObjects() {
    this.editAddress = this.myProfile.address;
    this.editImage = this.myProfile.image;
    this.editProfile = this.myProfile;
    this.editUser = this.myProfile.user;
    this.editUserInstrument = this.myProfile.userInstruments;
  }

  getRoute() {
    const aNumber = parseInt(this.route.snapshot.paramMap.get('id'), 10);
    if (aNumber) {
      return aNumber;
    } else {
      return this.myViewerUsername;
    }
  }

  checkViewerIsOwner() {
    if (this.myViewerUsername === this.myProfile.user.username) {
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
        const profileId = this.myProfile.id;
        this.loadInstruments(profileId);
        this.loadBandMembersByProfileId(profileId);
        this.setEditObjects();
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
        const profileId = this.myProfile.id;
        this.loadInstruments(profileId);
        this.loadBandMembersByProfileId(profileId);
        this.loadBandsByUsername(this.myProfile.user.username);
        this.setEditObjects();
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
        console.error(err);
      }
    );
  }

  loadBandsByUsername(username: string) {
    this.bandSvc.index(username).subscribe(
      data => {
        this.myBands = data;
      },
      err => {
        console.error('ERROR GETTING BAND BY USERNAME');
        console.error(err);
      }
    );
  }

  loadBandMembersByProfileId(pid: number) {
    this.bMemberSvc.showByProfileId(pid).subscribe(
      data => {
        this.myBandMembers = data;
      },
      err => {
        console.error('ERROR GETTING MEMBERS BY PROFILE ID (' + pid + ')');
        console.error(err);
      }
    );
  }

  udpateProfile() {
    console.log('HEY WHAT ARE THESE TWO OBJECTS ACTUALLY????');
    console.log(this.editAddress.id);
    console.log(this.editAddress);
    console.log(this.editProfile.id);
    console.log(this.editProfile);

    this.addressSvc.update(this.editAddress.id, this.editAddress).subscribe(
      dataAddress => {
        this.editProfile.address = dataAddress;
        this.profileSvc.update(this.myProfile.id, this.editProfile).subscribe(
          dataProfile => {
            this.loadProfileById(this.myProfile.id);
          },
          err => {
            console.error('FAILED TO UPDATE PROFILE');
            console.error(err);
          }
        );
      },
      err => {
        console.error('FAILED TO UPDATE ADDRESS');
        console.error(err);
      }
    );
  }
}
