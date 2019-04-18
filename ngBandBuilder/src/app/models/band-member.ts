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
  active: boolean;

  constructor(
    id?: number,
    band?: Band,
    instrument?: Instrument,
    profile?: Profile,
    description?: string,
    experience?: string,
    createdAt?: Date,
    joinedAt?: Date,
    active?: boolean
  ) {
    this.id = id;
    this.band = band;
    this.instrument = instrument;
    this.profile = profile;
    this.description = description;
    this.experience = experience;
    this.createdAt = createdAt;
    this.joinedAt = joinedAt;
    this.active = active;
  }

}
