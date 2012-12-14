package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.scaffold.activity.IsScaffoldMobileActivity;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyDetailsView;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyListPlace;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace.Operation;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.Set;

public class DeviceDetailsActivity extends DeviceDetailsActivity_Roo_Gwt {

    public DeviceDetailsActivity(EntityProxyId<ch.unibas.roo.torrus.client.proxy.DeviceProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, ProxyDetailsView<ch.unibas.roo.torrus.client.proxy.DeviceProxy> view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(DeviceProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View Device";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((DeviceProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
