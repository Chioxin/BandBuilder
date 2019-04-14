import { Component, OnInit } from '@angular/core';
import { BandRegistrationForm } from 'src/app/models/band-registration-form';
import { AuthService } from 'src/app/services/auth.service';
import { BandServiceService } from 'src/app/services/band-service.service';


@Component({
  selector: 'app-band-registration',
  templateUrl: './band-registration.component.html',
  styleUrls: ['./band-registration.component.css']
})
export class BandRegistrationComponent implements OnInit {
  // FIELDS
  bandRegistrationForm: BandRegistrationForm = new BandRegistrationForm();


  // display created json
  // bandRegistrationForm = new BandRegistrationForm('', undefined);

  constructor(
    private bandSvc: BandServiceService,
    private auth: AuthService
    ) { }

  ngOnInit() {
  }

  createBand() {
    console.log(this.bandRegistrationForm);
    this.bandSvc.create(this.bandRegistrationForm).subscribe(
      dataBand => {
        console.log('WE GOT HERE YAY');
        // ROUTE USER TO PROFILE PAGE HERE
      },
      err => {
        console.error('ERROR CREATING BAND');
        console.error(err);
      }
    );
  }

}
