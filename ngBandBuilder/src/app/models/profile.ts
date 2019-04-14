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
  active: boolean;

  constructor(
    id?: number,
    user?: User,
    firstName?: string,
    lastName?: string,
    email?: string,
    aboutMe?: string,
    address?: Address,
    image?: Image,
    createdAt?: string,
    updatedAt?: string,
    bands?: Band[],
    bandMembers?: BandMember[],
    instruments?: Instrument[],
    active?: boolean
  ) {
    this.id = id;
    this.user = user;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.aboutMe = aboutMe;
    this.address = address;
    this.image = image;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.bands = bands;
    this.bandMembers = bandMembers;
    this.instruments = instruments;
    this.active = active;
  }

}
