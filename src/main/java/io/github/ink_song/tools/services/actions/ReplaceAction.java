package io.github.ink_song.tools.services.actions;

import java.util.regex.Pattern;

public class ReplaceAction implements Action {
  private final String find;
  private final String replace;

  public ReplaceAction(String find, String replace) {
    this.find = find;
    this.replace = replace;
  }

  @Override
  public String apply(String input) {
    return input.replaceAll("(?i)"+ Pattern.quote(find), replace);
  }
}
