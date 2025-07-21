package io.github.ink_song.tools.services.actions;

public class UppercaseAction implements Action {

  @Override
  public String apply(String input) {
    return input.toUpperCase();
  }
}
