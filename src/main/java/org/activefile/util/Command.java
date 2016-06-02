package org.activefile.util;

import java.util.List;
import java.util.Arrays;

public class Command {
  private final List<String> allowedKeys = Arrays.asList(
    "--file", "--crypt", "--decrypt"
  );

  private String key;
  private String value;
  private boolean valid;

  public Command(String key, String value) {
    if (valid = allowedKeys.contains(key)) {
      this.key = key;
      this.value = value;
    }
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }

  public boolean isValid() {
    return valid;
  }

  public void execute() {

  }
}
