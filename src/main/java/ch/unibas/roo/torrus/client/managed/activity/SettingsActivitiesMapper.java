package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.managed.ui.SettingsDetailsView;
import ch.unibas.roo.torrus.client.managed.ui.SettingsEditView;
import ch.unibas.roo.torrus.client.managed.ui.SettingsListView;
import ch.unibas.roo.torrus.client.managed.ui.SettingsMobileDetailsView;
import ch.unibas.roo.torrus.client.managed.ui.SettingsMobileEditView;
import ch.unibas.roo.torrus.client.proxy.SettingsProxy;
import ch.unibas.roo.torrus.client.request.SettingsRequest;
import ch.unibas.roo.torrus.client.scaffold.ScaffoldApp;
import ch.unibas.roo.torrus.client.scaffold.place.CreateAndEditProxy;
import ch.unibas.roo.torrus.client.scaffold.place.FindAndEditProxy;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class SettingsActivitiesMapper extends SettingsActivitiesMapper_Roo_Gwt {

    public SettingsActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new SettingsDetailsActivity((EntityProxyId<SettingsProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? SettingsMobileDetailsView.instance() : SettingsDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
