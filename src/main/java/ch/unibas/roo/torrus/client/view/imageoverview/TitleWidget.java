package ch.unibas.roo.torrus.client.view.imageoverview;

import java.util.LinkedList;

import ch.unibas.roo.torrus.client.helper.TorrusUrl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TitleWidget extends VerticalPanel {


	public TitleWidget(ImageOverview parent, final String title,
			final LinkedList<String> list,
				String removeKey) {
		this(parent, title, null, list, removeKey);
		}

	public TitleWidget(final ImageOverview parent, final String title,
			String link,
 final LinkedList<String> list, final String removeKey) {
			super();
			Anchor remove = new Anchor("Remove");
			remove.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					list.remove(removeKey);
				parent.updateGrid();
				}
			});

			if (link != null) {
				Anchor a = new Anchor(title);
				a.setHref(TorrusUrl.buidlServerUrl(link));
				add(a);
				add(remove);
			} else {
				Label tbTitle = new Label(title);
				add(tbTitle);
				add(remove);
			}
		}

	}
