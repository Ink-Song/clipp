package io.github.ink_song.tools.services.targets;

import java.util.List;

public class WordTarget implements Target {

  @Override
  public List<String> partition(String input) {
    String[] words = input.split("\\s+");
    return List.of(words);
  }
}
