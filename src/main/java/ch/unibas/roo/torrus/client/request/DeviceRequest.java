// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.request;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("ch.unibas.roo.torrus.server.domain.Device")
@ServiceName("ch.unibas.roo.torrus.server.domain.Device")
public interface DeviceRequest extends RequestContext {

    abstract Request<java.lang.Long> countDevices();

    abstract Request<java.util.List<ch.unibas.roo.torrus.client.proxy.DeviceProxy>> findAllDevices();

    abstract Request<java.util.List<ch.unibas.roo.torrus.client.proxy.DeviceProxy>> findDeviceEntries(int firstResult, int maxResults);

    abstract Request<ch.unibas.roo.torrus.client.proxy.DeviceProxy> findDevice(Long id);

    abstract InstanceRequest<ch.unibas.roo.torrus.client.proxy.DeviceProxy, java.lang.Void> persist();

    abstract InstanceRequest<ch.unibas.roo.torrus.client.proxy.DeviceProxy, java.lang.Void> remove();
}
