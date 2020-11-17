package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private String boja = "crna";
	private boolean selektovan;
	public Color bojaIvice;

	public Color getBojaIvice() {
		return bojaIvice;
	}
	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);

	public static Color pronadjiBoju(String boja) {
		if(boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(boja.equalsIgnoreCase("roze"))
			return Color.PINK;
		else if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else
			return Color.BLACK;


	}

	public Oblik() {

	}
	public Oblik(String boja) {
		this.boja = boja;
	}
	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}
	public void setBoja(Color boja) {
		bojaIvice = boja;
	}

	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	public void setBojaUnutrasnjost(Color bojaUnutrasnjosti) {
		// TODO Auto-generated method stub

	}


}
