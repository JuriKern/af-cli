package org.activefile;

import java.util.List;
import java.util.ArrayList;

import org.activefile.config.Client;
import org.activefile.util.Command;

import java.util.Map;
import java.util.HashMap;

public class App {
  private static List<Command> commands = new ArrayList<Command>();

  public static void main(String[] args) {
    System.out.println("[-> af-cli started");

    for (String arg: args) {
      String[] temp = arg.split("=");
      Command command = new Command(temp[0], temp[1]);
      if (command.isValid()) {
        commands.add(command);
      }
    }

    for (Command c: commands) {
      System.out.format("[-> execute command %s=%s\n", c.getKey(), c.getValue());
      c.execute();
    }

    // Client client = Client.getInstance();
    //
    // try {
    //   client.setConnection("/api", "GET");
    //   client.request();
    //
    // } catch(Exception e) {
    //   System.out.println("Can not connect to API");
    // }
    //
    System.out.println("[-> af-cli ended");
  }
}
