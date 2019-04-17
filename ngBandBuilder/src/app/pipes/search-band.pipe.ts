import { Band } from './../models/band';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchBand'
})
export class SearchBandPipe implements PipeTransform {

  transform(myBands: Band[], searchType?: string, searchKeyword?: string): any {
    if (searchType === undefined || searchType === '') {
      return myBands;
    }

    if (searchKeyword === undefined || searchKeyword === '') {
      return myBands;
    }


    let returnArray: Band[] = [];

    switch (searchType.toLowerCase()) {
      case 'city':
        for (const band of myBands) {
          if (band.address.city.toLowerCase().includes(searchKeyword.toLowerCase())) {
            returnArray.push(band);
          }
        }
        break;

      case 'state':
        for (const band of myBands) {
          if (band.address.state.toLowerCase().includes(searchKeyword.toLowerCase())) {
            returnArray.push(band);
          }
        }
        break;

      case 'zip':
        for (const band of myBands) {
          if (band.address.zip.toLowerCase().includes(searchKeyword.toLowerCase())) {
            returnArray.push(band);
          }
        }
        break;

      case 'name':
        for (const band of myBands) {
          if (band.name.toLowerCase().includes(searchKeyword.toLowerCase())) {
            returnArray.push(band);
          }
        }
        break;

      case 'genre':
        for (const band of myBands) {
          if (band.genre.toLowerCase().includes(searchKeyword.toLowerCase())) {
            returnArray.push(band);
          }
        }
        break;

      default:
        returnArray = Object.assign({}, myBands);
        break;
    }


    return returnArray;

  }

}
