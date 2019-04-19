import { Router, ActivatedRoute } from '@angular/router';
import { BandMember } from './../../models/band-member';
import { BandMemberService } from './../../services/band-member.service';
import { ProfileService } from './../../services/profile.service';
import { Component, OnInit } from '@angular/core';
import { BandServiceService } from 'src/app/services/band-service.service';
import { AuthService } from 'src/app/services/auth.service';
import { Band } from 'src/app/models/band';
import { Profile } from 'src/app/models/profile';
import { userInfo } from 'os';
import { AddressService } from 'src/app/services/address.service';
import { Address } from 'src/app/models/address';
import { ImageService } from 'src/app/services/image.service';
import { identifierName } from '@angular/compiler';
import { Instrument } from 'src/app/models/instrument';
import { InstrumentService } from 'src/app/services/instrument.service';


@Component({
  selector: 'app-band',
  templateUrl: './band.component.html',
  styleUrls: ['./band.component.css']
})
export class BandComponent implements OnInit {

  // FIELDS

  // GREGS

  myBand: Band;
  myBandMembers: BandMember[];

  editBand: Band = null;
  editBandMember: BandMember = null;
  newBandMember: BandMember = null;
  selectedInstrumentId: number;
  instrumentList: Instrument[] = [];
  bandMemberCard: Band = null;
  viewerIsOwner = false;
  myViewerProfile: Profile = null;
  myViewerUsername: string;

  // for bootstrap
  // currentJustify = 'start';

  // profile: Profile = null;
  // title = 'Band Profile Page';
  // bands: Band[] = [];
  // band: Band;
  // bandMembers: BandMember[] = [];
  // selected: Band = null;
  // newBand: Band = new Band();
  // editBand: Band = null;


  // CONSTRUCTOR

  constructor(
    private auth: AuthService,
    private bandSvc: BandServiceService,
    private addressService: AddressService,
    private imageService: ImageService,
    private bandMemberService: BandMemberService,
    private profileSvc: ProfileService,
    private instrumentSvc: InstrumentService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  // INIT

  ngOnInit(
  ) {
    this.myViewerUsername = this.auth.getUsername();
    this.loadProfileByUser(this.myViewerUsername);
    this.loadBand(this.getRoute());
    this.loadInstruments();

    //LEGACY
    // this.getUserName();
    // this.reload();
  }

  // METHODS

  // METHODS - UTILITIES

  checkViewerIsOwner() {
    if (this.myViewerUsername === this.myBand.leader.user.username) {
      this.viewerIsOwner = true;
    } else {
      this.viewerIsOwner = false;
    }
  }

  getRoute() {
    return parseInt(this.route.snapshot.paramMap.get('id'), 10);
  }

  getUserName() {
    localStorage.setItem('username', this.auth.getUsername());
  }

  // displayTable(): void {
  //   this.selected = null;
  // }

  // setEditBand(): void {
  //   this.editBand = Object.assign({}, this.selected);
  // }

  // METHODS - BUTTONS

  bandRemoveProfileFromMember(bandMember: BandMember) {
    const member = Object.assign({}, bandMember);
    member.profile = null;
    this.updateMember(member);
  }

  bandRemovePosition(bandMember: BandMember) {
    const member = Object.assign({}, bandMember);
    if (member.profile) {
      member.profile = null;
    }
    member.active = false;
    this.updateMember(member);
  }

  bandEditPosition(bandMember: BandMember) {
    this.editBandMember = Object.assign({}, bandMember);
  }

  bandCancelEditPosition() {
    this.editBandMember = null;
  }

  bandSavePosition() {
    this.updateMember(this.editBandMember);
  }

  bandClaimPosition(bandMember: BandMember) {
    const member = Object.assign({}, bandMember);
    member.profile = this.myViewerProfile;
    this.updateMember(member);
  }

  bandAddNewBandMember() {
    this.newBandMember = new BandMember();
  }

  bandCancelAddBandMember() {
    this.newBandMember = null;
  }

  bandSaveAddBandMember() {
    this.newBandMember.instrument = new Instrument();
    this.newBandMember.instrument.id = this.selectedInstrumentId;
    this.newBandMember.band = this.myBand;
    this.newBandMember.active = true;
    this.createBandMember(this.newBandMember);
  }

  bandDeleteBand() {
    this.deleteBand();
  }

  bandEditBand() {
    this.editBand = Object.assign({}, this.myBand);
  }

  bandSaveBand() {
    this.updateBand(this.editBand);
  }

  bandCancelBand() {
    this.editBand = null;
  }

  goToProfile(profile: Profile) {
    if (profile != null) {
      this.router.navigateByUrl(`profiles/${profile.id}`);
    }
  }

  // METHODS - SERVICES

  // updateBand(id: number): void {
  //   id = this.editBand.id;
  //   this.bandSvc.update(id, this.editBand).subscribe(
  //       data => {
  //         this.reload();
  //         this.editBand = null;
  //         this.selected = data;
  //       },
  //       err => {
  //         console.error('BandComponent.updateBand(): Error');
  //         console.error(err);
  //       }
  //     );
  //   }

  // updateAddress(): void {
  //   this.addressService.update(this.editBand.address.id, this.editBand.address).subscribe(
  //     data => {
  //       this.reload();
  //       this.editBand = null;
  //       this.selected.address = data;
  //     },
  //     err => {
  //       console.error('BandComponent.updateAddress(): Error');
  //       console.error(err);
  //     }
  //   );
  // }

  // updateImage(): void {
  //   this.imageService.update(this.editBand.image.id, this.editBand.image).subscribe(
  //     data => {
  //       this.reload();
  //       this.editBand = null;
  //       this.selected.image = data;
  //     },
  //     err => {
  //       console.error('BandComponent.updateImage(): Error');
  //       console.error(err);
  //     }
  //   );
  // }

  // updateBandMembers(): void {
  //   this.bandMemberService.index(this.editBand.id, this.auth.getUsername()).subscribe(
  //     data => {
  //       this.reload();
  //       this.editBand = null;
  //       this.bandMembers = data;
  //     },
  //     err => {
  //       console.error('BandComponent.reload(): Error');
  //       console.error(err);
  //     }
  //   );
  // }

  // deleteBand(band: Band) {
  //   this.bandSvc.delete(band.id).subscribe(
  //     data => {
  //       this.router.navigateByUrl('profiles/' + this.myViewerProfile.id);
  //     },
  //     err => {
  //       console.error('BandComponent.deleteBand(): Error');
  //       console.error(err);
  //     }
  //   );
  // }

  // reload() {
  //   this.bandSvc.index(this.auth.getUsername()).subscribe(
  //     data => {
  //       this.bands = data;
  //     },
  //     err => {
  //       console.error('BandComponent.reload(): Error');
  //       console.error(err);
  //     }
  //   );
  // }

  loadBand(id: number) {
    this.bandSvc.show(id).subscribe(
      data => {
        this.myBand = data;
        this.checkViewerIsOwner();
        this.loadBandMembersByBandId(data.id);
      },
      err => {
        console.error('FAILED TO LOAD BAND BY ID (' + id + ')');
        console.error(err);
      }
    );
  }

  loadBandMembersByBandId(id: number) {
    this.bandMemberService.showByBandId(id).subscribe(
      data => {
        this.myBandMembers = data;
      },
      err => {
        console.error('FAILED TO LOAD BAND MEMBERS BY BAND ID (' + id + ')');
        console.error(err);
      }
    );
  }

  updateMember(member: BandMember) {
    this.bandMemberService.update(member.id, member).subscribe(
      data => {
        this.editBandMember = null;
        this.loadBandMembersByBandId(this.myBand.id);
      },
      err => {
        console.error('FAILED TO REMOVE PROFILE FROM BANDMEMBER ID (' + member.id + ')');
        console.error(err);
      }
    );
  }

  updateBand(band: Band) {
    this.bandSvc.update(band.id, band).subscribe(
      data => {
        this.editBand = null;
        this.loadBand(this.myBand.id);
      },
      err => {
        console.error('FAILED TO UPDATE BAND BY ID (' + band.id + ')');
        console.error(err);
      }
    );
  }

  loadProfileByUser(username: string) {
    this.profileSvc.showProfileByUsername(username).subscribe(
      data => {
        this.myViewerProfile = data;
      },
      err => {
        console.error('ERROR GETTING PROFILE BY USERNAME (' + username + ')');
        console.error(err);
      }
    );
  }

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

  createBandMember(bandMember: BandMember) {
    this.bandMemberService.create(bandMember).subscribe(
      data => {
        this.loadBandMembersByBandId(this.myBand.id);
        this.newBandMember = null;
      },
      err => {
        console.error('FAILED TO CREATE NEW BAND MEMBER');
        console.error(err);
      }
    );
  }

  deleteBand() {
    this.myBand.active = false;
    this.bandSvc.update(this.myBand.id, this.myBand).subscribe(
      data => {
        this.router.navigateByUrl('profiles/' + this.myViewerProfile.id);
      },
      err => {
        console.error('FAILED TO DELETE BAND BY ID (' + this.myBand.id + ')');
        console.error(err);
      }
    );
  }
}
