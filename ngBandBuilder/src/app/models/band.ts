import { BandSocialMedia } from './band-social-media';
import { BandMember } from './band-member';
import { Address } from './address';
import { Profile } from './profile';
import { Image } from './image';
import { Event } from './event';

export class Band {
  id: number;
  name: string;
  aboutUs: string;
  genre: string;
  bandMembers: BandMember[];
  address: Address;
  leader: Profile;
  email: string;
  timeCommitment: string;
  createdAt: Date;
  updatedAt: Date;
  bandSocialMedia: BandSocialMedia[];
  image: Image;
  events: Event;
  active: boolean;

  constructor(
    id?: number,
    name?: string,
    aboutUs?: string,
    genre?: string,
    bandMembers?: BandMember[],
    address?: Address,
    leader?: Profile,
    email?: string,
    timeCommitment?: string,
    createdAt?: Date,
    updatedAt?: Date,
    bandSocialMedia?: BandSocialMedia[],
    image?: Image,
    events?: Event,
    active?: boolean

  ) {
    this.id = id;
    this.name = name;
    this.aboutUs = aboutUs;
    this.genre = genre;
    this.bandMembers = bandMembers;
    this.address = address;
    this.leader = leader;
    this.email = email;
    this.timeCommitment = timeCommitment;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.bandSocialMedia = bandSocialMedia;
    this.image = image;
    this.events = events;
    this.active = active;
  }
}
