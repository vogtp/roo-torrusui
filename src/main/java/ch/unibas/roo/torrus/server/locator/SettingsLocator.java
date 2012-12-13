package ch.unibas.roo.torrus.server.locator;

import ch.unibas.roo.torrus.server.domain.Settings;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("ch.unibas.roo.torrus.server.domain.Settings")
@Component
public class SettingsLocator extends Locator<Settings, Long> {

    public Settings create(Class<? extends ch.unibas.roo.torrus.server.domain.Settings> clazz) {
        return new Settings();
    }

    public Settings find(Class<? extends ch.unibas.roo.torrus.server.domain.Settings> clazz, Long id) {
        return Settings.findSettings(id);
    }

    public Class<ch.unibas.roo.torrus.server.domain.Settings> getDomainType() {
        return Settings.class;
    }

    public Long getId(Settings settings) {
        return settings.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Settings settings) {
        return settings.getVersion();
    }
}
