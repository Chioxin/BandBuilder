export class InstrumentForm {

  // Instrument Fields
  instrumentId: number;
  instrumentName: string;
  instrumentApproved: boolean;
  instrumentDescription: string;
  instrumentActive: boolean;


  // Image Fields
  imageId: number;
  imageURL: string;
  imageAlt: string;
  imageDescription: string;

  constructor(instrumentId?: number,
              instrumentName?: string,
              instrumentApproved?: boolean,
              instrumentDescription?: string,
              instrumentActive?: boolean,
              imageId?: number,
              imageURL?: string,
              imageAlt?: string,
              imageDescription?: string) {

    this.instrumentId = instrumentId;
    this.instrumentName = instrumentName;
    this.instrumentApproved = instrumentApproved;
    this.instrumentDescription = instrumentDescription;
    this.instrumentActive = instrumentActive;

    this.imageId = imageId;
    this.imageURL = imageURL;
    this.imageAlt = imageAlt;
    this.imageDescription = imageDescription;
  }

}
