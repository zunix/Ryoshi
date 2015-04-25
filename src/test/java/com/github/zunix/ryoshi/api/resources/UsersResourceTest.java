package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.models.AuthenticatedUser;
import com.github.zunix.ryoshi.api.models.User;
import com.github.zunix.ryoshi.api.responses.usersresource.FollowedStreamsResponse;
import com.github.zunix.ryoshi.api.responses.usersresource.FollowedVideosResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsersResourceTest {

  private String clientID;
  private String accessToken;
  private OkHttpClient httpClient;
  private Request request;
  private Ryoshi ryoshi;

  @Before
  public void initialize() {
    clientID = "";
    accessToken = "";
    ryoshi = new Ryoshi(clientID,accessToken,false);
    httpClient = new OkHttpClient();
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.UsersResource#getUserByUsername}
   *
   * Expected Results from https://api.twitch.tv/kraken/users/test_user1
   * @throws Exception
   */
  @Test
  public void validateGetUserByUsername() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/users/test_user1";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    User user = ryoshi.users().getUserByUsername("test_user1");
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testUserJson = gson.toJson(user);
    assertEquals("Fail - User JSON don't match!", expectedResults, testUserJson);

  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.UsersResource#getAuthenticatedUser}
   *
   * Expected Results from https://api.twitch.tv/kraken/user
   * @throws Exception
   */
  @Test
  public void validateGetAuthenticatedUser() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/user";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    AuthenticatedUser user = ryoshi.users().getAuthenticatedUser();
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testUserJson = gson.toJson(user);
    assertEquals("Fail - User JSON don't match!", expectedResults, testUserJson);
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.UsersResource#getFollowedStreams}
   *
   * Expected Results from https://api.twitch.tv/kraken/streams/followed?limit=1&offset=1
   * @throws Exception
   */
  @Test
  public void validateGetFollowedStreams() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/streams/followed?limit=1&offset=1";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    FollowedStreamsResponse streamsResponse = ryoshi.users().getFollowedStreams(1,1);
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testStreamsJson = gson.toJson(streamsResponse);
    assertEquals("Fail - Followed Streams JSON don't match!", expectedResults, testStreamsJson);
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.UsersResource#getFollowedVideos}
   *
   * Expected Results from https://api.twitch.tv/kraken/videos/followed?limit=1&offset=1
   * @throws Exception
   */
  @Test
  public void validateGetFollowedVideos() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/videos/followed?limit=1&offset=1";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    FollowedVideosResponse videosResponse = ryoshi.users().getFollowedVideos(1,1);
    Gson gson = new GsonBuilder().disableHtmlEscaping().serializeNulls().create();
    String testVideosJson = gson.toJson(videosResponse);
    assertEquals("Fail - Followed Videos JSON don't match!", expectedResults, testVideosJson);
  }
}