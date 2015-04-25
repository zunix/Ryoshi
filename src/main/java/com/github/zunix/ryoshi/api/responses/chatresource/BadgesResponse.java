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
package com.github.zunix.ryoshi.api.responses.chatresource;

import com.google.gson.annotations.SerializedName;

import com.github.zunix.ryoshi.api.models.Badge;
import com.github.zunix.ryoshi.api.models.links.SelfLink;

public class BadgesResponse {

  @SerializedName("global_mod")
  private Badge globalMod;
  private Badge admin;
  private Badge broadcaster;
  private Badge mod;
  private Badge staff;
  private Badge turbo;
  private Badge subscriber;
  @SerializedName("_links")
  private SelfLink links;

  public Badge getGlobalMod() {
    return globalMod;
  }

  public Badge getAdmin() {
    return admin;
  }

  public Badge getBroadcaster() {
    return broadcaster;
  }

  public Badge getMod() {
    return mod;
  }

  public Badge getStaff() {
    return staff;
  }

  public Badge getTurbo() {
    return turbo;
  }

  public Badge getSubscriber() {
    return subscriber;
  }

  public SelfLink getLinks() {
    return links;
  }
}
