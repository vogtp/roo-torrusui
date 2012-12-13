package ch.unibas.roo.torrus.client;


import ch.unibas.roo.torrus.client.view.imageoverview.ImageOverview;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TorrusEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		Log.setUncaughtExceptionHandler();

		// use deferred command to catch initialization exceptions in
		// onModuleLoad2
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				onModuleLoad2();
			}
		});
	}

	public void onModuleLoad2() {
		Log.warn("Main loaded");
		// RootPanel rootPanel = RootPanel.get("root");
		// RootPanel.get("loading").setVisible(false);
		RootPanel rootPanel = RootPanel.get("loading");
		rootPanel.add(new ImageOverview());

	}

}
