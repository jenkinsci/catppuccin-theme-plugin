package io.jenkins.plugins.theme.catppuccin.playwright;

import java.util.StringJoiner;

public record Theme(String name, String id, CssVariable variableToCheck) {
  public Theme {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Theme name cannot be null or empty");
    }
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Theme id cannot be null or empty");
    }
    if (variableToCheck == null) {
      throw new IllegalArgumentException("Variable to check cannot be null");
    }
  }
  public static Theme of(String theme, CssVariable variableToCheck) {
    if (theme == null || theme.isEmpty()) {
      throw new IllegalArgumentException("Theme name cannot be null or empty");
    }
    String name;
    String id;
    if (theme.contains(" ")) {
      // given a theme name, lowercase it and replace spaces with dashes
      name = theme;
      id = theme.toLowerCase().replace(" ", "-");
    } else {
      // given a theme id, titlecase it and replace dashes with spaces
      id = theme;
      StringJoiner joiner = new StringJoiner(" ");
      for (String s : theme.split("-")) {
        joiner.add(Character.toUpperCase(s.charAt(0)) + s.substring(1));
      }
      name = joiner.toString();
    }
    return new Theme(name, id, variableToCheck);
  }

  public record CssVariable(String name, String expected) {

    public CssVariable {
      if (name == null || name.isEmpty()) {
        throw new IllegalArgumentException("CSS variable name cannot be null or empty");
      }
      if (!name.startsWith("--")) {
        throw new IllegalArgumentException("CSS variable name must start with '--'");
      }
      if (expected == null || expected.isEmpty()) {
        throw new IllegalArgumentException("Expected value cannot be null or empty");
      }
    }

      public static CssVariable background(String expectedValue) {
        return new CssVariable("--background", expectedValue);
      }

    public String name() {
      return name;
    }
  }

  @Override
  public String toString() {
    return name;
  }
}
