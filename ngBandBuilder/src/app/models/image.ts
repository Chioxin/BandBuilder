export class Image {

  id: number;
  url: string;
  description: string;
  alt: string;
  active: boolean;

  constructor(
    id?: number,
    url?: string,
    description?: string,
    alt?: string,
    active?: boolean
    ) {
      this.id = id;
      this.url = url;
      this.description = description;
      this.alt = alt;
      this.active = active;
    }

}
