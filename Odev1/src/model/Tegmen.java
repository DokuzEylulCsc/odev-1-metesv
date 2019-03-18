package model;

import java.awt.Point;

import utils.MathUtils;

public class Tegmen extends Asker{
	private static int[] ates = {10,20,25};
	private static int[] ates_olasilik = {50,30,20};
	private static int range = 2;

	private static int[][] hareket = {{1,0},{-1,0},{0,1},{0,-1}};
	private static int[] hareket_olasilik = {25,25,25,25};
	
	public Tegmen(Takim takim, Point koordinat, Harita harita) {
		super(takim, koordinat, harita);
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
