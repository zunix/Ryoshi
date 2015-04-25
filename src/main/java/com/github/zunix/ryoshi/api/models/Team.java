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
package com.github.zunix.ryoshi.api.models;

import com.google.gson.annotations.SerializedName;

import com.github.zunix.ryoshi.api.models.links.SelfLink;

public class Team {

  @SerializedName("_id")
  private int id;
  private String name;
  private String info;
  @SerializedName("display_name")
  private String displayName;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("updated_at")
  private String updatedAt;
  private String logo;
  private String banner;
  private String background;
  @SerializedName("_links")
  private SelfLink links;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getInfo() {
    return info;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public String getLogo() {
    return logo;
  }

  public String getBanner() {
    return banner;
  }

  public String getBackground() {
    return background;
  }

  public SelfLink getLinks() {
    return links;
  }
}
