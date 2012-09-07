package dk.itu.sdg.language.coral.checker

import java.io.IOException;
import java.io.InputStream;

class CoralProperties {
	
	def static Properties coralProperties = new Properties()
	
	static public void readProperties() {
		
		def InputStream propertiesInputStream = CoralProperties.class.getClassLoader().getResourceAsStream("Coral.properties")
		try {
			coralProperties.load(propertiesInputStream)
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
