package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationEntityTypesProcessor;
import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.managed.ui.SettingsListView;
import ch.unibas.roo.torrus.client.managed.ui.SettingsMobileListView;
import ch.unibas.roo.torrus.client.proxy.SettingsProxy;
import ch.unibas.roo.torrus.client.scaffold.ScaffoldApp;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
