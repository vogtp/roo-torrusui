// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.proxy;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "ch.unibas.roo.torrus.server.domain.Device", locator = "ch.unibas.roo.torrus.server.locator.DeviceLocator")
@RooGwtProxy(value = "ch.unibas.roo.torrus.server.domain.Device", readOnly = { "version", "id" }, scaffold = true)
public interface DeviceProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract Integer getVersion();
}
