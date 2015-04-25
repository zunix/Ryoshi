package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.models.FeaturedStream;
import com.github.zunix.ryoshi.api.models.Stream;
import com.github.zunix.ryoshi.api.responses.streamsresource.FeaturedStreamsResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamsResponse;
import com.github.zunix.ryoshi.api.responses.streamsresource.StreamsSummaryResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StreamsResourceTest {

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
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.StreamsResource#getStreamByChannelName}
   *
   * Expected Results from https://api.twitch.tv/kraken/streams/monstercat
   * @throws Exception
   */
  @Test
  public void validateGetStreamByChannelName() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/streams/monstercat";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    StreamResponse stream = ryoshi.streams().getStreamByChannelName("monstercat");
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testStreamJson = gson.toJson(stream);
    assertEquals("Fail - Stream JSON don't match!", expectedResults, testStreamJson);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.StreamsResource#getStreams}
   *
   * Expected Results from https://api.twitch.tv/kraken/streams?game=Minecraft&limit=1&offset=1
   * @throws Exception
   */
  @Test
  public void validateGetStreams() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/streams?game=Minecraft&limit=1&offset=2";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    StreamsResponse streamsResponse = ryoshi.streams().getStreams("Minecraft",null,1,2,null);
    Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    String testStreamJson = gson.toJson(streamsResponse);
    assertEquals("Fail - Streams JSON don't match!", expectedResults, testStreamJson);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.StreamsResource#getFeaturedStreams}
   *
   * Expected Results from https://api.twitch.tv/kraken/streams/featured?limit=1&offset=5
   * @throws Exception
   */
  @Test
  public void validateGetFeaturedStreams() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/streams/featured?limit=1&offset=5";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    FeaturedStreamsResponse featuredStream = ryoshi.streams().getFeaturedStreams(1,5);
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testFeaturedStreamJson = gson.toJson(featuredStream);
    assertEquals("Fail - Featured JSON don't match!", expectedResults, testFeaturedStreamJson);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.StreamsResource#getStreamsSummary}
   *
   * Expected Results from https://api.twitch.tv/kraken/streams/summary?game=Minecraft
   * @throws Exception
   */
  @Test
  public void validateGetStreamsSummary() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/streams/summary?game=Minecraft";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    StreamsSummaryResponse summaryResponse = ryoshi.streams().getStreamsSummary("Minecraft");
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testStreamsSummaryJson = gson.toJson(summaryResponse);
    assertEquals("Fail - Summary JSON don't match!", expectedResults, testStreamsSummaryJson);
  }
}