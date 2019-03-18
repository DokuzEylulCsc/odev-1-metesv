package app;

import model.Asker;
import model.Harita;
import model.Takim;
import utils.MathUtils;

public class Program {
	// hareket et, bekle, saldir
	private int[] olasiliklar = {45,20,35};
	
	public Takim[] createTeams(Harita harita) {
		return new Takim[] {new Takim(harita,0,0), new Takim(harita,11,11)};
	}
	
	public static void main(String[] args) {
		Program app = new Program();
		Harita harita = new Harita();
		Takim[] takimlar = app.createTeams(harita);
		
		if(takimlar[0].getTakim()==null || takimlar[1].getTakim()==null)
			return;

		int turn = 0;
		while(!takimlar[1].getKayip() && !takimlar[0].getKayip()) {
			int next_move = MathUtils.weightedRandom(app.olasiliklar);
			Asker asker = takimlar[turn++ % 2].randomAsker();
			switch (next_move) {
				case 0: asker.hareketEt(); break;
				case 1: asker.bekle(); break;
				case 2: asker.atesEt(); break;
			}
			//clearConsole();
			System.out.println("----------------------");
			harita.printMap();
		}
		if(takimlar[0].getKayip())
			System.out.println("takim 0 kaybetti");
		else
			System.out.println("takim 1 kaybetti");
	}
}
