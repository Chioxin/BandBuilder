import { AuthService } from './../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-jesse-test-page',
  templateUrl: './jesse-test-page.component.html',
  styleUrls: ['./jesse-test-page.component.css']
})
export class JesseTestPageComponent implements OnInit {

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
              this.selected = 'Yay! it has registered a login';
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
}
