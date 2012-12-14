package ch.unibas.roo.torrus.server.backend;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.allen_sauer.gwt.log.client.Log;

@EnableScheduling
@Service
public class TorrusConfig {

	private static final String TORRUS_HOME = "/opt/pm/";
	private static final String TORRUS_HOME_WINDOWS = "c:/torrus/pm/";

	private String torrusHome;

	// @Autowired
	// DeviceRepository deviceRepository;

	@Scheduled(cron = "3/10 * * * * ?")
	public void updateTorrusConfig() {
		if (new File(TORRUS_HOME).exists()) {
			torrusHome = TORRUS_HOME;
		} else if (new File(TORRUS_HOME_WINDOWS).exists()) {
			torrusHome = TORRUS_HOME_WINDOWS;
		} else {
			Log.fatal("Cannot find torrus home not updating configuration");
			return;
		}
		try {
			Log.info("Start updating device nodes from torrus config ");
			updateDevices();
			Log.info("Finished updating device nodes from torrus config ");
		} catch (Exception e) {
			Log.warn("Error updating torrus config", e);
		}

	}

	public void updateDevices() throws ParserConfigurationException,
			SAXException, IOException {
		TorrusNodeConfigParser torrusParser = new TorrusNodeConfigParser(
				torrusHome);
		torrusParser.parseAvailableNodes();
	}



}
