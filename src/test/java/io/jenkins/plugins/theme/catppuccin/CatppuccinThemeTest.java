package io.jenkins.plugins.theme.catppuccin;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.jenkins.plugins.theme.catppuccin.playwright.AppearancePage;
import io.jenkins.plugins.theme.catppuccin.playwright.PlaywrightConfig;
import io.jenkins.plugins.theme.catppuccin.playwright.Theme;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
@UsePlaywright(PlaywrightConfig.class)
public class CatppuccinThemeTest {

    @Test
    void themeLoads(JenkinsRule j, Page p) {
        List<Theme> themes = List.of(
                Theme.of(new CatppuccinFrappeTheme.DescriptorImpl(), Theme.CssVariable.background("#303446")),
                Theme.of(new CatppuccinLatteTheme.DescriptorImpl(), Theme.CssVariable.background("#eff1f5")),
                Theme.of(new CatppuccinMacchiatoTheme.DescriptorImpl(), Theme.CssVariable.background("#24273a")),
                Theme.of(new CatppuccinMochaTheme.DescriptorImpl(), Theme.CssVariable.background("#1e1e2e")));

        AppearancePage page = new AppearancePage(p, j.jenkins.getRootUrl()).goTo();
        for (Theme theme : themes) {
            page.themeIsPresent(theme).selectTheme(theme).themeIsApplied(theme);
        }
    }
}
