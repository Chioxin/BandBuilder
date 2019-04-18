import { Instrument } from './../../models/instrument';
import { InstrumentService } from './../../services/instrument.service';
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
  selectedInstrumentId: number;

  myViewerUsername = '';
  myProfile: Profile = null;
  myBands: Band[] = [];
  myBandMembers: BandMember[] = [];
  myInstruments: UserInstrument[] = [];
  instrumentList: Instrument[] = [];

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
    private instrumentSvc: InstrumentService,
    private router: Router,
    private route: ActivatedRoute
    ) { }

  // INIT

  ngOnInit() {
    this.myViewerUsername = this.auth.getUsername();
    this.loadProfile(this.getRoute());
  }

  // METHODS

  // METHODS - UTILITY

  redirectBand(id: number) {
    this.router.navigate(['/bands/' + id]);
  }

  redirectCreateBand() {
    this.router.navigate(['/bandregistration/']);
  }

  redirectUserInstrument(id: number) {
    this.router.navigate(['/userinstruments/' + id]);
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

  flipIsEditingProfile() {
    this.setEditObjects();
    this.isEditingProfile = !this.isEditingProfile;
  }

  // METHODS - BUTTONS

  profileCancelEdit() {
    this.flipIsEditingProfile();
    this.setEditObjects();
  }

  profileSaveEdit() {
    this.flipIsEditingProfile();
    this.udpateProfile();
  }

  profileCreateInstrument() {
    console.log(this.selectedInstrumentId);
    this.createUserInstrument(this.newUserInstrument, this.selectedInstrumentId);
  }

  profileRemoveInstrument(id: number) {
    this.removeUserInstrumentById(id);
  }

  profileRemoveMember(bandMember: BandMember) {
    this.removeMyProfileFromMember(bandMember);
  }

  // METHODS - SERVICES

  loadProfileById(id: number) {
    this.profileSvc.show(id).subscribe(
      data => {
        this.myProfile = data;
        const profileId = this.myProfile.id;
        this.loadUserInstruments(profileId);
        this.loadBandMembersByProfileId(profileId);
        this.loadInstruments();
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
        this.loadUserInstruments(profileId);
        this.loadBandMembersByProfileId(profileId);
        this.loadBandsByUsername(this.myProfile.user.username);
        this.loadInstruments();
        this.setEditObjects();
        this.checkViewerIsOwner();
      },
      err => {
        console.error('ERROR GETTING PROFILE BY USERNAME (' + username + ')');
        console.error(err);
      }
    );
  }

  loadUserInstruments(pid: number) {
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

  // updateUserInstrument() {
  //   this.userInstrumentSvc.update(this.editUserInstrument.id, this.editUserInstrument).subscribe(
  //     data => {
  //       this.editUserInstrument = data;
  //       this.loadProfileByUser(this.myProfile.user.username);
  //     },
  //     err => {
  //       console.error('FAILED TO UPDATE ADDRESS');
  //       console.error(err);
  //     }
  //   );
  // }

  loadInstruments() {
    this.instrumentSvc.index().subscribe(
      data => {
        this.instrumentList = data;
      },
      err => {
        console.error('FAILED TO LOAD INSTRUMENT LIST');
        console.error(err);
      }
    );
  }

  createUserInstrument(userInstrument: UserInstrument, instrumentId: number) {
    this.instrumentSvc.show(instrumentId).subscribe(
      dataInstrument => {
        userInstrument.instrument = dataInstrument;
        userInstrument.profile = this.myProfile;
        userInstrument.active = true;
        this.userInstrumentSvc.create(userInstrument).subscribe(
          dataUserInstrument => {
            this.newUserInstrument = new UserInstrument();
            this.loadProfileByUser(this.myProfile.user.username);
          },
          err => {
            console.error('FAILED TO CREATE A USER INSTRUMENT');
            console.error(err);
          }
        );
      },
      err => {
        console.error('FAILED TO FIND INSTRUMENT BY ID (' + instrumentId + ')');
        console.error(err);
      }
    );
  }

  removeUserInstrumentById(id: number) {
    this.userInstrumentSvc.delete(id).subscribe(
      data => {
        this.loadProfileByUser(this.myProfile.user.username);
       },
      err => {
        console.error('FAILED TO REMOVE USER INSTRUMENT BY ID (' + id + ')');
        console.error(err);
      }
    );
  }

  removeMyProfileFromMember(bandMember: BandMember) {
    bandMember.profile = null;
    this.bMemberSvc.update(bandMember.id, bandMember).subscribe(
      data => {
        this.loadProfileByUser(this.myProfile.user.username);
      },
      err => {
        console.error('FAILED TO REMOVE SELF FROM BANDMEMBER BY ID (' + bandMember.id + ')');
        console.error(err);
      }
    );
  }
}
