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

import com.github.zunix.ryoshi.api.models.Video;
import com.github.zunix.ryoshi.api.responses.videosresource.ChannelVideosResponse;
import com.github.zunix.ryoshi.api.responses.videosresource.TopVideosResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface VideosResource {

   /*
     Videos Resource

     API Reference:
     https://github.com/justintv/Twitch-API/blob/master/v3_resources/videos.md

  */

  /**
   * Request a specific {@link com.github.zunix.ryoshi.api.models.Video} object from the Twitch
   * API.
   *
   * @param videoID Video ID.
   * @return Returns a {@link com.github.zunix.ryoshi.api.models.Video} object.
   */
  @GET("/videos/{id}")
  Video getVideoByID(@Path("id") String videoID);


  /**
   * Requests the top videos from the Twitch API.
   *
   * @param game   Returns only videos from specific game.
   * @param limit  Maximum number of objects in array. Default is 10. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @param period Returns only videos created in time period. Valid values are week, month, or all.
   *               Default is week.
   * @return Returns a list of videos created in a given time period sorted by number of views, most
   * popular first.
   */
  @GET("/videos/top")
  TopVideosResponse getTopVideos(@Query("game") String game, @Query("limit") int limit,
                                 @Query("offset") int offset,
                                 @Query("period") String period);


  /**
   * Requests a list of videos of a specific channel name from the Twitch API.
   *
   * @param channelName Channel Name
   * @param limit       Maximum number of objects in array. Default is 10. Maximum is 100.
   * @param offset      Object offset for pagination. Default is 0.
   * @param broadcasts  Returns only broadcasts when true. Otherwise only highlights are returned.
   *                    Default is false.
   * @param hls         Returns only HLS VoDs when true. Otherwise only non-HLS VoDs are returned.
   *                    Default is false.
   * @return Returns a list of videos ordered by time of creation, starting with the most recent
   * from channel name.
   */
  @GET("/channels/{channelName}/videos")
  ChannelVideosResponse getChannelVideos(@Path("channelName") String channelName,
                                         @Query("limit") int limit, @Query("offset") int offset,
                                         @Query("broadcasts") boolean broadcasts,
                                         @Query("hls") boolean hls);

}
