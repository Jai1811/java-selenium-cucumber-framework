	package coeur;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

	public static String getProperties(String Key) {
		try {
			java.util.Properties prop = new java.util.Properties();
			FileInputStream obj = new FileInputStream(System.getProperty("user.dir") +
					"/settings.properties");
			prop.load(obj);

			String value = prop.getProperty(Key);
			return value;
		} catch (IOException e) {
			//
		}
		return null;

	}

}
