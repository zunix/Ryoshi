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

public class RootLinks {

  private String user;
  private String channel;
  private String search;
  private String streams;
  private String ingests;
  private String teams;
  private String users;
  private String channels;
  private String chat;

  public String getUser() {
    return user;
  }

  public String getChannel() {
    return channel;
  }

  public String getSearch() {
    return search;
  }

  public String getStreams() {
    return streams;
  }

  public String getIngests() {
    return ingests;
  }

  public String getTeams() {
    return teams;
  }

  public String getUsers() {
    return users;
  }

  public String getChannels() {
    return channels;
  }

  public String getChat() {
    return chat;
  }
}
