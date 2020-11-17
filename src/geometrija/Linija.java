package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik implements Pomerljiv{
	private Tacka tPocetna;
	private Tacka tKrajnja;
	public Color bojaIviceL=Color.BLACK;

	public Color getBojaIviceL() {
		return bojaIviceL;
	}
	public void setBojaIviceL(Color bojaIviceL) {
		this.bojaIviceL = bojaIviceL;
	}
	public Linija() {

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja) {
		this.tPocetna = tPocetna;
		settKrajnja(tKrajnja);
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja, String boja) {
		this(tPocetna, tKrajnja);
		setBoja(boja);
	}

	public void pomeriZa(int poX, int poY) {
		tPocetna.pomeriZa(poX, poY);
		tKrajnja.pomeriZa(poX, poY);
	}
	public double duzina() {
		return tPocetna.udaljenost(tKrajnja);
	}
	// (xp,yp)-->(xk,yk)
	public String toString() {
		return gettPocetna()+"-->"+gettKrajnja();
	}
	public boolean equals(Object obj) {
		if(obj instanceof Linija) {
			Linija prosledjena = (Linija) obj;
			if(tPocetna.equals(prosledjena.tPocetna) && tKrajnja.equals(prosledjena.tKrajnja))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBojaIviceL());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());

		if(isSelektovan())
			selektovan(g);
	}
	public Tacka sredinaLinije(){
		int xSredine = (tPocetna.getX() + tKrajnja.getX())/2;
		int ySredine = (tPocetna.getY() + tKrajnja.getY())/2;
		Tacka sredinaLinije = new Tacka(xSredine, ySredine);
		return sredinaLinije;
	}
	public void pomeriNa(int x, int y) {

	}
	public int compareTo(Object o) {
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int) (this.duzina()-pomocna.duzina());
		}
		else 
			return 0;
	}
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}
	public boolean sadrzi(int x, int y){
		Tacka pomocna = new Tacka(x, y);
		if((tPocetna.udaljenost(pomocna)+tKrajnja.udaljenost(pomocna))-duzina()<=1)
			return true;
		else
			return false;
	}
	public Tacka gettPocetna() {
		return tPocetna;
	}
	public void settPocetna(Tacka tPocetna) {
		this.tPocetna = tPocetna;
	}
	public Tacka gettKrajnja() {
		return tKrajnja;
	}
	public void settKrajnja(Tacka tKrajnja) {
		this.tKrajnja = tKrajnja;
	}

}
