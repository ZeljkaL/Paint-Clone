package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private String bojaUnutrasnjosti = "bela";
	public Color bojaUnutrasnjost=Color.WHITE;

	public Color getBojaUnutrasnjost() {
		return bojaUnutrasnjost;
	}
	public void setBojaUnutrasnjost(Color bojaUnutrasnjost) {
		this.bojaUnutrasnjost = bojaUnutrasnjost;
	}
	protected abstract double povrsina();
	protected abstract double obim();
	protected abstract void popuni(Graphics g);

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
}
