package com.gojek.execute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileProcess extends AbstractProcess {
	String filePath = null;

	public FileProcess(String filePath) {
		this.filePath = filePath;
	}

	public void process() throws Exception {
		File inputFile = new File(filePath);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		String line;
		while ((line = br.readLine()) != null) {
			validateAndProcess(line);
		}
	}

}
