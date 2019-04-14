import { RegistrationForm } from './../../models/registration-form';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  // FIELDS

  regInfo: RegistrationForm = new RegistrationForm();

  // CONSTRUCTOR

  constructor() { }

  // INIT

  ngOnInit() {
  }

  // METHODS

}
