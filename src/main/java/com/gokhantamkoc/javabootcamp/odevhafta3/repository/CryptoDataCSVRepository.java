package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import static org.mockito.Answers.values;
import static org.mockito.ArgumentMatchers.booleanThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));		//CSV dosyasını okumayı sağlıyor
		String line = br.readLine();

		boolean flag = true;

    	while (line != null) {		// okunacak satır olduğu sürece döngü  devam ediyor
        	String[] values = line.split(COMMA_DELIMITER);		//satırları virgüllerden ayırarak, her birini bir eleman olarak String e atılmasını sağlıyor
			if(flag){			
				// ilk satırdaki satır isimlerini atlamak için yazılmıştır
				flag = false;
			}
			else{		//csv dosyasındaki rakamların candles'ın değişkenlerine göre ataması yapılıyor
				long time = Long.parseLong(values[0]);
				double open = Double.parseDouble (values[3]);
				double high = Double.parseDouble (values[4]);
				double low = Double.parseDouble (values[5]);
				double close = Double.parseDouble (values[6]);
				double volume = Double.parseDouble (values[7]);
				candles.add(new Candle(time, open, high, low, close, volume));  // List'e ekleme yapılıyor
			}
			line=br.readLine();	
    	}
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
