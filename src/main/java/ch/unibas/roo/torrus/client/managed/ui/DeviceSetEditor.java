package ch.unibas.roo.torrus.client.managed.ui;

import ch.unibas.roo.torrus.client.managed.ui.DeviceSetEditor.NameLabel;
import ch.unibas.roo.torrus.client.proxy.DeviceProxy;
import ch.unibas.roo.torrus.client.scaffold.ui.CollectionRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeviceSetEditor extends DeviceSetEditor_Roo_Gwt {

    @UiField
    FlexTable table;

    @UiField(provided = true)
    @Ignore
    ValueListBox<DeviceProxy> picker = new ValueListBox<DeviceProxy>(ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer.instance(), new com.google.web.bindery.requestfactory.gwt.ui.client.EntityProxyKeyProvider<DeviceProxy>());

    @UiField
    Button add;

    @UiField
    HTMLPanel editorPanel;

    @UiField
    Button clickToEdit;

    @UiField
    HTMLPanel viewPanel;

    @UiField
    Label viewLabel;

    @UiField
    Style style;

    boolean editing = false;

    private Set<DeviceProxy> values;

    private final List<DeviceProxy> displayedList;

    public DeviceSetEditor() {
        initWidget(GWT.<Binder>create(Binder.class).createAndBindUi(this));
        Driver driver = GWT.<Driver>create(Driver.class);
        ListEditor<DeviceProxy, NameLabel> listEditor = ListEditor.of(new NameLabelSource());
        driver.initialize(listEditor);
        driver.display(new ArrayList<DeviceProxy>());
        displayedList = listEditor.getList();
        editing = false;
    }

    @UiHandler("add")
    public void addClicked(ClickEvent e) {
        if (picker.getValue() == null) {
            return;
        }
        for (DeviceProxy proxy : displayedList) {
            if (proxy.getName().equals(picker.getValue().getName())) {
                return;
            }
        }
        displayedList.add(picker.getValue());
        viewLabel.setText(makeFlatList(displayedList));
        addToTable(picker.getValue());
    }

    @UiHandler("clickToEdit")
    public void clickToEditClicked(ClickEvent e) {
        toggleEditorMode();
    }

    @Override
    public void flush() {
    }

    @Override
    public Set<ch.unibas.roo.torrus.client.proxy.DeviceProxy> getValue() {
        if (values == null && displayedList.size() == 0) {
            return null;
        }
        return new HashSet<DeviceProxy>(displayedList);
    }

    public void onLoad() {
        makeEditable(false);
    }

    @Override
    public void onPropertyChange(String... strings) {
    }

    public void setAcceptableValues(Collection<ch.unibas.roo.torrus.client.proxy.DeviceProxy> proxies) {
        picker.setAcceptableValues(proxies);
    }

    @Override
    public void setDelegate(EditorDelegate<java.util.Set<ch.unibas.roo.torrus.client.proxy.DeviceProxy>> editorDelegate) {
    }

    @Override
    public void setValue(Set<ch.unibas.roo.torrus.client.proxy.DeviceProxy> values) {
        this.values = values;
        makeEditable(editing = false);
        if (displayedList != null) {
            displayedList.clear();
            table.clear();
            if (values != null) {
                for (DeviceProxy e : values) {
                    displayedList.add(e);
                    addToTable(e);
                }
            }
        }
        viewLabel.setText(makeFlatList(values));
    }

    private void addToTable(DeviceProxy value) {
        addToTable(value, displayedList.size() - 1);
    }

    private void addToTable(DeviceProxy value, int index) {
        final int finalIndex = index;
        if (value != null) {
            table.setText(finalIndex, 0, ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer.instance().render(value));
            Button removeEntryButton = new Button("x");
            removeEntryButton.addClickHandler(new ClickHandler() {

                public void onClick(final ClickEvent event) {
                    displayedList.remove(finalIndex);
                    table.removeRow(finalIndex);
                    viewLabel.setText(makeFlatList(displayedList));
                }
            });
            table.setWidget(finalIndex, 1, removeEntryButton);
        }
    }

    private void makeEditable(boolean editable) {
        if (editable) {
            editorPanel.setStylePrimaryName(style.editorPanelVisible());
            viewPanel.setStylePrimaryName(style.viewPanelHidden());
            clickToEdit.setText("Done");
        } else {
            editorPanel.setStylePrimaryName(style.editorPanelHidden());
            viewPanel.setStylePrimaryName(style.viewPanelVisible());
            clickToEdit.setText("Edit");
        }
    }

    private String makeFlatList(Collection<ch.unibas.roo.torrus.client.proxy.DeviceProxy> values) {
        return CollectionRenderer.of(ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer.instance()).render(values);
    }

    private void toggleEditorMode() {
        editing = !editing;
        makeEditable(editing);
    }

    interface Binder extends UiBinder<Widget, DeviceSetEditor> {
    }

    interface Driver extends RequestFactoryEditorDriver<List<DeviceProxy>, ListEditor<DeviceProxy, NameLabel>> {
    }

    class NameLabel extends Composite implements LeafValueEditor<DeviceProxy> {

        final Label nameEditor = new Label();

        private DeviceProxy proxy = null;

        public NameLabel() {
            this(null);
        }

        public NameLabel(EventBus eventBus) {
            initWidget(nameEditor);
        }

        public void setValue(DeviceProxy proxy) {
            this.proxy = proxy;
            nameEditor.setText(ch.unibas.roo.torrus.client.managed.ui.DeviceProxyRenderer.instance().render(proxy));
        }

        @Override
        public DeviceProxy getValue() {
            return proxy;
        }
    }

    interface Style extends CssResource {

        String editorPanelHidden();

        String editorPanelVisible();

        String viewPanelHidden();

        String viewPanelVisible();
    }

    private class NameLabelSource extends EditorSource<NameLabel> {

        @Override
        public NameLabel create(int index) {
            NameLabel label = new NameLabel();
            addToTable(label.getValue(), index);
            return label;
        }

        @Override
        public void dispose(NameLabel subEditor) {
            subEditor.removeFromParent();
        }

        @Override
        public void setIndex(NameLabel editor, int index) {
            addToTable(editor.getValue(), index);
        }
    }
}
