import { Instrument } from './instrument';
import { Band } from './band';
import { Image } from './image';
import { Address } from './address';
import { User } from 'src/app/models/user';
import { BandMember } from './band-member';
export class Profile {

  id: number;
	user: User;
	firstName: string;
	lastName: string;
	email: string;
	aboutMe: string;
	address: Address;
  image: Image;
	createdAt: string;
	updatedAt: string;
	bands: Band[];
	bandMembers: BandMember[];
	instruments: Instrument[];
	active;

}
