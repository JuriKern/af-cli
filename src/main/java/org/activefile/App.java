package org.activefile;

import org.activefile.config.Client;

public class App {
  public static void main(String[] args) {
    System.out.println("AF started");

    Client client = Client.getInstance();

    try {
      client.setConnection("/api", "GET");
      client.request();

    } catch(Exception e) {
      System.out.println("Can not connect to API");
    }

    System.out.println("AF ended");
  }
}
