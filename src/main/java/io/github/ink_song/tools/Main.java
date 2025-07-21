package io.github.ink_song.tools;

import io.github.ink_song.tools.services.Dispatcher;
import io.github.ink_song.tools.services.actions.Action;
import io.github.ink_song.tools.services.actions.ActionRegistry;
import io.github.ink_song.tools.services.targets.Target;
import io.github.ink_song.tools.services.targets.TargetRegistry;
import io.github.ink_song.tools.services.targets.WordTarget;

import java.awt.*;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> customArgs = new ArrayList<>();
    customArgs.add("wrap");
    customArgs.add("word");
    customArgs.add("[");
    customArgs.add("]");

    List<List<String>> commandBlocks = new ArrayList<>();
    List<String> current = new ArrayList<>();

    for (String arg : customArgs) {
      if (arg.equals("--next")) {
        commandBlocks.add(current);
        current = new ArrayList<>();
      } else {
        current.add(arg);
      }
    }
    if (!current.isEmpty()) {
      commandBlocks.add(current);
    }

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    ActionRegistry actionRegistry = new ActionRegistry();
    TargetRegistry targetRegistry = new TargetRegistry();
    String input = "";
    try {
      input = clipboard.getData(DataFlavor.stringFlavor).toString();
    } catch (UnsupportedFlavorException | IOException e) {
      System.out.println(e.getMessage());
    }

    for (List<String> commandBlock : commandBlocks) {
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
    System.out.println(input);


    //clipboard.setContents(new StringSelection(results), null);

  }
}