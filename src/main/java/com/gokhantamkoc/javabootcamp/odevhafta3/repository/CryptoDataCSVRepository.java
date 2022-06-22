package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
System.out.println(filename);

		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz
		
		
		//FileReader readFile = new FileReader(inputStream.toString());
		//File readFile = new File (inputStream.toString());
		InputStreamReader is = new InputStreamReader(inputStream);
		System.out.println("//////////////////");
		System.out.println("//////////////////");
		System.out.println("//////////////////");
		System.out.println("//////////////////");

		System.out.println(is);
		System.out.println(is.toString());
		System.out.println(is.toString());
		System.out.println("//////////////////");
		System.out.println("//////////////////");
		System.out.println("//////////////////");
		System.out.println("//////////////////");
		BufferedReader br = new BufferedReader(is);
		String line = br.readLine();
    	if (line != null) {
        	String[] values = line.split(COMMA_DELIMITER);
			long time = Long.parseLong(values[0]);
			double open = Double.parseDouble (values[3]);
			double high = Double.parseDouble (values[4]);

System.out.println("----------");
			System.out.println(high);
			System.out.println("----------");

			double low = Double.parseDouble (values[5]);
			double close = Double.parseDouble (values[6]);
			double volume = Double.parseDouble (values[7]);
			candles.add(new Candle(time, open, high, low, close, volume));
    	}
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
