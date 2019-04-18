import { Pipe, PipeTransform } from '@angular/core';
import { Instrument } from '../models/instrument';

@Pipe({
  name: 'myInstrumentFilter'
})
export class InstrumentPipe implements PipeTransform {

  transform(instruments: Instrument[], filterInstrument?: boolean): Instrument[] {

    const output: Instrument[] = [];
// tslint:disable-next-line: prefer-for-of
    for (let i = 0; i < instruments.length; i++) {
      if (instruments[i].approved === true) {
        output.push(instruments[i]);
      }
    }
    return output;
  }

}
