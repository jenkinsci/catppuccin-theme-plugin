package io.jenkins.plugins.theme.catppuccin.jcasc.frappe;

import io.jenkins.plugins.casc.misc.junit.jupiter.WithJenkinsConfiguredWithCode;
import io.jenkins.plugins.theme.catppuccin.CatppuccinFrappeTheme;
import io.jenkins.plugins.theme.catppuccin.jcasc.AbstractThemeJCasCTest;
import io.jenkins.plugins.thememanager.ThemeManagerFactory;

@WithJenkinsConfiguredWithCode
class CatppuccinFrappeThemeJCasCTest extends AbstractThemeJCasCTest {

    @Override
    protected Class<? extends ThemeManagerFactory> getThemeManagerFactory() {
        return CatppuccinFrappeTheme.class;
    }
}
