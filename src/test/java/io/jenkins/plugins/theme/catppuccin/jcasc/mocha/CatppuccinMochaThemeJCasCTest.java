package io.jenkins.plugins.theme.catppuccin.jcasc.mocha;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.theme.catppuccin.CatppuccinMochaTheme;
import io.jenkins.plugins.theme.catppuccin.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class CatppuccinMochaThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return CatppuccinMochaTheme.class;
    }
}
