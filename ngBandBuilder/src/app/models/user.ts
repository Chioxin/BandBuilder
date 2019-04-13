export class User {


  // Fields
    id: number;
    username: string;
    password: string;
    active: boolean;
    role: string;
    enabled: boolean;

constructor(id?: number,
            username?: string,
            password?: string,
            active?: boolean,
            role?: string,
            enabled?: boolean) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.active = active;
    this.role = role;
    this.enabled = enabled;
}
}
