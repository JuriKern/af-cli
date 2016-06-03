package org.activefile.resources;

import java.util.List;
import java.util.ArrayList;

public class Keypair {
  private static Keypair instance;

  private static List<String> args = new ArrayList<String>();
  private static String token;
  private boolean authenticated;

  public static synchronized Keypair getInstance() {
    if (instance == null) {
      instance = new Keypair();
    }

    return instance;
  }

  public void setArg(String arg) {
    args.add(arg);
  }

  public void authenticate() throws Exception {
    if (args.size() < 2) {
      throw new Exception("can not find keypair to authenticate client");
    }

    args.clear();

    if (token == null) {
      throw new Exception("can not authenticate client");
    }

    authenticated = true;
  }

  public boolean isAuthenticated() {
    return authenticated;
  }
}
