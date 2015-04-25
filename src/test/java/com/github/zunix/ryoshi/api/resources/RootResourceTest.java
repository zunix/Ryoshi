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
package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.responses.rootresource.RootResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;

import static org.junit.Assert.assertEquals;

public class RootResourceTest {

  private String clientID;
  private String accessToken;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;

  @Before
  public void initialize() {
    clientID = "";
    accessToken = "";
    ryoshi = new Ryoshi(clientID,accessToken);
    httpClient = new OkHttpClient();
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.RootResource#getRoot}
   *
   * Expected Results from https://api.twitch.tv/kraken
   * @throws Exception
   */
  @Test
  public void validateRootResponseAuthenticated() throws Exception {
    String expectedResultsURI = "https://api.twitch.tv/kraken";

    Request request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    RootResponse rootResponse = ryoshi.root().getRoot();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testRootResponseJson = gson.toJson(rootResponse);
    assertEquals("Fail - Root JSON don't match!", expectedResults, testRootResponseJson);
  }
}
