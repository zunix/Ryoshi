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

import com.github.zunix.ryoshi.api.responses.chatresource.BadgesResponse;
import com.github.zunix.ryoshi.api.responses.chatresource.ChatChannelNameResponse;
import com.github.zunix.ryoshi.api.responses.chatresource.EmoticonsResponse;

import retrofit.http.GET;
import retrofit.http.Path;

public interface ChatResource {

  /*
    Chat Resource
    API Reference: https://github.com/justintv/Twitch-API/blob/master/v3_resources/chat.md

  */

  /**
   * Requests links to all other chat endpoints.
   *
   * @param channelName Channel Name
   * @return Returns a links object to all other chat endpoints.
   */
  @GET("/chat/{channelName}")
  ChatChannelNameResponse getChatEndpointsByChannelName(@Path("channelName") String channelName);


  /**
   * Requests all Twitch emoticons information.
   *
   * @return Returns a list of all emoticon objects for Twitch.
   */
  @GET("/chat/emoticons")
  EmoticonsResponse getAllEmoticons();


  /**
   * Requests a list of chat badges from a specific Channel.
   *
   * @param channelName Channel Name
   * @return Returns a list of chat badges that can be used in the :channel's chat.
   */
  @GET("/chat/{channelName}/badges")
  BadgesResponse getBadgesByChannelName(@Path("channelName") String channelName);
}
