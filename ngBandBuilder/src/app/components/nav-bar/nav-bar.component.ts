import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {


  // Fields
  newUser: User = new User();

  selected = '';

  constructor(private auth: AuthService,
    private router: Router) { }

  ngOnInit() {
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
    if (this.auth.checkLogin()) {

    }

  }

}
