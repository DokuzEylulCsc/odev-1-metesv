package model;

import java.awt.Point;

import utils.MathUtils;

public class Er extends Asker{
	private static int[] ates = {5,10,15};
	private static int[] ates_olasilik = {50,30,20};
	private static int range = 1;
	
	private static int[][] hareket = {{1,0},{-1,0}};
	private static int[] hareket_olasilik = {50,50};
	
	public Er(Takim takim, Point koordinat, Harita harita) {
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
		else 
			if(m == 0 && getHarita().checkLimit(x, y-1) &&
					getHarita().isEmpty(x, y-1))
				getKoordinat().translate(0,-1);
			else if(m == 1 && getHarita().checkLimit(x, y+1) && 
					getHarita().isEmpty(x, y+1))
				getKoordinat().translate(0,1);

		getHarita().hareketEt(x, y, this);
	}


	public void atesEt() {
		super.atesEt(ates, ates_olasilik, range);
	}


}
