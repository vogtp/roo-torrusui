package ch.unibas.roo.torrus.client.scaffold.ioc;

import ch.unibas.roo.torrus.client.scaffold.ScaffoldMobileApp;
import com.google.gwt.inject.client.GinModules;

@GinModules(value = {ScaffoldModule.class})
public interface MobileInjector extends ScaffoldInjector {

	ScaffoldMobileApp getScaffoldApp();
}
