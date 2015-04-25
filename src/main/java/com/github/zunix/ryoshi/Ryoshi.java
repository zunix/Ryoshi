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
import com.github.zunix.ryoshi.api.resources.BlocksResource;
import com.github.zunix.ryoshi.api.resources.ChannelsResource;
import com.github.zunix.ryoshi.api.resources.ChatResource;
import com.github.zunix.ryoshi.api.resources.FollowsResource;
import com.github.zunix.ryoshi.api.resources.GamesResource;
import com.github.zunix.ryoshi.api.resources.IngestsResource;
import com.github.zunix.ryoshi.api.resources.RootResource;
import com.github.zunix.ryoshi.api.resources.SearchResource;
import com.github.zunix.ryoshi.api.resources.StreamsResource;
import com.github.zunix.ryoshi.api.resources.SubscriptionsResource;
import com.github.zunix.ryoshi.api.resources.TeamResource;
import com.github.zunix.ryoshi.api.resources.UsersResource;
import com.github.zunix.ryoshi.api.resources.VideosResource;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

public class Ryoshi {

  private final String twitchAPIBaseURL = "https://api.twitch.tv/kraken";
  private String clientID;
  private String accessToken;
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
  private RestAdapter restAdapter;

  private IngestsResource ingestsResource;
  private TeamResource teamResource;
  private VideosResource videosResource;
  private RootResource rootResource;
  private UsersResource usersResource;
  private GamesResource gamesResource;
  private StreamsResource streamsResource;
  private ChatResource chatResource;
  private BlocksResource blocksResource;
  private ChannelsResource channelsResource;
  private SubscriptionsResource subscriptionsResource;
  private FollowsResource followsResource;
  private SearchResource searchResource;


  public Ryoshi(boolean loggingEnable) {
    if(loggingEnable){
      restAdapter = new RestAdapter.Builder()
          .setLogLevel(RestAdapter.LogLevel.FULL)
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    } else {
      restAdapter = new RestAdapter.Builder()
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    }
    initResources();
  }

  public Ryoshi(String clientID, boolean loggingEnable) {
    this.clientID = clientID;
    if(loggingEnable){
      restAdapter = new RestAdapter.Builder()
          .setLogLevel(RestAdapter.LogLevel.FULL)
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    } else {
      restAdapter = new RestAdapter.Builder()
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    }
    initResources();
  }

  public Ryoshi(String clientID, String accessToken, boolean loggingEnable) {
    this.accessToken = accessToken;
    this.clientID = clientID;
    if(loggingEnable){
      restAdapter = new RestAdapter.Builder()
          .setLogLevel(RestAdapter.LogLevel.FULL)
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    } else {
      restAdapter = new RestAdapter.Builder()
          .setEndpoint(twitchAPIBaseURL)
          .setRequestInterceptor(requestInterceptor)
          .setErrorHandler(new TwitchErrorHandler())
          .build();
    }
    initResources();
  }


  /**
   * @return IngestsResource Interface
   */
  public IngestsResource ingests() {
    return ingestsResource;
  }

  /**
   * @return TeamResource Interface
   */
  public TeamResource team() {
    return teamResource;
  }

  /**
   * @return VideosResource Interface
   */
  public VideosResource videos() {
    return videosResource;
  }

  /**
   * @return RootResource Interface
   */
  public RootResource root() {
    return rootResource;
  }

  /**
   * @return UsersResource Interface
   */
  public UsersResource users() {
    return usersResource;
  }

  /**
   * @return GameResource Interface
   */
  public GamesResource games() {
    return gamesResource;
  }

  /**
   * @return StreamResource Interface
   */
  public StreamsResource streams() {
    return streamsResource;
  }

  /**
   * @return ChatResource Interface
   */
  public ChatResource chat() {
    return chatResource;
  }

  /**
   * @return BlocksResource Interface
   */
  public BlocksResource blocks() {
    return blocksResource;
  }

  /**
   * @return ChannelsResource Interface
   */
  public ChannelsResource channels() {
    return channelsResource;
  }

  /**
   * @return SubscriptionsResource Interface
   */
  public SubscriptionsResource subscriptions() {
    return subscriptionsResource;
  }

  /**
   * @return FollowsResource Interface
   */
  public FollowsResource follows() {
    return followsResource;
  }

  /**
   * @return SearchResource Interface
   */
  public SearchResource search() {
    return searchResource;
  }

  private void initResources() {
    ingestsResource = restAdapter.create(IngestsResource.class);
    teamResource = restAdapter.create(TeamResource.class);
    videosResource = restAdapter.create(VideosResource.class);
    rootResource = restAdapter.create(RootResource.class);
    usersResource = restAdapter.create(UsersResource.class);
    gamesResource = restAdapter.create(GamesResource.class);
    streamsResource = restAdapter.create(StreamsResource.class);
    chatResource = restAdapter.create(ChatResource.class);
    blocksResource = restAdapter.create(BlocksResource.class);
    channelsResource = restAdapter.create(ChannelsResource.class);
    subscriptionsResource = restAdapter.create(SubscriptionsResource.class);
    followsResource = restAdapter.create(FollowsResource.class);
    searchResource = restAdapter.create(SearchResource.class);
  }


}
