import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchByKeyword'
})
export class SearchByKeywordPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
