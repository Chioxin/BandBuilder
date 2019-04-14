export class Address {

id: number;
street: string;
street2: string;
city: string;
state: string;
zip: string;
phone: string;
createdAt: string;
updatedAt: string;
active: boolean;

constructor(
  id?: number,
  street?: string,
  street2?: string,
  city?: string,
  state?: string,
  zip?: string,
  phone?: string,
  createdAt?: string,
  updatedAt?: string,
  active?: boolean
) {
  this.id =  id;
  this.street =  street;
  this.street2 =  street2;
  this.city =  city;
  this.state =  state;
  this.zip =  zip;
  this.phone =  phone;
  this.createdAt =  createdAt;
  this.updatedAt =  updatedAt;
  this.active = active;
}


}
