package io.github.ink_song.tools.services;

import io.github.ink_song.tools.services.actions.ActionRegistry;
import io.github.ink_song.tools.services.targets.TargetRegistry;

import java.util.ArrayList;
import java.util.List;

public class ActionHandler {
  private final ActionRegistry actionRegistry = new ActionRegistry();
  private final TargetRegistry targetRegistry = new TargetRegistry();

  public String handle(List<List<String>> commands, String input) {
    for (List<String> commandBlock : commands) {
      String action = commandBlock.getFirst();
      String target = commandBlock.get(1);
      if (!actionRegistry.contains(action))
        throw new IllegalArgumentException("No such Action found");
      if (!targetRegistry.contains(target))
        throw new IllegalArgumentException("No such target found");
      List<String> arguments = new ArrayList<>();
      if (commandBlock.size() > 2) {
        arguments.addAll(commandBlock.subList(2, commandBlock.size()));
      }

      input = new Dispatcher()
          .apply(actionRegistry.get(action,arguments), targetRegistry.get(target), input);


    }
    return input;
  }
}
