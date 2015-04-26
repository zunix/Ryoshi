package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.models.Block;
import com.github.zunix.ryoshi.api.responses.blocksresource.BlockedUserResponse;
import com.github.zunix.ryoshi.api.responses.blocksresource.UserBlockListResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlocksResourceTest {

  private String clientID;
  private String accessToken;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;

  @Before
  public void initialize() {
    clientID = "";
    accessToken = "";
    ryoshi = new Ryoshi(clientID,accessToken,true);
    httpClient = new OkHttpClient();
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.BlocksResource#getUsersBlockList}
   *
   * Expected Results from https://api.twitch.tv/kraken/users/zun1x/blocks?limit=1&offset=0
   * @throws Exception
   */
  @Ignore("not ready yet")
  @Test
  public void validateGetUsersBlockList() throws Exception {
    String expectedResultsURI = "https://api.twitch.tv/kraken/users/zun1x/blocks?limit=1&offset=1";
    Request request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    UserBlockListResponse userBlockList = ryoshi.blocks().getUsersBlockList("zun1x",1,1);
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testUserBlockListJson = gson.toJson(userBlockList);
    assertEquals("Fail - User Block List JSON don't match!", expectedResults, testUserBlockListJson);
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.BlocksResource#putUserOnBlocklist}
   *
   * Expected Results from https://api.twitch.tv/kraken/users/zun1x/blocks/test_user_troll
   * @throws Exception
   */
  @Ignore("not ready yet")
  @Test
  public void validatePutUserOnBlocklist() throws Exception {
    String expectedResultsURI = "https://api.twitch.tv/kraken/users/zun1x/blocks/bibaboy";
    Request request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Authorization", "OAuth " + accessToken)
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    BlockedUserResponse block = ryoshi.blocks().putUserOnBlocklist("zun1x","bibaboy");
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testUserBlockJson = gson.toJson(block);
    assertEquals("Fail - User Block JSON don't match!", expectedResults, testUserBlockJson);
  }

  /**
   * State test with an authenticated User for
   * {@link com.github.zunix.ryoshi.api.resources.BlocksResource#deleteUserFromBlockList}
   *
   * Expected Results from https://api.twitch.tv/kraken/users/zun1x/blocks/bibaboy
   * @throws Exception
   */
  @Ignore("not ready yet")
  @Test
  public void validateDeleteUserOnBlocklist() throws Exception {

    retrofit.client.Response response = ryoshi.blocks().deleteUserFromBlockList("zun1x","bibaboy");
    assertEquals("Fail - Could not delete User!", 204, response.getStatus());

  }
}