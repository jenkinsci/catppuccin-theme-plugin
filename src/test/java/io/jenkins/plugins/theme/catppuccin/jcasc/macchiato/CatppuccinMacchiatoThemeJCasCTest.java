package io.jenkins.plugins.theme.catppuccin.jcasc.macchiato;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.theme.catppuccin.CatppuccinMacchiatoTheme;
import io.jenkins.plugins.theme.catppuccin.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class CatppuccinMacchiatoThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return CatppuccinMacchiatoTheme.class;
    }
}
