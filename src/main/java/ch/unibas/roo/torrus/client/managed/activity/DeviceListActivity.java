package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.scaffold.ScaffoldMobileApp;
import ch.unibas.roo.torrus.client.scaffold.activity.IsScaffoldMobileActivity;
import ch.unibas.roo.torrus.client.scaffold.place.AbstractProxyListActivity;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyListView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;

public class DeviceListActivity extends DeviceListActivity_Roo_Gwt {

    public DeviceListActivity(ApplicationRequestFactory requests, ProxyListView<ch.unibas.roo.torrus.client.proxy.DeviceProxy> view, PlaceController placeController) {
        super(placeController, view, DeviceProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Devices";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<ch.unibas.roo.torrus.client.proxy.DeviceProxy>> createRangeRequest(Range range) {
        return requests.deviceRequest().findDeviceEntries(range.getStart(), range.getLength());
    }
}
