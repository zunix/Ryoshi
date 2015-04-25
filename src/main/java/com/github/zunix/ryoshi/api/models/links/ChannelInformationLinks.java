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
package com.github.zunix.ryoshi.api.models.links;

public class ChannelInformationLinks {

  private String self;
  private String follows;
  private String commercial;
  private String stream_key;
  private String chat;
  private String features;
  private String subscriptions;
  private String editors;
  private String videos;
  private String teams;

  public String getSelf() {
    return self;
  }

  public String getFollows() {
    return follows;
  }

  public String getCommercial() {
    return commercial;
  }

  public String getStream_key() {
    return stream_key;
  }

  public String getChat() {
    return chat;
  }

  public String getFeatures() {
    return features;
  }

  public String getSubscriptions() {
    return subscriptions;
  }

  public String getEditors() {
    return editors;
  }

  public String getVideos() {
    return videos;
  }

  public String getTeams() {
    return teams;
  }
}

