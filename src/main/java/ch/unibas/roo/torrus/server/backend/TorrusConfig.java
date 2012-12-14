package ch.unibas.roo.torrus.server.backend;

import java.util.List;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import ch.unibas.roo.torrus.server.domain.Device;

import com.allen_sauer.gwt.log.client.Log;

@EnableScheduling
@Service
public class TorrusConfig {

	private List<Device> devices;

	// @Autowired
	// DeviceRepository deviceRepository;

	@Scheduled(cron = "3/10 * * * * ?")
	public void updateTorrusConfig() {
		try {
			Log.info("Start updating device nodes from torrus config ");
			updateDevices();
			Log.info("Finished updating device nodes from torrus config ");
		} catch (Exception e) {
			Log.warn("Error updating devices", e);
		}

	}

	public void updateDevices() {
		devices = Device.findAllDevices();
		String name = "node1";
		deviceInsertIfNotExisis(name);
		// deviceRepository.flush();
	}

	private void deviceInsertIfNotExisis(String name) {

		Device d = new Device();
		d.setName(name);
		if (!devices.contains(d)) {
			Log.warn("inserting " + name);
			d.persist();
		}
		// if (deviceRepository.findByName(name).size() < 1) {
		// Log.warn("inserting " + name);
		// Device d = new Device();
		// d.setName(name);
		// deviceRepository.save(d);
		// }
	}
}
