package io.jenkins.plugins.theme.catppuccin.playwright;

import static io.jenkins.plugins.theme.catppuccin.playwright.Theme.CssVariable.background;

import io.jenkins.plugins.theme.catppuccin.CatppuccinFrappeTheme;
import io.jenkins.plugins.theme.catppuccin.CatppuccinLatteTheme;
import io.jenkins.plugins.theme.catppuccin.CatppuccinMacchiatoTheme;
import io.jenkins.plugins.theme.catppuccin.CatppuccinMochaTheme;
import io.jenkins.plugins.thememanager.ThemeManagerFactoryDescriptor;

record Theme(String name, String id, CssVariable variableToCheck) {

    public static final Theme FRAPPE = of(new CatppuccinFrappeTheme.DescriptorImpl(), background("#303446"));
    public static final Theme LATTE = of(new CatppuccinLatteTheme.DescriptorImpl(), background("#eff1f5"));
    public static final Theme MACCHIATO = of(new CatppuccinMacchiatoTheme.DescriptorImpl(), background("#24273a"));
    public static final Theme MOCHA = of(new CatppuccinMochaTheme.DescriptorImpl(), background("#1e1e2e"));

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

    public static Theme of(ThemeManagerFactoryDescriptor theme, CssVariable variableToCheck) {
        return new Theme(theme.getDisplayName(), theme.getThemeKey(), variableToCheck);
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
    }

    @Override
    public String toString() {
        return name;
    }
}
