package io.jenkins.plugins.theme.catppuccin.jcasc.latte;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.theme.catppuccin.CatppuccinLatteTheme;
import io.jenkins.plugins.theme.catppuccin.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class CatppuccinLatteThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return CatppuccinLatteTheme.class;
    }
}
