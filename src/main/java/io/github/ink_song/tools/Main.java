package io.github.ink_song.tools;

import io.github.ink_song.tools.services.Dispatcher;
import io.github.ink_song.tools.services.actions.Action;
import io.github.ink_song.tools.services.actions.ActionRegistry;
import io.github.ink_song.tools.services.actions.WrapAction;
import io.github.ink_song.tools.services.targets.Target;
import io.github.ink_song.tools.services.targets.WordTarget;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Dispatcher dispatcher = new Dispatcher();
    String input = "Good morning. I am dave the barbarian.";
    String arg1 = "xX";
    String arg2 = "Xx";
    ActionRegistry registry = new ActionRegistry();
    Target target = new WordTarget();

    List<String> arguments = List.of(arg1, arg2);

    System.out.println(dispatcher.apply(registry.get("wrap", arguments), target, input));

  }
}