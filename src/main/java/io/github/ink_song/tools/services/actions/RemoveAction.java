package io.github.ink_song.tools.services.actions;

public class RemoveAction implements Action {
  private final String target;
  public RemoveAction(String target) {
    this.target = target;
  }
  @Override
  public String apply(String input) {
    return input.replace(target, "");
  }
}
