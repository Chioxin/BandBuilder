import { Image } from './image';
export class Instrument {

  // Fields
  id: number;
  name: string;
  approved: boolean;
  image: Image;
  description: string;
  active: boolean;

  constructor(id?: number,
              name?: string,
              approved?: boolean,
              image?: Image,
              description?: string,
              active?: boolean) {
    this.id = id;
    this.name = name;
    this.approved = approved;
    this.image = image;
    this.description = description;
    this.active = active;
  }
}
