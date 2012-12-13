package ch.unibas.roo.torrus.server.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
public class TorrusConfig {
	public String[] getNodes() throws Exception {
		try {
			// return torrusParser.getAvailableNodes();
			return new String[] { "node1", "node2" };
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
