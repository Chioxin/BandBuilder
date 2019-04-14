import { BandRegistrationForm } from './../../models/band-registration-form';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-band-registration',
  templateUrl: './band-registration.component.html',
  styleUrls: ['./band-registration.component.css']
})
export class BandRegistrationComponent implements OnInit {
  bandRegistrationForm = new BandRegistrationForm('', undefined);

  constructor() { }

  ngOnInit() {
  }

}
