package ch.unibas.roo.torrus.client.managed.activity;

import ch.unibas.roo.torrus.client.managed.request.ApplicationRequestFactory;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.scaffold.activity.IsScaffoldMobileActivity;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyEditView;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyListPlace;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DeviceEditActivityWrapper extends DeviceEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<DeviceProxy> proxyId;

    public DeviceEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<ch.unibas.roo.torrus.client.proxy.DeviceProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(DeviceProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Device" : "Edit Device";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends ch.unibas.roo.torrus.client.scaffold.place.ProxyEditView<ch.unibas.roo.torrus.client.proxy.DeviceProxy, V>> extends ProxyEditView<DeviceProxy, V> {
    }
}
