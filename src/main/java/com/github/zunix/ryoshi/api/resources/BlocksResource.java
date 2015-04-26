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

import com.github.zunix.ryoshi.api.models.Block;
import com.github.zunix.ryoshi.api.responses.blocksresource.BlockedUserResponse;
import com.github.zunix.ryoshi.api.responses.blocksresource.UserBlockListResponse;

import retrofit.client.Response;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

public interface BlocksResource {
/*
    Blocks Resource
    API Reference: https://github.com/justintv/Twitch-API/blob/master/v3_resources/blocks.md

  */

  /**
   * Requests user's block list.
   *
   * @param ownerName The owner's username.
   * @param limit Maximum number of objects in array. Default is 25. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @return Returns a list of blocks objects on user's block list.
   * List sorted by recency, newest first.
   */
  @GET("/users/{username}/blocks")
  UserBlockListResponse getUsersBlockList(@Path("username") String ownerName,
                                          @Query("limit") int limit,
                                          @Query("offset") int offset);

  /**
   * Requests to add a user on the owners blocklist.
   *
   * @param ownerName The owner's username.
   * @param targetName Target username to block.
   * @return Adds :target to :user's block list. :user is the authenticated user and :target
   * is user to be blocked. Returns a blocks object.
   */
  @PUT("/users/{username}/blocks/{targetUsername}")
  BlockedUserResponse putUserOnBlocklist(@Path("username") String ownerName,
                           @Path("targetUsername") String targetName);

  /**
   * Rquest to delete a user from the owners blocklist.
   *
   * @param ownerName The owner's username.
   * @param targetName Target username to block.
   * @return 204 No Content if successful. 404 Not Found if :target not on :user's block list.
   * 422 Unprocessable Entity if delete failed.
   */
  @DELETE("/users/{username}/blocks/{targetUsername}")
  Response deleteUserFromBlockList(@Path("username") String ownerName,
                                 @Path("targetUsername") String targetName);
}
