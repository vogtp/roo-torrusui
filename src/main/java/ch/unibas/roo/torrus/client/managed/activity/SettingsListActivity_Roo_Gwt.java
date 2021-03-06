// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

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

public abstract class SettingsListActivity_Roo_Gwt extends AbstractProxyListActivity<SettingsProxy> implements IsScaffoldMobileActivity {

    protected ApplicationRequestFactory requests;

    public SettingsListActivity_Roo_Gwt(PlaceController placeController, ProxyListView<ch.unibas.roo.torrus.client.proxy.SettingsProxy> view, Class<ch.unibas.roo.torrus.client.proxy.SettingsProxy> proxyType) {
        super(placeController, view, proxyType);
    }

    protected void fireCountRequest(Receiver<java.lang.Long> callback) {
        requests.settingsRequest().countSettingses().fire(callback);
    }
}
