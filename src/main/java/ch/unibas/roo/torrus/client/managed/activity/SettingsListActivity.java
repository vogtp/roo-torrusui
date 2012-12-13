package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.proxy.SettingsProxy;
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

public class SettingsListActivity extends SettingsListActivity_Roo_Gwt {

    public SettingsListActivity(ApplicationRequestFactory requests, ProxyListView<ch.unibas.roo.torrus.client.proxy.SettingsProxy> view, PlaceController placeController) {
        super(placeController, view, SettingsProxy.class);
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
        return "Settingses";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<ch.unibas.roo.torrus.client.proxy.SettingsProxy>> createRangeRequest(Range range) {
        return requests.settingsRequest().findSettingsEntries(range.getStart(), range.getLength());
    }
}
