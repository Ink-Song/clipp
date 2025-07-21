package io.github.ink_song.tools.services.actions;

import java.util.List;

public class WrapAction implements Action {
  String prefix = "";
  String suffix = "";

  public WrapAction(List<String> prefsuf) {
    prefix = prefsuf.get(0);
    suffix = prefsuf.get(1);
  }

  @Override
  public String apply(String input) {
    return prefix + input + suffix;
  }
}
