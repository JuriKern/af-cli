package org.activefile.config;

import java.net.URL;
import java.net.HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import org.activefile.resources.Status;

public class Client {
  private final String API_ENDPOINT = "http://af-app-dev.ngrok.io";

  private static Client instance;

  private HttpURLConnection connection;
  private String response;
  private int responseCode;

  public synchronized static Client getInstance() {
    if (instance == null) {
      instance = new Client();
    }

    return instance;
  }

  public void setConnection(String path, String method) throws Exception {
    String url = API_ENDPOINT + path;
    connection = (HttpURLConnection) new URL(url).openConnection();
    connection.setRequestProperty("User-Agent", "af-cli v0.0.1");
    connection.setRequestMethod(method);
    connection.connect();
  }

  public void request() throws Exception {
    responseCode = connection.getResponseCode();

    BufferedReader bf = new BufferedReader(
      new InputStreamReader(connection.getInputStream())
    );

    response = bf.readLine();

    bf.close();

    Gson gson = new Gson();
    Status status = gson.fromJson(response, Status.class);

    System.out.println(status.getSuccess());
  }

  public HttpURLConnection getConnection() {
    return connection;
  }

  public String getResponse() {
    return response;
  }
}
