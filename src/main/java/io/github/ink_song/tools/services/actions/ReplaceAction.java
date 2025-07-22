package io.github.ink_song.tools.services.actions;

public class ReplaceAction implements Action {
  private final String find;
  private final String replace;

  public ReplaceAction(String find, String replace) {
    this.find = find;
    this.replace = replace;
  }

  @Override
  public String apply(String input) {
    return input.replace(find, replace);
  }
}
