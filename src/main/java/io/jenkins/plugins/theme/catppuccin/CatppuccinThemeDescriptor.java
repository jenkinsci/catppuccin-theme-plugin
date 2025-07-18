package io.jenkins.plugins.theme.catppuccin;

import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;

public class CatppuccinThemeDescriptor extends ThemeManagerFactoryDescriptor {
  static final String ID = "catppuccin";

  @Override
  public String getThemeId() {
    return ID;
  }

  @Override
  public boolean isNamespaced() {
    return true;
  }

  @Override
  public String getIconClassName() {
    return "symbol-catppuccin plugin-catppuccin-theme";
  }
}
