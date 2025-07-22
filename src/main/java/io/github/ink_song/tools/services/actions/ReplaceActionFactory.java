package io.github.ink_song.tools.services.actions;

import java.util.List;

public class ReplaceActionFactory implements ActionFactory {

  @Override
  public Action create(List<String> args) throws IllegalArgumentException {
    if (args.size() != 2) {
      throw new IllegalArgumentException();
    }
    return new ReplaceAction(args.get(0), args.get(1));
  }
}
