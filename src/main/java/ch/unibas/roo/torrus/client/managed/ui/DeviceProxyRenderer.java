package ch.unibas.roo.torrus.client.managed.ui;

import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class DeviceProxyRenderer extends ProxyRenderer<DeviceProxy> {

    private static ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer INSTANCE;

    protected DeviceProxyRenderer() {
        super(new String[] { "name" });
    }

    public static ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new DeviceProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(DeviceProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
