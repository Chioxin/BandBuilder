# BandBuilder

## REST Routes for Profiles:

| Return Type      | Route                     | Functionality                      |
|------------------|---------------------------|------------------------------------|
| `List<Profile>`  |`GET api/profiles/`        | Gets all profiles                  |
| `Profile`        |`GET api/profiles/{id}`    | Gets profile by id                 |
| `Profile`        |`POST api/profiles/`       | Creates a new profile              |
| `Profile`        |`PUT api/profiles/{id}`    | Updates an existing profile by id  |
| `Boolean`        |`DELETE api/profiles/{id}` | Delete an existing profile by id   |

## REST Routes for Instruments:

| Return Type         | Route                        | Functionality                        |
|---------------------|------------------------------|--------------------------------------|
| `List<Instrument>`  |`GET api/instruments/`        | Gets all instruments                 |
| `Instrument`        |`GET api/instruments/{id}`    | Gets instrument by id                |
| `Instrument`        |`POST api/instruments/`       | Creates a new instrument             |
| `Instrument`        |`PUT api/instruments/{id}`    | Updates an existing instrument by id |
| `Boolean`           |`DELETE api/instruments/{id}` | Delete an existing instrument by id  |

## REST Routes for Bands:

| Return Type      | Route                        | Functionality                  |
|------------------|------------------------------|--------------------------------|
| `List<Band>`     |`GET api/bands/`              | Gets all bands                 |
| `Band`           |`GET api/bands/{id}`          | Gets band by id                |
| `List<Band>`     |`GET api/profiles/{id}/bands` | Gets band by id                |
| `Band`           |`POST api/bands/`             | Creates a new band             |
| `Band`           |`PUT api/bands/{id}`          | Updates an existing band by id |
| `Boolean`        |`DELETE api/bands/{id}`       | Delete an existing band by id  |

## REST Routes for Band Members:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `List<BandMember>`  |`GET api/bands/{id}/bandmembers` | Gets all band members by id           |
| `BandMember`        |`GET api/bandmembers/{id}`       | Gets band member by id                |
| `BandMember`        |`POST api/bandmembers/`          | Creates a new band member             |
| `BandMember`        |`PUT api/bandmembers/{id}`       | Updates an existing band member by id |  
| `Boolean`           |`DELETE api/bandmembers/{id}`    | Delete an existing band by id         |

## REST Routes for Images:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `Image`             |`GET api/images/{id}`            | Gets image by id                      |
| `List<Image>`       |`GET api/bands/{id}/images`      | Gets all images by id                 |
| `Image`             |`POST api/images/`               | Creates a new image                   |
| `Image`             |`PUT api/images/`                | Updates an existing image by id       |
| `Boolean`           |`DELETE api/images/{id}`         | Delete an existing image by id        |

## REST Routes for Social Media:

| Return Type         | Route                           | Functionality                         |
|---------------------|---------------------------------|---------------------------------------|
| `SocialMedia`       |`GET api/socialmedia/{name}`     | Gets social media by name             |
| `List<SocialMedia>` |`GET api/socialmedia/`           | Gets all social media                 |

## REST Routes for Band Social Media:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<BandSocialMedia>`   |`GET api/bands/{id}/bandsocialmedia/`     | Gets all band social media by id            |
| `BandSocialMedia`         |`GET api/bandsocialmedia/{id}`            | Gets band social media by id                |
| `BandSocialMedia`         |`POST api/bandsocialmedia/`               | Creates a new band social media             |
| `BandSocialMedia`         |`PUT api/bandsocialmedia/{id}`            | Updates an existing band social media by id |
| `Boolean`                 |`DELETE api/bandsocialmedia/{id}`         | Delete an existing band social media by id  |

## REST Routes for User Instruments:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<UserInstrument>`    |`GET api/profiles/{id}/userinstruments/`  | Gets all user instruments by id             |
| `UserInstrument`          |`GET api/userinstruments/{id}`            | Gets user instrument by id                  |
| `UserInstrument`          |`POST api/userinstruments/`               | Creates a new user instrument               |
| `UserInstrument`          |`PUT api/userinstruments/{id}`            | Updates a user instrument by id             |
| `Boolean`                 |`DELETE api/userinstruments/{id}`         | Deletes a user instrument by id             |

## REST Routes for Events:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `List<Event>`             |`GET api/bands/{id}/events`               | Gets all events by id                       |
| `Event`                   |`GET api/events/{id}`                     | Gets all events by id                       |
| `Event`                   |`POST api/events/`                        | Creates a new event                         |
| `Event`                   |`PUT api/events/{id}`                     | Updates an event by id                      |
| `Boolean`                 |`DELETE api/events/{id}`                  | Deletes an event by id                      |

## REST Routes for Users:

| Return Type               | Route                                    | Functionality                               |
|---------------------------|------------------------------------------|---------------------------------------------|
| `User`                    |`GET api/users/{id}`                      | Gets a user by id                           |
| `User`                    |`POST api/users/`                         | Creates a new user                          |
| `User`                    |`PUT api/users/{id}`                      | Updates a user by id                        |
| `Boolean`                 |`DELETE api/users/{id}`                   | Deletes a users by id                       |
