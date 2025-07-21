package io.github.ink_song.tools.services.actions;

public class CapitalizeAction implements Action {

  @Override
  public String apply(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }
}
