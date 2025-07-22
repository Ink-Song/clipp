package io.github.ink_song.tools.services.actions;

public class RemoveFirstAction implements Action {
  private final String target;
  public RemoveFirstAction(String target) {
    this.target = target;
  }
  @Override
  public String apply(String input) {
    return input.replaceFirst(target, "");
  }
}
