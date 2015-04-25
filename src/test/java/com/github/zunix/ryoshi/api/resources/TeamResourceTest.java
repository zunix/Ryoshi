package com.github.zunix.ryoshi.api.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.github.zunix.ryoshi.Ryoshi;
import com.github.zunix.ryoshi.api.models.Team;
import com.github.zunix.ryoshi.api.responses.teamresource.TeamResponse;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamResourceTest {

  private String clientID;
  private OkHttpClient httpClient;
  private Ryoshi ryoshi;
  private Request request;

  @Before
  public void initialize() {
    clientID = "";
    httpClient = new OkHttpClient();
    ryoshi = new Ryoshi(clientID);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.TeamResource#getTeams(int limit,int offset)}
   *
   * Expected Results from https://api.twitch.tv/kraken/teams?limit=10&offset=10
   * @throws Exception
   */
  @Test
  public void validateGetTeams() throws Exception {
    String expectedResultsURI = expectedResultsURI =
        "https://api.twitch.tv/kraken/teams?limit=10&offset=10";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    TeamResponse teams = ryoshi.team().getTeams(10,10);
    Gson gson = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
    String testTeamsJson = gson.toJson(teams);
    assertEquals("Fail - Teams JSON don't match!", expectedResults, testTeamsJson);
  }

  /**
   * State test for
   * {@link com.github.zunix.ryoshi.api.resources.TeamResource#getTeamByName(String teamName)}
   *
   * Expected Results from https://api.twitch.tv/kraken/teams/eg
   * @throws Exception
   */
  @Test
  public void validateGetTeamByName() throws Exception {
    String expectedResultsURI = expectedResultsURI = "https://api.twitch.tv/kraken/teams/eg";
    request = new Request.Builder()
        .url(expectedResultsURI)
        .header("Accept", "application/vnd.twitchtv.v3+json")
        .addHeader("Client-ID", clientID)
        .build();
    Response response = httpClient.newCall(request).execute();
    String expectedResults = response.body().string();

    String teamName = "eg";
    Team team = ryoshi.team().getTeamByName(teamName);
    Gson gson = new GsonBuilder().create();
    String testTeamJson = gson.toJson(team);
    assertEquals("Fail - Team: "+teamName+" JSON don't match!", expectedResults, testTeamJson);
  }
}