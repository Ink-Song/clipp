package io.github.ink_song.tools.services.actions;

public class LowercaseAction implements Action {

  @Override
  public String apply(String input) {
    return input.toLowerCase();
  }
}
