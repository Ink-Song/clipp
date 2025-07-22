package io.github.ink_song.tools;

import io.github.ink_song.tools.services.ActionHandler;
import io.github.ink_song.tools.services.ArgHandler;

import java.awt.*;
import java.awt.datatransfer.*;

import java.io.IOException;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    ActionHandler actionHandler = new ActionHandler();
    ArgHandler argHandler = new ArgHandler();
    DataFlavor plainText = new DataFlavor("text/plain;class=java.lang.String", "Plain Text");

    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    String input = "";
    try {
      Transferable transferable = clipboard.getContents(null);
      if (transferable == null) {
        System.out.println("Error: Clipboard Content is null.");
        return;
      }
      if(transferable.isDataFlavorSupported(plainText)) {
        input = (String) transferable.getTransferData(plainText);
      } else throw new UnsupportedFlavorException(transferable.getTransferDataFlavors()[0]);
    } catch (UnsupportedFlavorException | IOException e) {
      System.out.println(e.getMessage());
    }

    List<List<String>> commands;
    try {
      commands = argHandler.parseCommandBlocks(List.of(args));
    } catch (IllegalArgumentException e) {
      System.out.println("Error: " + e.getMessage());
      return;
    }

    try {
      String output = actionHandler.handle(commands, input);
      clipboard.setContents(new StringSelection(output), null);
      System.out.println(output);
      System.out.println("Finished.");
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    //clipboard.setContents(new StringSelection(results), null);

  }
}