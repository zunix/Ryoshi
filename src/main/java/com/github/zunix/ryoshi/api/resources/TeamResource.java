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

import com.github.zunix.ryoshi.api.models.Team;
import com.github.zunix.ryoshi.api.responses.teamresource.TeamResponse;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface TeamResource {

  /*
     Teams Resource

     API Reference:
     https://github.com/justintv/Twitch-API/blob/master/v3_resources/teams.md

  */

  /**
   * Requests a list of active teams from the Twitch API.
   *
   * @param limit  Maximum number of objects in array. Default is 10. Maximum is 100.
   * @param offset Object offset for pagination. Default is 0.
   * @return Returns a list of active teams.
   */
  @GET("/teams")
  TeamResponse getTeams(@Query("limit") int limit, @Query("offset") int offset);

  /**
   * Request a specific {@link com.github.zunix.ryoshi.api.models.Team} from the Twitch API.
   *
   * @param teamName Team Name
   * @return Returns a {@link com.github.zunix.ryoshi.api.models.Team} object.
   */
  @GET("/teams/{team}")
  Team getTeamByName(@Path("team") String teamName);
}
