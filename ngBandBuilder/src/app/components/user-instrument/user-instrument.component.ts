import { UserInstrument } from './../../models/user-instrument';
import { Component, OnInit } from '@angular/core';
import { UserInstrumentService } from 'src/app/services/user-instrument.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-instrument',
  templateUrl: './user-instrument.component.html',
  styleUrls: ['./user-instrument.component.css']
})
export class UserInstrumentComponent implements OnInit {
  editUserInstrument: UserInstrument;

  getRoute() {
    return parseInt(this.route.snapshot.paramMap.get('id'), 10);
  }

  loadUserInstrumentById() {
    const route = this.getRoute();
    this.userInstrumentService.select(route).subscribe(
      data => {
        this.editUserInstrument = data;
      },
      err => {
        console.error('err getting userInstrument');
        console.error(err);
      }
    );
  }

  updateUserInstrument() {
    const route = this.getRoute();
    this.userInstrumentService.update(route, this.editUserInstrument).subscribe(
      data => {
        this.editUserInstrument = data;
      },
      err => {
        console.error('err getting userInstrument');
        console.error(err);
      }
    );
  }

  redirectUserInstrument() {
    this.router.navigate(['/profiles/']);
  }

  cancelEdit() {
    this.redirectUserInstrument();
  }

  deleteUserInstrument() {
    const route = this.getRoute();
    this.userInstrumentService.delete(route).subscribe(
      data => {
        this.editUserInstrument = data;
      },
      err => {
        console.error('err getting userInstrument');
        console.error(err);
      }
    );
    this.redirectUserInstrument();
  }

  constructor(
    private userInstrumentService: UserInstrumentService,
    private auth: AuthService,
    private router: Router,
    private route: ActivatedRoute,
    ) { }

  ngOnInit() {
    this.loadUserInstrumentById();
  }

}
