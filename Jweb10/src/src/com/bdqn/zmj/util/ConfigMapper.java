package src.com.bdqn.zmj.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigMapper {

	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			//鍔犺浇閰嶇疆鏂囦欢
			prop.load(ConfigMapper.class.getResourceAsStream("/db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//閫氳繃key鑾峰彇value鍊�
	public static String get(String key) {
		return prop.getProperty(key);
	}
}
