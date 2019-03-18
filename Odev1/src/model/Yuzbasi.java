package model;

import java.awt.Point;

import utils.MathUtils;

public class Yuzbasi extends Asker {
	private static int[] ates = {15,25,40};
	private static int[] ates_olasilik = {50,30,20};
	private static int range = 3;

	private static int[][] hareket = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{-1,1},{-1,-1}};
	private static int[] hareket_olasilik = {25,25,25,25,25,25,25,25};
	
	public Yuzbasi(Takim takim, Point koordinat, Harita harita) {
		super(takim, koordinat, harita);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bekle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hareketEt() {
		int m = MathUtils.weightedRandom(hareket_olasilik);
		int x = getKoordinat().x, y = getKoordinat().y;
		
		if(getHarita().checkLimit(x+hareket[m][0], y+hareket[m][1]) &&
				getHarita().isEmpty(x+hareket[m][0], y+hareket[m][1])) 
			getKoordinat().translate(hareket[m][0], hareket[m][1]);

		getHarita().hareketEt(x, y, this);
	}

	public void atesEt() {
		super.atesEt(ates, ates_olasilik, range);
	}


}
