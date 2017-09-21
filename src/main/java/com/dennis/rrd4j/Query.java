package com.dennis.rrd4j;

import java.io.IOException;

import org.rrd4j.ConsolFun;
import org.rrd4j.core.FetchData;
import org.rrd4j.core.FetchRequest;
import org.rrd4j.core.RrdDb;
import org.rrd4j.core.Util;

/**
 * Hello world!
 *
 */
public class Query 
{
    public static void main( String[] args ) throws IOException
    {
    	
    	final RrdDb rrdDb = new RrdDb("d:\\test.rrd");
		FetchRequest request = rrdDb.createFetchRequest(
                ConsolFun.AVERAGE, 1506015211, 1506015800, 60);
		FetchData fetchData = request.fetchData();
		double[] values = fetchData.getValues("users");
		System.out.println(values);
    }
}
