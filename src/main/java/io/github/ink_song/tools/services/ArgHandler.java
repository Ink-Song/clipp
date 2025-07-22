package io.github.ink_song.tools.services;

import java.util.ArrayList;
import java.util.List;

public class ArgHandler {
  public List<List<String>> parseCommandBlocks(List<String> args) {
    List<List<String>> commandBlocks = new ArrayList<>();
    List<String> current = new ArrayList<>();
    if (args.size() < 2) {
      throw new IllegalArgumentException("Not enough arguments");
    }

    for (String arg : args) {
      if (arg.equals("--next")) {
        commandBlocks.add(current);
        current = new ArrayList<>();
      } else {
        current.add(arg);
      }
    }
    if (!current.isEmpty()) {
      commandBlocks.add(current);
    }
    return commandBlocks;
  }
}
