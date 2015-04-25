package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.responses.ingestsresource.IngestsResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import retrofit.RestAdapter;

import static org.junit.Assert.*;

public class IngestsResourceTest {

  private String clientID;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;
  private String expectedResultsURI;
  private Request request;

  @Before
  public void initialize() {
    clientID = "";
    expectedResultsURI = "https://api.twitch.tv/kraken/ingests";
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
   * {@link com.github.zunix.ryoshi.api.resources.IngestsResource#getIngests()}
   *
   * Expected Results from https://api.twitch.tv/kraken/ingests
   * @throws Exception
   */
  @Test
  public void validateGetIngests() throws Exception {
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    IngestsResponse ingests = ryoshi.ingests().getIngests();
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    String testIngestsJson = gson.toJson(ingests);
    assertEquals("Fail - Ingests JSON don't match!", expectedResults, testIngestsJson);
  }
}