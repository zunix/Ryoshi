/*
 * Copyright (c) 2015, Thomas Wolf (aka zunix) and
 * contributors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.zunix.ryoshi;

import com.github.zunix.ryoshi.api.errorhandlers.TwitchErrorHandler;
import com.github.zunix.ryoshi.api.resources.IngestsResource;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class Ryoshi {

  private String clientID;
  private String accessToken;
  private RestAdapter.LogLevel logLevel;
  private final String twitchAPIBaseURL = "https://api.twitch.tv/kraken";
  private final RequestInterceptor requestInterceptor = new RequestInterceptor() {
    @Override
    public void intercept(RequestInterceptor.RequestFacade request) {
      String twitchMIME = "application/vnd.twitchtv.v3+json";
      request.addHeader("Accept", twitchMIME);
      if (clientID != null && !clientID.isEmpty()) {
        request.addHeader("Client-ID", clientID);
      }
      if (accessToken != null && !accessToken.isEmpty()) {
        request.addHeader("Authorization", "OAuth " + accessToken);
      }
    }
  };
  private RestAdapter simpelRestAdapter = new RestAdapter.Builder()
      .setEndpoint(twitchAPIBaseURL)
      .setRequestInterceptor(requestInterceptor)
      .setErrorHandler(new TwitchErrorHandler())
      .build();

  private IngestsResource ingestsResource;


  public Ryoshi() {
    ingestsResource = getAdapter().create(IngestsResource.class);
  }

  public Ryoshi(String clientID) {
    this.clientID = clientID;
    ingestsResource = getAdapter().create(IngestsResource.class);
  }

  public Ryoshi(String clientID, String accessToken) {
    this.accessToken = accessToken;
    this.clientID = clientID;
    ingestsResource = getAdapter().create(IngestsResource.class);
  }


  /**
   *
   * @return IngestsResource Interface
   */
  public IngestsResource ingests() { return ingestsResource; }



  /**
   * Returns a RestAdapter.
   *
   * @return RestAdapter
   */
  private RestAdapter getAdapter() {
    return simpelRestAdapter;
  }


}
