package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.responses.chatresource.BadgesResponse;
import com.github.zunix.ryoshi.api.responses.chatresource.ChatChannelNameResponse;
import com.github.zunix.ryoshi.api.responses.chatresource.EmoticonsResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;

import static org.junit.Assert.*;

public class ChatResourceTest {

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
   * {@link com.github.zunix.ryoshi.api.resources.ChatResource#getChatEndpointsByChannelName}
   *
   * Expected Results from https://api.twitch.tv/kraken/chat/kraken_test_user
   * @throws Exception
   */
  @Test
  public void validateGetChatEndpointsByChannelName() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/chat/kraken_test_user";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    ChatChannelNameResponse chatEndpoint = ryoshi.chat()
        .getChatEndpointsByChannelName("kraken_test_user");
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testChatEndpointJson = gson.toJson(chatEndpoint);
    assertEquals("Fail - Chat Endpoint JSON don't match!", expectedResults, testChatEndpointJson);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.ChatResource#getAllEmoticons}
   *
   * Expected Results from https://api.twitch.tv/kraken/chat/emoticons
   * @throws Exception
   */
  @Ignore("not ready yet")
  @Test
  public void validateGetAllEmoticons() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/chat/emoticons";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();
    FileUtils.writeStringToFile(new File("expectedResults.txt"), expectedResults);

    EmoticonsResponse emoticons = ryoshi.chat().getAllEmoticons();
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testEmoticonsJson = gson.toJson(emoticons);
    FileUtils.writeStringToFile(new File("actualResults.txt"), testEmoticonsJson);
    File expected = new File("actualResults.txt");
    File actual = new File("actualResults.txt");
    assertEquals("Fail - Emoticons JSON don't match!",
                 FileUtils.readLines(expected),FileUtils.readLines(actual));
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.ChatResource#getBadgesByChannelName}
   *
   * Expected Results from https://api.twitch.tv/kraken/chat/test_user1/badges
   * @throws Exception
   */
  @Test
  public void validateGetBadgesByChannelName() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/chat/test_user1/badges";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    BadgesResponse badges = ryoshi.chat().getBadgesByChannelName("test_user1");
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testBadgesJson = gson.toJson(badges);
    assertEquals("Fail - Badge JSON don't match!", expectedResults, testBadgesJson);
  }

}