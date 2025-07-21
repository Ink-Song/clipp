package io.github.ink_song.tools.services;

import io.github.ink_song.tools.services.actions.Action;
import io.github.ink_song.tools.services.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class Dispatcher {
  public String apply(Action action, Target target, String string) {
    List<String> parts = target.partition(string);
    return parts.stream().map(action::apply).collect(Collectors.joining(" "));
  }
}
