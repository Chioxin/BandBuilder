import { Pipe, PipeTransform } from '@angular/core';
import { Profile } from '../models/profile';

@Pipe({
  name: 'searchByKeyword'
})
export class SearchByKeywordPipe implements PipeTransform {

  transform(profiles: Profile[], searchText: string): Profile[] {
    if (!profiles) {
      return profiles;
    }
    if (!searchText) {
      return profiles;
    }
    searchText = searchText.toLowerCase();

    return profiles.filter( data => {
      return data.user.username.toLowerCase().includes(searchText);
    });
  }

}
