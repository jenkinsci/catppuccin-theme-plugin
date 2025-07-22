package io.jenkins.plugins.theme.catppuccin.playwright;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

@WithJenkins
@UsePlaywright(PlaywrightConfig.class)
class CatppuccinThemeTest {

    private static String rootUrl;

    @BeforeAll
    static void beforeAll(JenkinsRule j) {
        rootUrl = j.jenkins.getRootUrl();
    }

    static Stream<Arguments> themeProvider() {
        return Stream.of(
                arguments(Theme.FRAPPE), arguments(Theme.LATTE), arguments(Theme.MACCHIATO), arguments(Theme.MOCHA));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("themeProvider")
    void themeLoads(Theme theme, Page p) {
        new AppearancePage(p, rootUrl)
                .goTo()
                .themeIsPresent(theme)
                .selectTheme(theme)
                .themeIsApplied(theme);
    }
}
