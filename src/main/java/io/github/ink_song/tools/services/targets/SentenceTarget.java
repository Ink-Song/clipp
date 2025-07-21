package io.github.ink_song.tools.services.targets;

import java.util.List;

public class SentenceTarget implements Target {

  @Override
  public List<String> partition(String input) {
    String[] result = input.split("(?<=\\.)\\s*");
    return List.of(result);
  }
}
