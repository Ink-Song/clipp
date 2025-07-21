package io.github.ink_song.tools.services.actions;

import java.util.List;

public class WrapActionFactory implements ActionFactory {

  @Override
  public Action create(List<String> args) throws IllegalArgumentException {
    if (args.size() < 2) throw new IllegalArgumentException("Wrap Action Requires 2 Arguments");
    return new WrapAction(args);
  }
}
