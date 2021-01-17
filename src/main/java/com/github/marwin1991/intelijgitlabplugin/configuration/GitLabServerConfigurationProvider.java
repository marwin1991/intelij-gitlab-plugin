package com.github.marwin1991.intelijgitlabplugin.configuration;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurableProvider;
import org.jetbrains.annotations.Nullable;

public class GitLabServerConfigurationProvider extends ConfigurableProvider {

    @Override
    public @Nullable Configurable createConfigurable() {
        SettingsView settingsView = new SettingsView();
        return settingsView;
    }

}
