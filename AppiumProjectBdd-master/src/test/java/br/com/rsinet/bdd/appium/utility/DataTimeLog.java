package br.com.rsinet.bdd.appium.utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DataTimeLog {
	@SuppressWarnings("restriction")
	public static String dateHourForFile() {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts);
	}
}
