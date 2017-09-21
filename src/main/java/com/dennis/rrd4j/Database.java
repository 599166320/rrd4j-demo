package com.dennis.rrd4j;

import java.io.IOException;

import org.rrd4j.ConsolFun;
import org.rrd4j.DsType;
import org.rrd4j.core.RrdDb;
import org.rrd4j.core.RrdDef;

public class Database {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis()/1000;
		RrdDef rrdDef = new RrdDef("d:\\test.rrd", start, 60);

		rrdDef.addDatasource("users", DsType.GAUGE, 60*2, 0, Double.NaN); 
		rrdDef.addDatasource("devices", DsType.GAUGE, 60*2, 0, Double.NaN);

		/** 每分钟一个存档, 两年共计 2*365*24*60 */
		rrdDef.addArchive(ConsolFun.AVERAGE, 0.5, 1, 2*365*24*60); 
		                
		/** 每小时一个存档, 两年共计2*365*24 */
		rrdDef.addArchive(ConsolFun.AVERAGE, 0.5, 60, 2*365*24); 
		        
		/** 每天一个存档, 两年共计2*365 */
		rrdDef.addArchive(ConsolFun.AVERAGE, 0.5, 60*24, 2*365);
		RrdDb rrdDb = new RrdDb(rrdDef);
		rrdDb.close();
	}
	
}
