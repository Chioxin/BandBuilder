import { BandServiceService } from './../../services/band-service.service';
import { Band } from './../../models/band';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  // FIELDS
  bands: Band[] = [];

  // CONSTRUCTOR

  constructor(
    private bandSvc: BandServiceService
  ) { }

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

}
