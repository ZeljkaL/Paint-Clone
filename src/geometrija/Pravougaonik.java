package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int sirina;
	public Color bojaUP=Color.WHITE;
	public Color bojaIvicePr=Color.BLACK;

	public Color getBojaIvicePr() {
		return bojaIvicePr;
	}
	public void setBojaIvicePr(Color bojaIvicePr) {
		this.bojaIvicePr = bojaIvicePr;
	}
	public Color getBojaUP() {
		return bojaUP;
	}
	public void setBojaUP(Color bojaUP) {
		this.bojaUP = bojaUP;
	}
	public Pravougaonik() {

	}
	public Pravougaonik(Tacka goreLevo, int visina, int sirina) {
		this.goreLevo = goreLevo;
		setStranica(visina);
		this.sirina = sirina;
	}
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja) {
		this(goreLevo, visina, sirina);
		setBoja(boja);
	}
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, Color boja) {
		this(goreLevo, visina, sirina);
		setBoja(boja);
	}


	public double povrsina(){
		return stranica * sirina;
	}
	public double obim() {
		return (2*stranica + 2*sirina);
	}
	//Tacka gore levo=(xGoreLevo,yGoreLevo), sirina=sirina, visina=visina
	public String toString() {
		return "Tacka gore levo = "+getGoreLevo()+", sirina = "+sirina+", visina = "+stranica;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Pravougaonik) {
			Pravougaonik prosledjen = (Pravougaonik) obj;
			if(goreLevo.equals(prosledjen.goreLevo) && 
					stranica == prosledjen.stranica && 
					sirina == prosledjen.sirina)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBojaIvicePr());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), sirina, stranica);

		if(isSelektovan())
			selektovan(g);
	}
	public Linija dijagonala() {
		Tacka doleDesno = new Tacka(goreLevo.getX()+sirina, goreLevo.getY()+stranica);
		return new Linija(goreLevo, doleDesno);
	}
	protected void popuni(Graphics g) {
		g.setColor(getBojaUP());

		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, sirina-1, stranica-1);
	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+sirina, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+sirina, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica), dijagonala().gettKrajnja()).selektovan(g);
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + sirina)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + stranica))
			return true;
		else 
			return false;
	}
	public int getSirina() {
		return sirina;
	}
	public void setSirina(int sirina) {
		this.sirina = sirina;
	}
}
