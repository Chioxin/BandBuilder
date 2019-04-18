export class RegistrationForm {

  // User Entity
	userId: number;
	userUsername: string;
	userPassword: string;
	userActive: boolean;
	userRole: string;

  // Profile Entity
  profileId: number;
  profileFirstName: string;
  profileLastName: string;
  profileEmail: string;
  profileAboutMe: string;
  profileActive: boolean;

  // Address Entity
  addressId: number;
  addressStreet: string;
  addressStreet2: string;
  addressCity: string;
  addressState: string;
  addressZip: string;
  addressPhone: string;

  // Image Entity
  imageId: number;
  imageURL: string;
  imageAlt: string;
  imageDescription: string;

  constructor(
  userId?: number,
  userUsername?: string,
  userPassword?: string,
  userActive?: boolean,
  userRole?: string,
  profileId?: number,
  profileFirstName?: string,
  profileLastName?: string,
  profileEmail?: string,
  profileAboutMe?: string,
  addressId?: number,
  addressStreet?: string,
  addressStreet2?: string,
  addressCity?: string,
  addressState?: string,
  addressZip?: string,
  addressPhone?: string,
  imageId?: number,
  imageURL?: string,
  imageAlt?: string,
  imageDescription?: string
  ) {
  this.userId = userId;
  this.userUsername = userUsername;
  this.userPassword = userPassword;
  this.userActive = userActive;
  this.userRole = userRole;
  this.profileId = profileId;
  this.profileFirstName = profileFirstName;
  this.profileLastName = profileLastName;
  this.profileEmail = profileEmail;
  this.profileAboutMe = profileAboutMe;
  this.addressId = addressId;
  this.addressStreet = addressStreet;
  this.addressStreet2 = addressStreet2;
  this.addressCity = addressCity;
  this.addressState = addressState;
  this.addressZip = addressZip;
  this.addressPhone = addressPhone;
  this.imageId = imageId;
  this.imageURL = imageURL;
  this.imageAlt = imageAlt;
  this.imageDescription = imageDescription;
  }
}
