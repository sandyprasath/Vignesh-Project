package com.amazonv.helper;

public class File_Reader_Manager_V {

	private File_Reader_Manager_V() {
		
	}
	
	public File_Reader_Manager_V getInstance() {
File_Reader_Manager_V frm = new File_Reader_Manager_V();
return frm;
	}
	
	public ConfigurationReaderV getInstanceCR() throws Throwable {
ConfigurationReaderV cr = new ConfigurationReaderV();
return cr;
	}
}
