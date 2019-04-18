import { AuthService } from './../../services/auth.service';
import { BandServiceService } from './../../services/band-service.service';
import { Band } from './../../models/band';
import { Component, OnInit } from '@angular/core';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // FIELDS
  bands: Band[] = [];
  searchBy = 'Name';
  searchKeyword = '';
  images = ['https://cdn.mos.cms.futurecdn.net/wpEgipYD7TJYpuYvbb3mi-320-80.jpg',
            'https://i.ytimg.com/vi/23pYfDKyfBk/maxresdefault.jpg',
            'https://www.amwpro.com/wp-content/uploads/band-on-a-stage.jpg'
          ];


  // CONSTRUCTOR

  constructor(
    private bandSvc: BandServiceService,
    private auth: AuthService,
    private route: Route,
    private router: Router,
    config: NgbCarouselConfig
  ) {  // customize default values of carousels used by this component tree
    config.interval = 5000;
    config.wrap = true;
    config.keyboard = false;
    config.pauseOnHover = true;
  }

  // INIT

  ngOnInit() {
    this.loadBands();
  }

  // METHODS

  loadBands() {
    this.bandSvc.indexAll().subscribe(
      data => {
        this.bands = data;
      },
      err => {
        console.log('ERROR GETTING ALL BANDS');
        console.log(err);
      }
    );
  }

  goToBand(band: Band) {
    if (this.auth.checkLogin) {
      this.router.navigateByUrl('')
    }
  }

}
