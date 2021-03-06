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

public class Stream {

  @SerializedName("_id")
  private long id;
  private String game;
  private int viewers;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("video_height")
  private int videoHeight;
  @SerializedName("average_fps")
  private double averageFPS;
  @SerializedName("_links")
  private SelfLink links;
  private Preview preview;
  private Channel channel;

  public long getId() {
    return id;
  }

  public String getGame() {
    return game;
  }

  public int getViewers() {
    return viewers;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public int getVideoHeight() {
    return videoHeight;
  }

  public double getAverageFPS() {
    return averageFPS;
  }

  public SelfLink getLinks() {
    return links;
  }

  public Preview getPreview() {
    return preview;
  }

  public Channel getChannel() {
    return channel;
  }
}

