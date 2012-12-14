package ch.unibas.roo.torrus.server.backend;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ch.unibas.roo.torrus.server.domain.Device;

import com.allen_sauer.gwt.log.client.Log;

public class TorrusNodeConfigParser {

	private static final String NODE_CONFIG = "/etc/torrus/xmlconfig/spectrum_nodes.xml";
	private long lastModified;
	private String torrusHome;
	private List<Device> devices;

	public TorrusNodeConfigParser(String torrusHome) {
		super();
		devices = Device.findAllDevices();
		this.torrusHome = torrusHome;
	}

	public void parseAvailableNodes() throws ParserConfigurationException,
			SAXException, IOException {
		File nodeConfig = new File(torrusHome + NODE_CONFIG);
		long lm = nodeConfig.lastModified();
		if (lastModified < lm) {
			lastModified = lm;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(nodeConfig);

			NodeList includes = document.getElementsByTagName("include");

			for (int i = 0; i < includes.getLength(); i++) {
				Node filenmeAttr = includes.item(i).getAttributes()
						.getNamedItem("filename");
				String filename = filenmeAttr.getNodeValue();
				filename = filename.replace("nodes/", "");
				filename = filename.replace(".xml", "");
				deviceInsertIfNotExisis(filename);
			}
		}

	}

	private void deviceInsertIfNotExisis(String name) {

		Device d = new Device();
		d.setName(name);
		if (!devices.contains(d)) {
			Log.warn("inserting " + name);
			d.persist();
			d.flush();
		}
		// if (deviceRepository.findByName(name).size() < 1) {
		// Log.warn("inserting " + name);
		// Device d = new Device();
		// d.setName(name);
		// deviceRepository.save(d);
		// }
	}
}
