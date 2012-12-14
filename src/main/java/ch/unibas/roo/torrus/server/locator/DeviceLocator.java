package ch.unibas.roo.torrus.server.locator;

import ch.unibas.roo.torrus.server.domain.Device;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("ch.unibas.roo.torrus.server.domain.Device")
@Component
public class DeviceLocator extends Locator<Device, Long> {

    public Device create(Class<? extends ch.unibas.roo.torrus.server.domain.Device> clazz) {
        return new Device();
    }

    public Device find(Class<? extends ch.unibas.roo.torrus.server.domain.Device> clazz, Long id) {
        return Device.findDevice(id);
    }

    public Class<ch.unibas.roo.torrus.server.domain.Device> getDomainType() {
        return Device.class;
    }

    public Long getId(Device device) {
        return device.getId();
    }

    public Class<java.lang.Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Device device) {
        return device.getVersion();
    }
}
