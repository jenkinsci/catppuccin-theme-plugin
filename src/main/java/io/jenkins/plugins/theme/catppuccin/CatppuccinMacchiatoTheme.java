package io.jenkins.plugins.theme.catppuccin;

import edu.umd.cs.findbugs.annotations.NonNull;
import hudson.Extension;
import io.jenkins.plugins.thememanager.Theme;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;
import java.util.List;
import org.jenkinsci.Symbol;
import org.kohsuke.stapler.DataBoundConstructor;

public class CatppuccinMacchiatoTheme extends ThemeManagerFactory {

    static final String CSS = "catppuccin-macchiato.css";

    @DataBoundConstructor
    public CatppuccinMacchiatoTheme() {
        // Stapler
    }

    @Override
    public Theme getTheme() {
        return Theme.builder().withCssUrls(List.of(getCssUrl())).build();
    }

    @Extension
    @Symbol("catppuccinMacchiato")
    public static class DescriptorImpl extends CatppuccinThemeDescriptor {

        @Override
        public String getThemeKey() {
            return "catppuccin-macchiato";
        }

        @Override
        public ThemeManagerFactory getInstance() {
            return new CatppuccinMacchiatoTheme();
        }

        @Override
        public String getThemeCssSuffix() {
            return CSS;
        }

        @NonNull
        @Override
        public String getDisplayName() {
            return "Catppuccin Macchiato";
        }
    }
}
