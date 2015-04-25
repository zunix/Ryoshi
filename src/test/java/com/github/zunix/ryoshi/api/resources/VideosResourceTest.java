package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.models.Video;
import com.github.zunix.ryoshi.api.responses.videosresource.ChannelVideosResponse;
import com.github.zunix.ryoshi.api.responses.videosresource.TopVideosResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideosResourceTest {

  private String clientID;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;
  private Request request;

  @Before
  public void initialize() {
    clientID = "";
    httpClient = new OkHttpClient();
    ryoshi = new Ryoshi(clientID,false);
  }

  /**
   * State test for {@link com.github.zunix.ryoshi.api.resources.VideosResource#getVideoByID(String
   * id)}
   *
   * Expected Results from https://api.twitch.tv/kraken/videos/c6557652
   */
  @Test
  public void validateGetVideoByID() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/videos/c6557652";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    Video testVideo = ryoshi.videos().getVideoByID("c6557652");
    Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    String testVideoJson = gson.toJson(testVideo);
    assertEquals("Fail - Video Json don't match!", expectedResults, testVideoJson);
  }

  /**
   * State test for {@link com.github.zunix.ryoshi.api.resources.VideosResource#getTopVideos}
   *
   * Expected Results from https://api.twitch.tv/kraken/videos/top?game=Gaming+Talk+Shows&limit=10&offset=10&period=all
   */
  @Test
  public void validateGetTopVideos() throws Exception {
    String expectedResultsURI =
        expectedResultsURI =
            "https://api.twitch.tv/kraken/videos/top?game=Gaming+Talk+Shows&limit=10&offset=10&period=all";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    TopVideosResponse topVideos = ryoshi.videos().getTopVideos("Gaming Talk Shows", 10, 10, "all");
    Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    String testTopVideoJson = gson.toJson(topVideos);
    assertEquals("Fail - Top Videos JSON don't match!", expectedResults, testTopVideoJson);

  }

  /**
   * State test for {@link com.github.zunix.ryoshi.api.resources.VideosResource#getChannelVideos}
   *
   * Expected Results from https://api.twitch.tv/kraken/channels/twitch/videos?broadcasts=false&hls=false&limit=10&offset=10&user=twitch
   */
  @Test
  public void validateGetChannelVideos() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/channels/twitch/videos?broadcasts=false"
        + "&hls=false&limit=10&offset=10&user=twitch";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    ChannelVideosResponse
        channelVideos =
        ryoshi.videos().getChannelVideos("twitch", 10, 10, false, false);
    Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    String testChannelVideosJson = gson.toJson(channelVideos);
    assertEquals("Fail - Top Videos Json don't match!", expectedResults, testChannelVideosJson);
  }
}