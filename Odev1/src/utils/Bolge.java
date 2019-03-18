package utils;

import java.util.Random;

public class Bolge {
	//yuzbasi_no, tegmen_no, er_no
	public static int[] randomLocation(int n, int y_n, int t_n, int e_n) {
		int[] loc = new int[n*n];
		int i = 0 , j;
		for(j=0; j<y_n; j++) loc[i++] = 3;
		for(j=0; j<t_n; j++) loc[i++] = 2;
		for(j=0; j<e_n; j++) loc[i++] = 1;
		for(j=0; j<n*n-y_n-t_n-e_n; j++) loc[i++] = 0;
		Random rand = new Random();
		
		for(i = 0; i<n*n; i++) {
			j = rand.nextInt(n*n);
			int temp = loc[i];
			loc[i] = loc[j];
			loc[j] = temp;
		}
		
		return loc;
		
	}
}
