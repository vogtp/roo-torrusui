// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.managed.ui.DeviceDetailsView;
import ch.unibas.roo.torrus.client.managed.ui.DeviceEditView;
import ch.unibas.roo.torrus.client.managed.ui.DeviceListView;
import ch.unibas.roo.torrus.client.managed.ui.DeviceMobileDetailsView;
import ch.unibas.roo.torrus.client.managed.ui.DeviceMobileEditView;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.request.DeviceRequest;
import ch.unibas.roo.torrus.client.scaffold.ScaffoldApp;
import ch.unibas.roo.torrus.client.scaffold.place.CreateAndEditProxy;
import ch.unibas.roo.torrus.client.scaffold.place.FindAndEditProxy;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public abstract class DeviceActivitiesMapper_Roo_Gwt {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    protected Activity makeCreateActivity() {
        DeviceEditView.instance().setCreating(true);
        final DeviceRequest request = requests.deviceRequest();
        Activity activity = new CreateAndEditProxy<DeviceProxy>(DeviceProxy.class, request, ScaffoldApp.isMobile() ? DeviceMobileEditView.instance() : DeviceEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(DeviceProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new DeviceEditActivityWrapper(requests, ScaffoldApp.isMobile() ? DeviceMobileEditView.instance() : DeviceEditView.instance(), activity, null);
    }

    @SuppressWarnings("unchecked")
    protected EntityProxyId<ch.unibas.roo.torrus.client.proxy.DeviceProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<DeviceProxy>) place.getProxyId();
    }

    protected Activity makeEditActivity(ProxyPlace place) {
        DeviceEditView.instance().setCreating(false);
        EntityProxyId<DeviceProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<DeviceProxy>(proxyId, requests, ScaffoldApp.isMobile() ? DeviceMobileEditView.instance() : DeviceEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(DeviceProxy proxy) {
                DeviceRequest request = requests.deviceRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new DeviceEditActivityWrapper(requests, ScaffoldApp.isMobile() ? DeviceMobileEditView.instance() : DeviceEditView.instance(), activity, proxyId);
    }
}