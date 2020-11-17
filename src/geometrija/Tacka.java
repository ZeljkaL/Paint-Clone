package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;
	public Color bojaTacke;
	//public Color bojaTacke=Color.BLACK;



	public Tacka() {

	}
	public Color getBojaTacke() {
		return bojaTacke;
	}
	public void setBojaTacke(Color bojaTacke) {
		this.bojaTacke = bojaTacke;
	}
	public Tacka(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, String boja) {
		this(x, y);
		//super(boja); 
		setBoja(boja);
	}
	/*public Tacka(int x, int y,Color boja) {
		this(x, y);
		//super(boja); 
		setBoja(boja);
	}*/

	public void pomeriNa(int x, int y) {
		this.x = x;
		setY(y);
	}
	public void pomeriZa(int x, int y) {
		this.x = getX() + x;
		this.y += y;
	}

	public double udaljenost(Tacka t) {
		int dX = this.x - t.getX();
		int dY = t.getY() - this.y;
		double d  = Math.sqrt(dX*dX + dY*dY);
		return d;
	}

	// (x, y)
	public String toString() {
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj) {
		if(obj instanceof Tacka) {
			Tacka prosledjena = (Tacka) obj;
			if(x == prosledjena.x && y == prosledjena.y)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void crtajSe(Graphics g) {
		g.setColor(getBojaTacke());
		g.drawLine(x-1, y, x+1, y);
		g.drawLine(x, y+1, x, y-1);

		if(isSelektovan())
			selektovan(g);
	}
	public int compareTo(Object o) {
		if(o instanceof Tacka) {
			Tacka prosledjena = (Tacka) o;
			Tacka pocetak = new Tacka(0, 0);
			return (int) (this.udaljenost(pocetak)-prosledjena.udaljenost(pocetak));
		}
		else
			return 0;
	}
	public void selektovan(Graphics g){
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(x-2, y-2, 4, 4);
	}
	public boolean sadrzi(int x, int y){
		if(new Tacka(x, y).udaljenost(this)<=1)
			return true;
		else
			return false;
	}
	public int getX() {
		return x;
	}
	public void setX(int novoX) {
		x = novoX;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	/*public Color getBojaTacke() {
		return bojaTacke;
	}
	public void setBojaTacke(Color bojaTacke) {
		this.bojaTacke = bojaTacke;
	}*/
}
