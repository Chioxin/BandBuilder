export class BandRegistrationForm {

// Leader Fields
bandLeader: number;

// Address Fields
addressId: string;
addressStreet: string;
addressStreet2: string;
addressCity: string;
addressState: string;
addressZip: string;
addressPhone: string;

// Band Fields
bandAboutUs: string;
bandEmail: string;
bandGenre: string;
bandName: string;

// Time Fields
bandOneLabel: string;
bandOneField: number;
bandTwoLabel: string;

  constructor(
  bandLeader?: number,
  addressId?: string,
  addressStreet?: string,
  addressStreet2?: string,
  addressCity?: string,
  addressState?: string,
  addressZip?: string,
  addressPhone?: string,
  bandAboutUs?: string,
  bandEmail?: string,
  bandGenre?: string,
  bandName?: string,
  bandOneLabel?: string,
  bandOneField?: number,
  bandTwoLabel?: string,
  ) {
    this.bandLeader = bandLeader;
    this.addressId = addressId;
    this.addressStreet = addressStreet;
    this.addressStreet2 = addressStreet2;
    this.addressCity =  addressCity;
    this.addressState = addressState;
    this.addressZip = addressZip;
    this.addressPhone = addressPhone;
    this.bandAboutUs = bandAboutUs;
    this.bandEmail = bandEmail;
    this.bandGenre = bandGenre;
    this.bandName = bandName;
    this.bandOneLabel = bandOneLabel;
    this.bandOneField = bandOneField;
    this.bandTwoLabel = bandTwoLabel;
  }
}
