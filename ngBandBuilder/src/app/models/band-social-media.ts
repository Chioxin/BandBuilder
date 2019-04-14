import { SocialMedia } from './social-media';
import { Band } from './band';

export class BandSocialMedia {

  id: number;
  socialMedia: SocialMedia;
  band: Band;
  url: string;
  active: boolean;

  constructor(
    id?: number,
    socialMedia?: SocialMedia,
    band?: Band,
    url?: string,
    active?: boolean
  ) {
    this.id = id;
    this.socialMedia = socialMedia;
    this.band = band;
    this.url = url;
    this.active = active;
  }
}
