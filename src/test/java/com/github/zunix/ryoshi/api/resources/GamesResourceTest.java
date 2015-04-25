package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.responses.gamesresource.TopGamesResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GamesResourceTest {

  private String clientID;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;
  private String expectedResultsURI;
  private Request request;

  @Before
  public void initialize() {
    clientID = "";
    expectedResultsURI = "https://api.twitch.tv/kraken/games/top?limit=5&offset=1";
    httpClient = new OkHttpClient();
    ryoshi = new Ryoshi(clientID,false);
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.GamesResource#getTopGames}
   *
   * Expected Results from https://api.twitch.tv/kraken/games/top?limit=5&offset=1
   * @throws Exception
   */
  @Test
  public void validateGetTopGames() throws Exception {
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    TopGamesResponse topGamesResponse = ryoshi.games().getTopGames(5,1);
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testTopGamesJson = gson.toJson(topGamesResponse);
    assertEquals("Fail - Top Games JSON don't match!", expectedResults, testTopGamesJson);

  }
}