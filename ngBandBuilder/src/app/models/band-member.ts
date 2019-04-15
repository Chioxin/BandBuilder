import { Profile } from './profile';
import { Band } from './band';
import { Instrument } from './instrument';
export class BandMember {

  id: number;
  band: Band;
  instrument: Instrument;
  profile: Profile;
  description: string;
  experience: string;
  createdAt: Date;
  joinedAt: Date;

  constructor(
    id?: number,
    band?: Band,
    instrument?: Instrument,
    profile?: Profile,
    description?: string,
    experience?: string,
    createdAt?: Date,
    joinedAt?: Date
  ) {
    this.id = id;
    this.band = band;
    this.instrument = instrument;
    this.profile = profile;
    this.description = description;
    this.experience = experience;
    this.createdAt = createdAt;
    this.joinedAt = joinedAt;
  }

}
