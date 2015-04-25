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

import com.github.zunix.ryoshi.api.models.links.ChannelInformationLinks;

public class Channel {

  @SerializedName("_links")
  private ChannelInformationLinks links;
  private String background;
  private String banner;
  @SerializedName("broadcaster_language")
  private String broadcasterLanguage;
  @SerializedName("display_name")
  private String displayName;
  private String game;
  private String logo;
  private boolean mature;
  private String status;
  private boolean partner;
  private String url;
  @SerializedName("video_banner")
  private String videoBanner;
  @SerializedName("_id")
  private long id;
  private String name;
  @SerializedName("created_at")
  private String createdAt;
  @SerializedName("updated_at")
  private String updatedAt;
  private int delay;
  private int followers;
  @SerializedName("profile_banner")
  private String profileBanner;
  @SerializedName("profile_banner_background_color")
  private String profileBannerBackgroundColor;
  private long views;
  private String language;


  public ChannelInformationLinks getLinks() {
    return links;
  }

  public String getBackground() {
    return background;
  }

  public String getBanner() {
    return banner;
  }

  public String getBroadcasterLanguage() {
    return broadcasterLanguage;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getGame() {
    return game;
  }

  public String getLogo() {
    return logo;
  }

  public boolean isMature() {
    return mature;
  }

  public String getStatus() {
    return status;
  }

  public boolean isPartner() {
    return partner;
  }

  public String getUrl() {
    return url;
  }

  public String getVideoBanner() {
    return videoBanner;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public int getDelay() {
    return delay;
  }

  public int getFollowers() {
    return followers;
  }

  public String getProfileBanner() {
    return profileBanner;
  }

  public String getProfileBannerBackgroundColor() {
    return profileBannerBackgroundColor;
  }

  public long getViews() {
    return views;
  }

  public String getLanguage() {
    return language;
  }
}


