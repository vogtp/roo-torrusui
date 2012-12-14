package ch.unibas.roo.torrus.client.managed.ui;

import ch.unibas.roo.torrus.client.managed.activity.DeviceEditActivityWrapper;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.scaffold.place.ProxyEditView;
import ch.unibas.roo.torrus.client.scaffold.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import java.util.Collection;
import java.util.List;

public class DeviceMobileEditView extends DeviceMobileEditView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static ch.unibas.roo.torrus.client.managed.ui.DeviceMobileEditView instance;

    @UiField
    Button save;

    @UiField
    DivElement errors;

    private Delegate delegate;

    public DeviceMobileEditView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static ch.unibas.roo.torrus.client.managed.ui.DeviceMobileEditView instance() {
        if (instance == null) {
            instance = new DeviceMobileEditView();
        }
        return instance;
    }

    @Override
    public RequestFactoryEditorDriver<ch.unibas.roo.torrus.client.proxy.DeviceProxy, ch.unibas.roo.torrus.client.managed.ui.DeviceMobileEditView> createEditorDriver() {
        RequestFactoryEditorDriver<DeviceProxy, DeviceMobileEditView> driver = GWT.create(Driver.class);
        driver.initialize(this);
        return driver;
    }

    public void setCreating(boolean creating) {
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public void setEnabled(boolean enabled) {
        save.setEnabled(enabled);
    }

    public void showErrors(List<com.google.gwt.editor.client.EditorError> errors) {
        SafeHtmlBuilder b = new SafeHtmlBuilder();
        for (EditorError error : errors) {
            b.appendEscaped(error.getPath()).appendEscaped(": ");
            b.appendEscaped(error.getMessage()).appendHtmlConstant("<br>");
        }
        this.errors.setInnerHTML(b.toSafeHtml().asString());
    }

    @UiHandler("save")
    void onSave(ClickEvent event) {
        delegate.saveClicked();
    }

    interface Binder extends UiBinder<HTMLPanel, DeviceMobileEditView> {
    }

    interface Driver extends RequestFactoryEditorDriver<DeviceProxy, DeviceMobileEditView> {
    }
}
