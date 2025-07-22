package io.github.ink_song.tools.services.actions;

public class InsertAfterAction implements Action {
  private final String insertText;
  public InsertAfterAction(String insertText) {
    this.insertText = insertText;
  }
  @Override
  public String apply(String input) {
    return input + insertText;
  }
}
