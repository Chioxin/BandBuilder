export class BandRegistrationForm {

// Leader Fields
bandLeader: string;

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
bandTimeCommitment: string;

  constructor(
  bandLeader: string,
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
  bandTimeCommitment?: string,
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
    this.bandTimeCommitment = bandTimeCommitment;
  }
}
