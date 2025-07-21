package io.github.ink_song.tools;

import io.github.ink_song.tools.services.Dispatcher;
import io.github.ink_song.tools.services.actions.Action;
import io.github.ink_song.tools.services.actions.WrapAction;
import io.github.ink_song.tools.services.targets.Target;
import io.github.ink_song.tools.services.targets.WordTarget;

public class Main {
  public static void main(String[] args) {
    Action action = new WrapAction("[", "]");
    Target target = new WordTarget();
    Dispatcher dispatcher = new Dispatcher();
    String input = "I think Halo is a pretty cool guy. Eh kills aleins and doesnt afraid of anything.";

    System.out.println(dispatcher.apply(action, target, input));

  }
}