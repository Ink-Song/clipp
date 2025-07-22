package io.github.ink_song.tools.services.actions;

import java.util.regex.Pattern;

public class RemoveAction implements Action {
  private final String target;
  public RemoveAction(String target) {
    this.target = target;
  }
  @Override
  public String apply(String input) {
    return input.replaceAll("(?i)"+ Pattern.quote(target), "");
  }
}
