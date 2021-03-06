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
package com.github.zunix.ryoshi.api.responses.blocksresource;

import com.google.gson.annotations.SerializedName;

import com.github.zunix.ryoshi.api.models.BlockedUser;
import com.github.zunix.ryoshi.api.models.User;
import com.github.zunix.ryoshi.api.models.links.SelfLink;

public class BlockedUserResponse {

  @SerializedName("_id")
  private int id;
  @SerializedName("updated_at")
  private String updatedAt;
  @SerializedName("_links")
  private SelfLink links;
  private User user;

  public int getId() {
    return id;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public SelfLink getLinks() {
    return links;
  }

  public User getUser() {
    return user;
  }
}
