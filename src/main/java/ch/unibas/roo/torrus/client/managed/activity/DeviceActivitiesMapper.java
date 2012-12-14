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

public class DeviceActivitiesMapper extends DeviceActivitiesMapper_Roo_Gwt {

    public DeviceActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new DeviceDetailsActivity((EntityProxyId<DeviceProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? DeviceMobileDetailsView.instance() : DeviceDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
