package ch.unibas.roo.torrus.client.helper;


public class TorrusUrl {

	public static String buidlImageUrl(String serverName, String value,
			String time) {
		StringBuilder sb = new StringBuilder();
		sb.append(buidlServerUrl(serverName));
		sb.append(value);
		sb.append("&view=");
		sb.append(time);
		return sb.toString();
	}

	public static String buidlServerUrl(String serverName) {
		StringBuilder sb = new StringBuilder();
		sb.append("http://");
		sb.append(TorrusConfig.SERVER);
		sb.append("/torrus/");
		sb.append(TorrusConfig.TREE);
		sb.append("?path=/");
		sb.append(serverName);
		sb.append("/");
		return sb.toString();
	}

}
