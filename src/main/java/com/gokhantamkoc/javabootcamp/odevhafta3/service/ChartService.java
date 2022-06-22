package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

public class ChartService {
	
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() {
		// Bu metodu doldurmanizi bekliyoruz.
		CandleStickChart candleStickChart = new CandleStickChart("BTC/USDT Chart");
		List<Candle> candles = new ArrayList<>();

System.out.println("1");


		try {

System.out.println("2");


			candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");

			System.out.println("3");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for( Candle candle : candles){
			candleStickChart.addCandle(candle.getTime(), candle.getOpen(), candle.getHigh(), candle.getLow(), candle.getClose(),candle.getVolume());
		}

		return candleStickChart;
	}
}
