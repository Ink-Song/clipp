package io.github.ink_song.tools;

import io.github.ink_song.tools.services.ActionHandler;
import io.github.ink_song.tools.services.ArgHandler;

import java.awt.*;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    String input = "";
    try {
      input = clipboard.getData(DataFlavor.stringFlavor).toString();
    } catch (UnsupportedFlavorException | IOException e) {
      System.out.println(e.getMessage());
    }
    ArgHandler argHandler = new ArgHandler();
    List<List<String>> commands = argHandler.parseCommandBlocks(List.of(args));
    ActionHandler actionHandler = new ActionHandler();

    try {
      String output = actionHandler.handle(commands, input);
      clipboard.setContents(new StringSelection(output), null);
      System.out.println("Finished.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println(input);


    //clipboard.setContents(new StringSelection(results), null);

  }
}