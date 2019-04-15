import { ProfileService } from './../../services/profile.service';
import { Component, OnInit } from '@angular/core';
import { BandServiceService } from 'src/app/services/band-service.service';
import { AuthService } from 'src/app/services/auth.service';
import { Band } from 'src/app/models/band';
import { Profile } from 'src/app/models/profile';
import { userInfo } from 'os';


@Component({
  selector: 'app-band',
  templateUrl: './band.component.html',
  styleUrls: ['./band.component.css']
})
export class BandComponent implements OnInit {
  // user = '';
  profile: Profile = null;

  title = 'Band Profile Page';
  bands: Band[] = [];
  band: Band;
  selected: Band = null;
  newBand: Band = new Band();
  editBand: Band = null;

  constructor(
    private auth: AuthService,
    private bandSvc: BandServiceService,
    private profileSvc: ProfileService
  ) { }

  ngOnInit(
  ) {
    this.getUserName();
    this.reload();
  }

  getUserName() {
    localStorage.setItem('username', this.auth.getUsername());
  }

  displayTable(): void {
    this.selected = null;
  }

  setEditBand(): void {
    this.editBand = Object.assign({}, this.selected);
  }

  updateBand(id: number): void {
    id = this.editBand.id;
    this.bandSvc.update(id, this.editBand).subscribe(
        data => {
          this.reload();
          this.editBand = null;
          this.selected = data;
        },
        err => {
          console.error('BandComponent.updateBand(): Error');
          console.error(err);
        }
      );
    }

    deleteBand(band: Band) {
      // this.todoService.delete(todo);
      // this.todos = this.todoService.index();
      this.bandSvc.delete(band.id).subscribe(
        data => {
          this.reload();
        },
        err => {
          console.error('BandComponent.deleteBand(): Error');
          console.error(err);
        }
      );
    }

  reload() {
    this.bandSvc.index(this.auth.getUsername()).subscribe(
      data => {
        this.bands = data;
      },
      err => {
        console.error('BandComponent.reload(): Error');
        console.error(err);
      }
    );
  }



}
