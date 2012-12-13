package ch.unibas.roo.torrus.client.view.serverchooser;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class ServerChooserPopupPanel extends PopupPanel implements
		HasChangeHandlers {

	private static ServerChooserPopupPanelUiBinder uiBinder = GWT
			.create(ServerChooserPopupPanelUiBinder.class);

	private List<ChangeHandler> changeHandler = new ArrayList<ChangeHandler>();

	@UiField ListBox lbServers;

	interface ServerChooserPopupPanelUiBinder extends
			UiBinder<Widget, ServerChooserPopupPanel> {
	}

	public ServerChooserPopupPanel() {
		super(true);
		setWidget(uiBinder.createAndBindUi(this));
	}



	@UiHandler("lbServers")
	void onLbServersAttachOrDetach(AttachEvent event) {
		if (event.isAttached()) {
			// AsyncCallback<String[]> getNodesCallback = new
			// AsyncCallback<String[]>() {
			//
			// @Override
			// public void onSuccess(String[] result) {
			// for (int i = 0; i < result.length; i++) {
			// lbServers.addItem(result[i]);
			// }
			// }
			//
			// @Override
			// public void onFailure(Throwable caught) {
			// Window.alert(caught.getMessage());
			// }
			// };
			// TorrusService.Util.getInstance().getNodes(getNodesCallback);
		}
	}

	@UiHandler("lbServers")
	void onLbServersChange(ChangeEvent event) {
		NativeEvent nativeEvent = Document.get().createChangeEvent();
		ChangeEvent.fireNativeEvent(nativeEvent, this);
	}

	public String getSelectedServer() {
		int selectedIndex = lbServers.getSelectedIndex();
		if (selectedIndex > -1) {
			return lbServers.getValue(selectedIndex);
		}
		return null;
	}

	@Override
	public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
		return addDomHandler(handler, ChangeEvent.getType());
	}
}
