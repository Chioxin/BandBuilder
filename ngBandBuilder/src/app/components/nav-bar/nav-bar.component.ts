import { Profile } from './../../models/profile';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { FormGroup, NgForm } from '@angular/forms';
import { logging } from 'protractor';
import { userInfo } from 'os';
import { formArrayNameProvider } from '@angular/forms/src/directives/reactive_directives/form_group_name';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;

  // Fields
  newUser: User = new User();
  isLoggedIn = false;
  profile: Profile = new Profile();
  selected = '';

  constructor(private auth: AuthService,
    private router: Router) { }

  ngOnInit() {
    this.isLoggedIn = this.auth.checkLogin();
  }

  register() {
    this.auth.register(this.newUser).subscribe(
      data => {
        this.auth.login(this.newUser.username, this.newUser.password).subscribe(
          dataLogin => {
            this.selected = 'Yay! it has registered a login with usernaem and password';
          },
          err => {
            console.error(err);
          }
        );
      },
      err => {
        console.error(err);
      }
    );
    // this.newUser = new User();
  }

  login() {
    this.auth.login(this.newUser.username, this.newUser.password).subscribe(
      dataLogin => {
        this.selected = 'Logged in!!!';
        this.isLoggedIn = true;
        this.newUser = new User();
      },
      err => {
        console.error(err);
      }
    );
  }
  logout(navForm: NgForm) {
    this.auth.logout();
    this.isLoggedIn = false;
    this.selected = null;
    // navForm.reset();
  }
  admin() {

  }
}
