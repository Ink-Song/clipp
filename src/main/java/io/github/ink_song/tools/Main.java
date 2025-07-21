package io.github.ink_song.tools;

import io.github.ink_song.tools.services.Dispatcher;
import io.github.ink_song.tools.services.actions.ActionRegistry;
import io.github.ink_song.tools.services.targets.Target;
import io.github.ink_song.tools.services.targets.WordTarget;

import java.awt.*;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    Dispatcher dispatcher = new Dispatcher();
    String input = "";
    try {
      input = clipboard.getData(DataFlavor.stringFlavor).toString();
    } catch (UnsupportedFlavorException | IOException e) {
      System.out.println(e.getMessage());
    }

    String arg1 = "xX";
    String arg2 = "Xx";
    ActionRegistry registry = new ActionRegistry();
    Target target = new WordTarget();

    List<String> arguments = List.of(arg1, arg2);
    String results = dispatcher.apply(registry.get("uppercase", arguments), target, input);
    clipboard.setContents(new StringSelection(results), null);

    System.out.println(dispatcher.apply(registry.get("uppercase", arguments), target, input));
    return;

  }
}