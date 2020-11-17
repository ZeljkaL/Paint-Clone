package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int stranica;

	public Kvadrat() {

	}
	public Kvadrat(Tacka goreLevo, int stranica) {
		this.goreLevo = goreLevo;
		this.stranica = stranica;

	}
	public Kvadrat(Tacka goreLevo, int stranica, String boja) {
		this(goreLevo, stranica);
		setBoja(boja);
	}
	public Kvadrat(Tacka goreLevo, int stranica, Color boja) {
		this(goreLevo, stranica);
		setBoja(boja);
	}
	public void pomeriNa(int x, int y) {
		goreLevo.pomeriNa(x, y);
	}
	public void pomeriZa(int poX, int poY) {
		goreLevo.pomeriZa(poX, poY);
	}
	public double povrsina() {
		return stranica*stranica;
	}
	public double obim() {
		return 4*stranica;
	}
	//Tacka gore levo=(xGoreLevo,yGoreLevo), duzina stranice=stranica
	public String toString() {
		return "Tacka gore levo = "+getGoreLevo()+", duzina stranice = "+stranica;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Kvadrat) {
			Kvadrat prosledjen = (Kvadrat) obj;
			if(goreLevo.equals(prosledjen.goreLevo) && stranica == prosledjen.stranica)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBojaIvice());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, stranica);

		if(isSelektovan())
			selektovan(g);
	}
	public Linija dijagonala() {
		Tacka doleDesno = new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+stranica);
		return new Linija(goreLevo, doleDesno);
	}
	public Tacka centar() {
		return dijagonala().sredinaLinije();
	}
	protected void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjost());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, stranica-1);
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica), dijagonala().gettKrajnja()).selektovan(g);
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + stranica)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + stranica))
			return true;
		else 
			return false;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public int getStranica() {
		return stranica;
	}
	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

}
