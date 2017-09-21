package com.dennis.rrd4j;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.rrd4j.core.RrdDb;
import org.rrd4j.core.Sample;

public class Insert {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final RrdDb rrdDb = new RrdDb("d:\\test.rrd");
        final Random random = new Random();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Sample sample;
				try {
					sample = rrdDb.createSample();
					long time = System.currentTimeMillis() / 1000;
					System.out.println(time);
	                sample.setTime(time);
	                sample.setValue("users", random.nextInt(1000));
	                sample.setValue("devices", random.nextInt(1000));
	                sample.update();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
        }, 60 * 1000, 60 * 1000);
	}

}
