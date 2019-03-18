package utils;

import java.util.Random;

public class MathUtils {
	public static int weightedRandom(int[] olasilik) {
		Random rand = new Random();
		
		int sum = 0;
		for(int s: olasilik)
			sum+=s;
		
		int h = rand.nextInt(sum), i = 0, weight = olasilik[i++];
		
		while(h>=weight && i<olasilik.length)
			weight += olasilik[i++];
		
		return i-1;
	}
}
