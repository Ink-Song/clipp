package io.github.ink_song.tools.services.actions;

import java.util.List;

@FunctionalInterface
public interface ActionFactory {
  Action create(List<String> args) throws IllegalArgumentException;
}
