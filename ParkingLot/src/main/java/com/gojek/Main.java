package com.gojek;

import com.gojek.execute.AbstractProcess;
import com.gojek.execute.FileProcess;
import com.gojek.execute.InterractiveParkingProcess;
public class Main {
public static void main(String[] args) throws Exception {
		
		AbstractProcess processor = null;
		
		if(args.length >= 1) {
			processor = new FileProcess(args[0]);
		} else {
			processor = new InterractiveParkingProcess();
		}
		processor.process();
	}

}
