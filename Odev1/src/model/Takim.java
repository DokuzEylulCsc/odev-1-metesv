package model;

import java.awt.Point;
import java.util.Random;

import utils.Bolge;

public class Takim {
	private Asker[] takim = null;
	private int asker_sayisi = 7;
	private boolean kayip = false;
	private Random rand = new Random();
	
	public Takim(Harita harita, int start_x, int start_y) {
		if(harita.checkLimit(start_x+4, start_y+4)) {
			takim = new Asker[7];
			int[] loc = Bolge.randomLocation(5, 1, 2, 4);

			for (int i = 0, j = 0; i < loc.length; i++) {
				int x = start_x+i/5, y = start_y+i%5;
				if(loc[i]==3) takim[j++] = new Yuzbasi(this, new Point(x,y), harita);
				else if(loc[i]==2) takim[j++] = new Tegmen(this, new Point(x,y), harita);
				else if(loc[i]==1) takim[j++] = new Er(this, new Point(x,y), harita);
			}
		}
	}
	
	public Asker randomAsker() {
		return takim[rand.nextInt(asker_sayisi)];
	}
	
	public void delete(Asker asker) {
		int i = 0;
		boolean found = false;
		while(!found && i<takim.length) {
			if(takim[i]==asker) {
				takim[i] = takim[asker_sayisi-1];
				if(--asker_sayisi==0)
					kayip = true;

				found = true;
			}
			i++;
		}
	}

	public boolean getKayip() {
		return kayip;
	}

	public Asker[] getTakim() {
		return takim;
	}

	public void setTakim(Asker[] takim) {
		this.takim = takim;
	}

	public int getAsker_sayisi() {
		return asker_sayisi;
	}

	public void setAsker_sayisi(int asker_sayisi) {
		this.asker_sayisi = asker_sayisi;
	}

}
