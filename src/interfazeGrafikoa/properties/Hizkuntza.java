package interfazeGrafikoa.properties;

import java.io.IOException;
import java.util.Properties;

public class Hizkuntza extends Properties {
	private static final long serialVersionUID = 1L;

	public Hizkuntza(String hizkuntza) {
		getProperties(hizkuntza+".properties");
	}

	private void getProperties(String hizkuntza) {
		try {
			this.load(getClass().getResourceAsStream(hizkuntza));
		} catch (IOException ex) {

		}
	}
}