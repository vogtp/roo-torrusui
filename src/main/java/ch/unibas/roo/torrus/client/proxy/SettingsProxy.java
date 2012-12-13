// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "ch.unibas.roo.torrus.server.domain.Settings", locator = "ch.unibas.roo.torrus.server.locator.SettingsLocator")
@RooGwtProxy(value = "ch.unibas.roo.torrus.server.domain.Settings", readOnly = { "version", "id" }, scaffold = true)
public interface SettingsProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract String getCurrentValue();

    abstract void setCurrentValue(String currentValue);

    abstract String getDefaultValue();

    abstract void setDefaultValue(String defaultValue);

    abstract Integer getVersion();
}
