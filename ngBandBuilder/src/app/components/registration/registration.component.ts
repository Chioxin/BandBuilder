import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { RegistrationForm } from './../../models/registration-form';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { ProfileService } from 'src/app/services/profile.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  // FIELDS

  regInfo: RegistrationForm = new RegistrationForm();

  // CONSTRUCTOR

  constructor(
    private profileSvc: ProfileService,
    private router: Router,
    private auth: AuthService
  ) { }

  // INIT

  ngOnInit() {
  }

  // METHODS

  registerUser() {
    const newUser = new User();
    newUser.username = this.regInfo.userUsername;
    newUser.password = this.regInfo.userPassword;

    this.auth.register(newUser).subscribe(
      dataRegister => {
        this.regInfo.userId = dataRegister.id;
        this.auth.login(this.regInfo.userUsername, this.regInfo.userPassword).subscribe(
          dataLogin => {
            this.createProfile();
          },
          err => {
            console.error('ERROR LOGGING IN');
            console.error(err);
          }
        );
      },
      err => {
        console.error('ERROR REGISTERING USER');
        console.error(err);
      }
    );

  }

  createProfile() {
    console.log(this.regInfo);
    this.profileSvc.create(this.regInfo).subscribe(
      dataProfile => {
        this.router.navigateByUrl('profiles/' + dataProfile.id);
      },
      err => {
        console.error('ERROR CREATING PROFILE');
        console.error(err);
      }
    );
  }

}
