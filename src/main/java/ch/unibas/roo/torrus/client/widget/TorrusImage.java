package ch.unibas.roo.torrus.client.widget;

import ch.unibas.roo.torrus.client.helper.TorrusUrl;

import com.google.gwt.user.client.ui.Image;

public class TorrusImage extends Image {



	private String serverName;
	private String value;
	private String view;
	private int origSize = 597;

	public TorrusImage(String serverName, String value, String view) {
		super(TorrusUrl.buidlImageUrl(serverName, value, view));
		this.serverName = serverName;
		this.value = value;
		this.view = view;
	}

	public void setView(String v) {
		view = v;
		setUrl(TorrusUrl.buidlImageUrl(serverName, value, view));
	}

	public void scaleImages(float f) {
		if (origSize < 0) {
			origSize = getWidth();
			if (origSize < 1) {
				return;
			}
		}
		int newWidth = Math.round(origSize * f);
		setWidth(newWidth + "px");
	}

}