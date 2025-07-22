package io.github.ink_song.tools.services.actions;

import java.util.List;

public class RemoveActionFactory implements ActionFactory {

  @Override
  public Action create(List<String> args) throws IllegalArgumentException {
    if (args.size() != 1) {
      throw new IllegalArgumentException();
    }
    return new RemoveAction(args.getFirst());
  }
}
