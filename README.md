# BandBuilder

## REST Routes for Profiles:

| Return Type      | Route                     | Functionality                      |
|------------------|---------------------------|------------------------------------|
| `List<Profile>`  |`GET api/profiles`        | Get all profiles                   |
| `Profile`        |`GET api/profiles/{id}`    | Get profile by id                  |
| `Profile`        |`POST api/profiles`       | Create a new profile               |
| `Profile`        |`PUT api/profiles/{id}`    | Update an existing profile by id   |
| `Void`           |`DELETE api/profiles/{id}` | Delete an existing profile by id   |

## REST Routes for Addresses:

| Return Type      | Route                 | Functionality                      |
|------------------|-----------------------|------------------------------------|
| `Address`  |`GET api/addresses/{id}`     | Get address by id                  |
| `Address`  |`POST api/addresses/`        | Create a new address               |
| `Address`  |`PUT api/addresses/{id}`     | Update an existing address by id   |
| `Address`  |`DELETE api/addresses/{id}`  | Delete an existing address by id   |

## REST Routes for Instruments:

| Return Type         | Route                        | Functionality                        |
|---------------------|------------------------------|--------------------------------------|
| `List<Instrument>`  |`GET api/instruments`        | Get all instruments                  |
| `Instrument`        |`GET api/instruments/{id}`    | Get instrument by id                 |
| `Instrument`        |`POST api/instruments`       | Create a new instrument              |
| `Instrument`        |`PUT api/instruments/{id}`    | Update an existing instrument by id  |
| `Void`              |`DELETE api/instruments/{id}` | Delete an existing instrument by id  |

## REST Routes for Bands:

| Return Type      | Route                        | Functionality                  |
|------------------|------------------------------|--------------------------------|
| `List<Band>`     |`GET api/bands`              | Get all bands                  |
| `Band`           |`GET api/bands/{id}`          | Get band by id                 |
| `List<Band>`     |`GET api/profiles/{id}/bands` | Get all bands by profile id    |
| `Band`           |`POST api/bands`             | Create a new band              |
| `Band`           |`PUT api/bands/{id}`          | Update an existing band by id  |
| `Void`           |`DELETE api/bands/{id}`       | Delete an existing band by id  |

## REST Routes for Band Members:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `List<BandMember>`  |`GET api/bands/{id}/bandmembers` | Get all band members by band id       |
| `BandMember`        |`GET api/bandmembers/{id}`       | Get band member by id                 |
| `BandMember`        |`POST api/bandmembers`          | Create a new band member              |
| `BandMember`        |`PUT api/bandmembers/{id}`       | Update an existing band member by id  |  
| `Void`              |`DELETE api/bandmembers/{id}`    | Delete an existing band by id         |

## REST Routes for Images:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `Image`             |`GET api/images/{id}`            | Get image by id                       |
| `Image`             |`POST api/images`               | Create a new image                    |
| `Image`             |`PUT api/images`                | Update an existing image by id        |
| `Void`              |`DELETE api/images/{id}`         | Delete an existing image by id        |

## REST Routes for Social Media:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `SocialMedia`       |`GET api/socialmedia/{name}`     | Get social media by name              |
| `List<SocialMedia>` |`GET api/socialmedia`           | Get all social media                  |

## REST Routes for Band Social Media:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<BandSocialMedia>`   |`GET api/bands/{id}/bandsocialmedia`     | Get all band social media by band id        |
| `BandSocialMedia`         |`GET api/bandsocialmedia/{id}`            | Get band social media by id                 |
| `BandSocialMedia`         |`POST api/bandsocialmedia`               | Create a new band social media              |
| `BandSocialMedia`         |`PUT api/bandsocialmedia/{id}`            | Update an existing band social media by id  |
| `Void`                    |`DELETE api/bandsocialmedia/{id}`         | Delete an existing band social media by id  |

## REST Routes for User Instruments:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<UserInstrument>`    |`GET api/profiles/{id}/userinstruments`  | Get all user instruments by profile id      |
| `UserInstrument`          |`GET api/userinstruments/{id}`            | Get user instrument by id                   |
| `UserInstrument`          |`POST api/userinstruments`               | Create a new user instrument                |
| `UserInstrument`          |`PUT api/userinstruments/{id}`            | Update a user instrument by id              |
| `Void`                    |`DELETE api/userinstruments/{id}`         | Delete a user instrument by id              |

## REST Routes for Events:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<Event>`             |`GET api/bands/{id}/events`               | Get all events by band id                   |
| `Event`                   |`GET api/events/{id}`                     | Get all events by id                        |
| `Event`                   |`POST api/events`                        | Create a new event                          |
| `Event`                   |`PUT api/events/{id}`                     | Update an event by id                       |
| `Void`                    |`DELETE api/events/{id}`                  | Delete an event by id                       |

## REST Routes for Users:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `User`                    |`GET api/users/{id}`                      | Get a user by id                            |
| `User`                    |`POST api/users`                         | Create a new user                           |
| `User`                    |`PUT api/users/{id}`                      | Update a user by id                         |
| `Void`                    |`DELETE api/users/{id}`                   | Delete a user by id                         |
