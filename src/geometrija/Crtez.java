package geometrija;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Crtez extends JPanel {

	public ArrayList<Oblik> oblici= new ArrayList<Oblik>();



	public Crtez()
	{

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame prozor = new JFrame("Crtež");
		prozor.setSize(800, 600);
		Crtez crtez = new Crtez();
		prozor.getContentPane().add(crtez);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prozor.setVisible(true);

	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Pravougaonik podloga = new Pravougaonik(new Tacka(2,2),800,1400, "bela");
		podloga.setBojaUnutrasnjosti("bela");
		podloga.crtajSe(g);
		podloga.popuni(g);



		Iterator<Oblik> it = oblici.iterator();
		while(it.hasNext())
		{
			Oblik o = it.next();
			o.crtajSe(g);
			if(o.isSelektovan()==true)
				o.selektovan(g);
			if(o instanceof Kvadrat) {
				Kvadrat k= new Kvadrat();
				k=(Kvadrat)o;
				k.popuni(g);
			}
			if(o instanceof Pravougaonik) {

				Pravougaonik p= new Pravougaonik();
				p=(Pravougaonik)o;
				p.popuni(g);
			}
			if(o instanceof Krug) {
				Krug kr= new Krug();
				kr=(Krug)o;
				kr.popuni(g);

			}
		}

		repaint();
	}
	public ArrayList<Oblik> getOblici() {
		return oblici;
	}

	public void setOblici(ArrayList<Oblik> oblici) {
		this.oblici = oblici;
	}
	public void dodajOblik(Oblik o) {
		oblici.add(o);
	}
}
