package managers;

import dataProvider.ConfigFileReader;
import dataProvider.JSonDataReader;

public class FileReaderMng {

	private static FileReaderMng fileReader = new FileReaderMng();
	private static ConfigFileReader configReader;
	private static JSonDataReader jsonDataReader;
	
	private FileReaderMng () {
		
	}
	
	public static FileReaderMng getInstance() {
		return fileReader;
	}
	
	public ConfigFileReader getConfigReader() {
		return (configReader == null) ? configReader = new ConfigFileReader() : configReader;
	}
	
	public JSonDataReader getJsonReader() {
		return (jsonDataReader == null) ? jsonDataReader = new JSonDataReader() : jsonDataReader;
	}
	
}
