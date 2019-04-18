import { Instrument } from './instrument';
import { Profile } from './profile';
export class UserInstrument {

  id: number;
  profile: Profile;
  instrument: Instrument;
  experience: string;
  description: string;
  active: boolean;

  constructor(
    id?: number,
    profile?: Profile,
    instrument?: Instrument,
    experience?: string,
    description?: string,
    active?: boolean
  ) {
    this.id = id;
    this.profile = profile;
    this.instrument = instrument;
    this.experience = experience;
    this.description = description;
    this.active = active;
  }
}
