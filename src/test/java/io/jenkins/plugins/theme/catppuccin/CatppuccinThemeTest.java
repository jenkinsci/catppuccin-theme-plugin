package io.jenkins.plugins.theme.catppuccin;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import io.jenkins.plugins.theme.catppuccin.playwright.AppearancePage;
import io.jenkins.plugins.theme.catppuccin.playwright.PlaywrightConfig;
import io.jenkins.plugins.theme.catppuccin.playwright.Theme;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;
import org.xml.sax.SAXException;

@WithJenkins
@UsePlaywright(PlaywrightConfig.class)
public class CatppuccinThemeTest {

  @Test
  void themeLoads(JenkinsRule j, Page p) {
    List<Theme> themes = List.of(
        Theme.of("Catppuccin Frappe", Theme.CssVariable.background("#303446")),
        Theme.of("Catppuccin Latte", Theme.CssVariable.background("#eff1f5")),
        Theme.of("Catppuccin Macchiato", Theme.CssVariable.background("#24273a")),
        Theme.of("Catppuccin Mocha", Theme.CssVariable.background("#1e1e2e"))
    );
/*
    try (var client = j.createWebClient()) {
      HtmlPage appearancePage = client.goTo("manage/appearance/");
      for (Theme theme : themes) {
        Function<String, ScriptResult> getComputedStyleProperty = selector -> {
          String script = "window.getComputedStyle(document.querySelector(\"%s\")).getPropertyValue(\"%s\");"
              .formatted(selector, theme.variableToCheck().name());
          System.out.println(script);
          return appearancePage.executeJavaScript(
              script
          );
        };

        HtmlElement themeRadio = appearancePage.querySelector("input[data-theme='" + theme.id() + "']");
        assertEquals(theme.name(), themeRadio.getParentNode().getVisibleText());
        ScriptResult result = getComputedStyleProperty.apply(
            ".app-theme-picker__picker[data-theme='" + theme.id() + "'] > svg > g > rect:nth-child(1)"
        );
        theme.variableToCheck().verify(result.getJavaScriptResult());
        themeRadio.click();
        result = getComputedStyleProperty.apply("body");
        theme.variableToCheck().verify(result.getJavaScriptResult());
      }

    }
*/
    AppearancePage page = new AppearancePage(p, j.jenkins.getRootUrl()).goTo();
    for (Theme theme: themes) {
      page.themeIsPresent(theme)
          .selectTheme(theme)
          .themeIsApplied(theme);
    }
  }
}
