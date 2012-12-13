package ch.unibas.roo.torrus.client.scaffold.ioc;

import ch.unibas.roo.torrus.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
