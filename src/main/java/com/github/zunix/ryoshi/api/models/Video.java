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

import com.github.zunix.ryoshi.api.models.links.ChannelLink;

public class Video {

  private String title;
  private String description;
  @SerializedName("broadcast_id")
  private long broadcastId;
  private String status;
  @SerializedName("tag_list")
  private String tagList;
  @SerializedName("_id")
  private String id;
  @SerializedName("recorded_at")
  private String recordedAt;
  private String game;
  private int length;
  private String preview;
  private String url;
  private int views;
  private FPS fps;
  private Resolutions resolutions;
  @SerializedName("broadcast_type")
  private String broadcastType;
  @SerializedName("_links")
  private ChannelLink links;
  @SerializedName("channel")
  private UserChannel channel;

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public long getBroadcastId() {
    return broadcastId;
  }

  public String getStatus() {
    return status;
  }

  public String getTagList() {
    return tagList;
  }

  public String getId() {
    return id;
  }

  public String getRecordedAt() {
    return recordedAt;
  }

  public String getGame() {
    return game;
  }

  public int getLength() {
    return length;
  }

  public String getPreview() {
    return preview;
  }

  public String getUrl() {
    return url;
  }

  public int getViews() {
    return views;
  }

  public FPS getFps() {
    return fps;
  }

  public Resolutions getResolutions() {
    return resolutions;
  }

  public String getBroadcastType() {
    return broadcastType;
  }

  public ChannelLink getLinks() {
    return links;
  }

  public UserChannel getChannel() {
    return channel;
  }
}
