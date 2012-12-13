// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationEntityTypesProcessor;
import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.proxy.SettingsProxy;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public abstract class ApplicationDetailsActivities_Roo_Gwt implements ActivityMapper {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    public Activity getActivity(Place place) {
        if (!(place instanceof ProxyPlace)) {
            return null;
        }
        final ProxyPlace proxyPlace = (ProxyPlace) place;
        return new ApplicationEntityTypesProcessor<Activity>() {

            @Override
            public void handleSettings(SettingsProxy proxy) {
                setResult(new SettingsActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }
        }.process(proxyPlace.getProxyClass());
    }
}