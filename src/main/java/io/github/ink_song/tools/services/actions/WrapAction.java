package io.github.ink_song.tools.services.actions;

public class WrapAction implements Action {
  String prefix;
  String suffix;

  public WrapAction(String prefix, String suffix) {
    this.prefix = prefix;
    this.suffix = suffix;
  }

  @Override
  public String apply(String input) {
    return prefix + input + suffix;
  }
}
