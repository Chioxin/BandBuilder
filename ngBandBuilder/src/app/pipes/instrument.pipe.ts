import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'instrument'
})
export class InstrumentPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
