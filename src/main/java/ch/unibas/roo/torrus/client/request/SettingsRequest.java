// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("ch.unibas.roo.torrus.server.domain.Settings")
@ServiceName("ch.unibas.roo.torrus.server.domain.Settings")
public interface SettingsRequest extends RequestContext {

    abstract Request<java.lang.Long> countSettingses();

    abstract Request<java.util.List<ch.unibas.roo.torrus.client.proxy.SettingsProxy>> findAllSettingses();

    abstract Request<java.util.List<ch.unibas.roo.torrus.client.proxy.SettingsProxy>> findSettingsEntries(int firstResult, int maxResults);

    abstract Request<ch.unibas.roo.torrus.client.proxy.SettingsProxy> findSettings(Long id);

    abstract InstanceRequest<ch.unibas.roo.torrus.client.proxy.SettingsProxy, java.lang.Void> persist();

    abstract InstanceRequest<ch.unibas.roo.torrus.client.proxy.SettingsProxy, java.lang.Void> remove();
}
