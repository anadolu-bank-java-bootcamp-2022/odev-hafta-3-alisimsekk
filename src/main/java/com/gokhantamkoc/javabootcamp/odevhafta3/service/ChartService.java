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
		try {
			candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");		//mumların değerleri csv den okunur
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		for( Candle candle : candles){
			candleStickChart.addCandle(candle.getTime(), candle.getOpen(), candle.getHigh(), candle.getLow(), candle.getClose(),candle.getVolume());      //mumların değerleri grafiğe çizilmek üzere candlestickchart nesneleri oluşturulur.
		}

		return candleStickChart;
	}
}
