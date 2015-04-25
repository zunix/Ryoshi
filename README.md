##Disclaimer

This project is not sponsored or started by nor affiliated to Twitch Interactive, Inc.
in any possible way. 


##Overview

**Ryoshi** is a library for accessing the [Twitch API](https://github.com/justintv/Twitch-API) in Java. It use [Retrofit](https://github.com/square/retrofit) for
the HTTP communication and JSON serialization.




##Installation


###JAR

1. Download `Ryoshi-<version>.zip`.

2. Unzip `Ryoshi-<version>.zip` file.

3. Add `Ryoshi-<version>.jar`file into your classpath.

*Note: Since __Ryoshi__  use Retrofit you can grab the JAR from [here](https://search.maven.org/remote_content?g=com.squareup.retrofit&a=retrofit&v=LATEST)*


###Maven (currently not available)

```xml
<dependencies>
  <dependency>
    <groupId>com.github.zunix</groupId>
    <artifactId>ryoshi</artifactId>
    <version>version</version>
  </dependency>
  <dependency>
    <groupId>com.squareup.retrofit</groupId>
    <artifactId>retrofit</artifactId>
    <version>1.9.0</version>
  </dependency>
</dependencies>
```

##Getting Started

First we need to initialize **Ryoshi**.

```java

Ryoshi ryoshi = new Ryoshi();

```

The constructor also takes optional parameters. Depending on the type of API request
you wanna perform these parameters are required. 

#####Client ID

```java

String clientID = "twitch-clientId";
Ryoshi ryoshi = new Ryoshi(clientID);

```
*Note: Twitch require you to send your application's  __client_id__ with every request you make to ensure that your application is not rate limited.*

#####Client ID & Access Token

```java

String clientID = "twitch-clientId";
String accessToken = "user-accessToken";
Ryoshi ryoshi = new Ryoshi(clientID, accessToken);

```


###Requesting data from the Twitch API.

After initializing **Ryoshi** we can now request data from the Twitch API.

```java

import com.github.zunix.ryoshi.api.models.Team;

String clientID = "twitch-clientId";
Ryoshi ryoshi = new Ryoshi(clientID);

// Returns a Team object if Team "example" exist.
Team exampleTeam = ryoshi.team().getTeamByName("example");


```


###Sending data to the Twitch API.

**not done**


As you can see the **Ryoshi** follows a simple method chaining pattern.
First you call the endpoint or resource method from where you wanna retrieve data form
or send data to. After that call, you have access to the available methods from this endpoint / resource.


```java

Ryoshi ryoshi = new Ryoshi();

// Directs to Ingests endpoint and then calls the method from that endpoint.
ryoshi.ingests().getIngests();


```
For more information about all endpoints provided by the Twitch API and how to work with them in **Ryoshi**. you can check
out the project's [Wiki](https://github.com/zunix/Ryoshi/wiki)


###Currently supported Twitch API Endpoints

- ~~Blocks~~
- ~~Channels~~
- ~~Chat~~
- ~~Follows~~
- ~~Games~~
- Ingests
- ~~Root~~
- ~~Search~~
- ~~Streams~~
- ~~Subscriptions~~
- ~~Teams~~
- ~~Users~~
- ~~Videos~~

License
=======

    Copyright (c) 2015, Thomas Wolf (aka zunix) and
    contributors. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
