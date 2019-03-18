package model;

import java.awt.Point;

import utils.MathUtils;

public abstract class Asker {
	private boolean alive = true;
	private Harita harita;
	private Takim takim;
	private int saglik = 100;
	
	private Point koordinat;
	
	public Asker(Takim takim, Point koordinat, Harita harita) {
		this.takim = takim;
		this.koordinat = koordinat;
		this.harita = harita;
		harita.koyAsker(koordinat.x, koordinat.y, this);
	}

	public abstract void bekle();
	
	public abstract void hareketEt();

	public abstract void atesEt();
	
	protected void atesEt(int[] ates, int[] ates_olasilik, int range) {
		int hit = ates[MathUtils.weightedRandom(ates_olasilik)];
		Asker enemy = getHarita().findFirstEnemy(getKoordinat().x, getKoordinat().y, range, this);
		if(enemy!=null) {
			if(hit >= enemy.getSaglik()){
				enemy.getHarita().delete(enemy.getKoordinat());
				enemy.getTakim().delete(enemy);
			} else {
				enemy.setSaglik(enemy.getSaglik() - hit);
			}
		}
	}
	
	public boolean isSameTeam(Asker asker) {
		return asker.takim == this.takim;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean isAlive) {
		this.alive = isAlive;
	}

	public Takim getTakim() {
		return takim;
	}

	public void setTakim(Takim takim) {
		this.takim = takim;
	}

	public int getSaglik() {
		return saglik;
	}

	public void setSaglik(int saglik) {
		this.saglik = saglik;
	}

	public Point getKoordinat() {
		return koordinat;
	}

	public void setKoordinat(Point koordinat) {
		this.koordinat = koordinat;
	}

	public Harita getHarita() {
		return harita;
	}

	public void setHarita(Harita harita) {
		this.harita = harita;
	}
}
