package io.jenkins.plugins.theme.catppuccin;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import java.util.List;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class CatppuccinLatteTheme extends ThemeManagerFactory {

    static final String CSS = "catppuccin-latte.css";

    @DataBoundConstructor
    public CatppuccinLatteTheme() {
        // Stapler
    }

    @Override
    public Theme getTheme() {
      return Theme.builder()
            .withCssUrls(List.of(getCssUrl()))
            .build();
    }

    @Extension
    @Symbol("catppuccinLatte")
    public static class DescriptorImpl extends CatppuccinThemeDescriptor {

        @Override
        public String getThemeKey() {
            return "catppuccin-latte";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new CatppuccinLatteTheme();
        }

        @Override
        public String getThemeCssSuffix() {
            return CSS;
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Catppuccin Latte";
        }
    }
}
