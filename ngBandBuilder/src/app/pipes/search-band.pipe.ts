import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchBand'
})
export class SearchBandPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
