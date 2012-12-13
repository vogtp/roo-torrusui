package ch.unibas.roo.torrus.client.managed.ui;

import ch.unibas.roo.torrus.client.proxy.SettingsProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class SettingsProxyRenderer extends ProxyRenderer<SettingsProxy> {

    private static ch.unibas.roo.torrus.client.managed.ui.SettingsProxyRenderer INSTANCE;

    protected SettingsProxyRenderer() {
        super(new String[] { "name" });
    }

    public static ch.unibas.roo.torrus.client.managed.ui.SettingsProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SettingsProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
