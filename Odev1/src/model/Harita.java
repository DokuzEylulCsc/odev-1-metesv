package model;

import java.awt.Point;

public class Harita {
	private Asker[][] harita = new Asker[16][16];
	
	public Harita() {
		super();
	}
	
	public void koyAsker(int x, int y, Asker asker) {
		harita[x][y] = asker;
	}

	// verilen koordinat oyun tahtasi icerisinde mi kontrolu yapar
	public boolean checkLimit(int x, int y) {
		return x>=0 && y>=0 && y<=15 && x<=15;
	}
	
	public boolean isEmpty(int x, int y) {
		return harita[x][y] == null;
	}
	
	public void hareketEt(int x, int y,Asker asker) {
		harita[x][y] = null;
		harita[asker.getKoordinat().x][asker.getKoordinat().y] = asker;
	}
	
	public boolean isEnemy(int x, int y, Asker asker) {
		return !isEmpty(x, y) && !harita[x][y].isSameTeam(asker);
	}
	
	public Asker findFirstEnemy(int x, int y, int range, Asker asker) {
		int n_x = x-range, n_y = y-range;
		for (int i = n_x; i <= x+range; i++)
			for (int j = n_y; j <= y+range; j++)
				if(checkLimit(i, j) && isEnemy(i, j, asker))
					return harita[i][j];
		return null;
	}
	
	public void delete(Point p) { harita[p.x][p.y] = null; }
	
	public String getName(Asker asker) {
		if(asker == null)
			return ".";
		if(asker instanceof Er)
			return "E";
		else if (asker instanceof Tegmen)
			return "T";
		return "Y";
	}
	public void printMap() {
		for (int i = 0; i < harita.length; i++) {
			for (int j = 0; j < harita.length; j++) {
				System.out.print(getName(harita[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
