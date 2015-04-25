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

import com.github.zunix.ryoshi.api.models.AuthenticatedUser;
import com.github.zunix.ryoshi.api.models.User;
import com.github.zunix.ryoshi.api.responses.usersresource.FollowedStreamsResponse;
import com.github.zunix.ryoshi.api.responses.usersresource.FollowedVideosResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface UsersResource {

  /*
     Users Resource

     API Reference:
     https://github.com/justintv/Twitch-API/blob/master/v3_resources/users.md

  */

  /**
   *
   * @param username Username
   * @return Returns a user object.
   */
  @GET("/users/{user}")
  User getUserByUsername(@Path("user") String username);

  /**
   *
   * @return Returns the user object of the authenticated user.
   */
  @GET("/user")
  AuthenticatedUser getAuthenticatedUser();

  /**
   *
   * @param limit Maximum number of objects in array. Default is 25. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @return Returns a list of stream objects that the authenticated user is following.
   */
  @GET("/streams/followed")
  FollowedStreamsResponse getFollowedStreams(@Query("limit") int limit,
                                             @Query("offset") int offset);

  /**
   *
   * @param limit Maximum number of objects in array. Default is 25. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @return Returns a list of video objects from channels that the authenticated user is following.
   */
  @GET("/videos/followed")
  FollowedVideosResponse getFollowedVideos(@Query("limit") int limit, @Query("offset") int offset);




}
