package io.github.ink_song.tools.services.actions;

import java.util.HashMap;
import java.util.List;

public class ActionRegistry {
  private final HashMap<String, ActionFactory> actions = new HashMap<>();
  public ActionRegistry() {
    actions.put("capitalize", args -> new CapitalizeAction());
    actions.put("lowercase", args -> new LowercaseAction());
    actions.put("uppercase", args -> new UppercaseAction());
    actions.put("wrap", new WrapActionFactory());
  }

  public Action get(String input, List<String> args) {
    return actions.get(input).create(args);
  }

  public Boolean contains(String input) {
    return actions.containsKey(input);
  }

}
