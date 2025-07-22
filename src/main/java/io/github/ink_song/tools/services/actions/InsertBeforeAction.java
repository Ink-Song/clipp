package io.github.ink_song.tools.services.actions;

public class InsertBeforeAction implements Action {
  private final String insertCharacters;
  public InsertBeforeAction(String insertCharacters) {
    this.insertCharacters = insertCharacters;
  }
  @Override
  public String apply(String input) {

    return insertCharacters + input;
  }
}
