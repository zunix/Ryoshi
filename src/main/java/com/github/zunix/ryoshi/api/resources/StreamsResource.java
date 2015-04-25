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

import com.github.zunix.ryoshi.api.responses.streamsresource.FeaturedStreamsResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamsResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamsSummaryResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface StreamsResource {

   /*
     Streams Resource

     API Reference:
     https://github.com/justintv/Twitch-API/blob/master/v3_resources/streams.md

  */

  /**
   * Requests a specific {@link com.github.zunix.ryoshi.api.models.Stream} object from the Twitch
   * API.
   *
   * @param channelName Channel Name
   * @return Returns a stream object if live.
   */
  @GET("/streams/{channelName}")
  StreamResponse getStreamByChannelName(@Path("channelName") String channelName);


  /**
   * Requests a list of active streams from the Twitch API.
   *
   * @param game     Streams categorized under game.
   * @param channel  Streams from a comma separated list of channels.
   * @param limit    Maximum number of objects in array. Default is 25. Maximum is 100.
   * @param offset   Object offset for pagination. Default is 0.
   * @param clientID Only shows streams from applications of client_id.
   * @return Returns a list of stream objects that are queried by a number of parameters sorted by
   * number of viewers descending.
   */
  @GET("/streams/")
  StreamsResponse getStreams(@Query("game") String game, @Query("channel") String channel,
                             @Query("limit") int limit,
                             @Query("offset") int offset,
                             @Query("client_id") String clientID);


  /**
   * Requests a list of featured stream objects.
   *
   * @param limit  Maximum number of objects in array. Default is 25. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @return Returns a list of featured (promoted) stream objects.
   */
  @GET("/streams/featured")
  FeaturedStreamsResponse getFeaturedStreams(@Query("limit") int limit,
                                             @Query("offset") int offset);


  /**
   * Requests a summary of current streams.
   *
   * @param game Only show stats for the set game
   * @return Returns a summary of current streams.
   */
  @GET("/streams/summary")
  StreamsSummaryResponse getStreamsSummary(@Query("game") String game);

}
