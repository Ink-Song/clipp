package io.github.ink_song.tools.services.targets;

import java.util.HashMap;

public class TargetRegistry {
  private final HashMap<String, Target> targets;
  public TargetRegistry() {
    targets = new HashMap<>();
    targets.put("word", new WordTarget());
    targets.put("sentence", new SentenceTarget());
  }

  public Target get(String targetName) {
    return targets.get(targetName);
  }

  public boolean contains(String targetName) {
    return targets.containsKey(targetName);
  }
}
