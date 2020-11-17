package geometrija;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.awt.Font;

public class Aplikacija extends JFrame{

	public Crtez crtez= new Crtez();
	public  int meni=5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public boolean uLiniji=false;
	public Tacka pomocna2=new Tacka();
	public int indexSelektovanog=9999;
	private 	boolean postojiSelektovan=false;
	public   Color bojaLinijee= Color.BLACK;


	public Aplikacija() {
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Lazarević Željka MH36/2015");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel pnlLijevo = new JPanel();
		getContentPane().add(pnlLijevo, BorderLayout.WEST);
		
         //dugme za tacku
		JToggleButton tglbtnTacka = new JToggleButton("Ta\u010Dka");
		tglbtnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meni=0;
			//	System.out.println(meni);
			}
		});
		buttonGroup.add(tglbtnTacka);
		  //dugme za liniju
		JToggleButton tglbtnLinija = new JToggleButton("Linija");
		tglbtnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meni=1;
				System.out.println(meni);
			}
		});
		buttonGroup.add(tglbtnLinija);
		
		  //dugme za kvadrat

		JToggleButton tglbtnKvadrat = new JToggleButton("Kvadrat");
		tglbtnKvadrat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meni=2;
				System.out.println(meni);
			}
		});
		buttonGroup.add(tglbtnKvadrat);
		  //dugme za pravougaonik
		JToggleButton tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		tglbtnPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meni=3;
				System.out.println(meni);
			}
		});
		buttonGroup.add(tglbtnPravougaonik);
		  //dugme za krug
		JToggleButton tglbtnKrug = new JToggleButton("Krug");
		tglbtnKrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				meni=4;
				System.out.println(meni);
			}
		});
		buttonGroup.add(tglbtnKrug);
		
		//brisanje

		JButton btnBrisanje = new JButton("Brisanje");
		btnBrisanje.setBackground(Color.RED);
		btnBrisanje.setForeground(Color.DARK_GRAY);
		btnBrisanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=9999;
				for(int a=0;a<crtez.oblici.size();a++)
				{
					Oblik o = crtez.oblici.get(a);
					if(o.isSelektovan()==true)
					{

						index=a;
					}
				}
				if(index!=9999)
				{

					Object[] izbor = {"Da",
							"Ne","Otkaži"};
					int brisanje = JOptionPane.showOptionDialog(null,
							"Da li želite da obrišete selektovani element?",
							"Potvrda brisanja.",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null,     //do not use a custom Icon
							izbor,  //the titles of buttons
							izbor[0]); //
					if(brisanje==0)
					{
						crtez.oblici.remove(index);
					}					
				}

			}
		});
        //modifikacija
		JButton btnModifikacija = new JButton("Modifikacija");
		btnModifikacija.setBackground(Color.GREEN);
		btnModifikacija.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifikacija.setForeground(Color.DARK_GRAY);
		btnModifikacija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Iterator<Oblik> it4 = crtez.oblici.iterator();


				for(int a=0;a<crtez.oblici.size();a++)
				{
					Oblik o = crtez.oblici.get(a);
					if(o.isSelektovan()==true)
					{
						postojiSelektovan=true;
						//		System.out.println("a");
						indexSelektovanog=a;
						System.out.println(indexSelektovanog);
					}
				}
				if(postojiSelektovan==true)
				{
					while(it4.hasNext())
					{
						Oblik o = it4.next();
						if(o.isSelektovan()==true)
						{

							if(o instanceof Pravougaonik) {
								Pravougaonik p=(Pravougaonik)o;
								DlgPravougaonik dijalog= new DlgPravougaonik(p.getGoreLevo().getX(),p.getGoreLevo().getY(),true, p.getSirina(),p.getStranica());
								p.pomeriNa(Integer.parseInt(dijalog.txtX.getText()), Integer.parseInt(dijalog.txtY.getText()));
								p.setSirina(Integer.parseInt(dijalog.txtDuzina.getText()));
								p.setStranica(Integer.parseInt(dijalog.txtSirina.getText()));
								if(dijalog.bojen2==true)
									p.setBojaUP(dijalog.bojaUnutrasnjostiP);
								if(dijalog.bojen==true)
									p.setBojaIvicePr(dijalog.bojaIviceP);


							}
							else if(o instanceof Tacka) {
								Tacka t=(Tacka)o;
								DlgTacka dijalog = new DlgTacka(t.getX(),t.getY(),true);
								t.pomeriNa(Integer.parseInt(dijalog.txtX.getText()), Integer.parseInt(dijalog.txtY.getText()));
								if(dijalog.bojen==true)
									t.setBojaTacke(dijalog.bojaTacke);
							}
							else if(o instanceof Linija) {
								Linija l=(Linija)o;
								DlgLinija dijalog= new DlgLinija(l.gettPocetna().getX(),l.gettPocetna().getY(), l.gettKrajnja().getX(),l.gettKrajnja().getY(),true); 
								l.gettPocetna().pomeriNa(Integer.parseInt(dijalog.txtX1.getText()), Integer.parseInt(dijalog.txtY1.getText()));
								l.gettKrajnja().pomeriNa(Integer.parseInt(dijalog.txtX2.getText()), Integer.parseInt(dijalog.txtY2.getText()));
								if(dijalog.bojen==true)
								{
									l.setBojaIviceL(dijalog.bojaLinije);
								}
							}
							else if(o instanceof Kvadrat) {
								Kvadrat k=(Kvadrat)o;
								DlgKvadrat dijalog = new DlgKvadrat(k.getGoreLevo().getX(),k.getGoreLevo().getY(),true,k.getStranica());//macamala



								k.pomeriNa(Integer.parseInt(dijalog.txtX.getText()), Integer.parseInt(dijalog.txtY.getText()));
								k.setStranica(Integer.parseInt(dijalog.txtStranica.getText()));
								if(dijalog.bojen2==true)
									k.setBojaUnutrasnjost(dijalog.bojaUnutrasnjosti);
								if(dijalog.bojen==true)
									k.setBojaIvice(dijalog.bojaIvice);
								//apk.crtez.oblici.add(k);
								System.out.println("jooj");


							}
							else if(o instanceof Krug) {
								Krug kr=(Krug)o;
								DlgKrug dijalog= new DlgKrug(kr.getCentar().getX(), kr.getCentar().getY(),true,kr.getR());
								kr.setR(Integer.parseInt(dijalog.txtStranica.getText()));
								kr.pomeriNa(Integer.parseInt(dijalog.txtX.getText()), Integer.parseInt(dijalog.txtY.getText()));
								if(dijalog.bojen2==true)
									kr.setBojaUnutrasnjost(dijalog.bojaUKrugu);
								if(dijalog.bojen==true)
									kr.setBojaIvice(dijalog.bojaIvice);

							}

						}
					}
				}
			}
		});
        //selekcija
		JToggleButton tglbtnSelekcija = new JToggleButton("Selekcija");
		tglbtnSelekcija.setBackground(Color.BLUE);
		tglbtnSelekcija.setForeground(Color.DARK_GRAY);
		tglbtnSelekcija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//zeljka
				meni=5;
			}
		});
		buttonGroup.add(tglbtnSelekcija);
		GroupLayout gl_pnlLijevo = new GroupLayout(pnlLijevo);
		gl_pnlLijevo.setHorizontalGroup(
			gl_pnlLijevo.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlLijevo.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_pnlLijevo.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnModifikacija, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnBrisanje, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnSelekcija, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnTacka, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnLinija, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnKvadrat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnPravougaonik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(tglbtnKrug, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlLijevo.setVerticalGroup(
			gl_pnlLijevo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLijevo.createSequentialGroup()
					.addGap(23)
					.addComponent(tglbtnTacka)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnLinija)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnKvadrat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnPravougaonik)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnKrug)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tglbtnSelekcija)
					.addGap(40)
					.addComponent(btnBrisanje)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnModifikacija)
					.addContainerGap(468, Short.MAX_VALUE))
		);
		gl_pnlLijevo.linkSize(SwingConstants.HORIZONTAL, new Component[] {tglbtnTacka, tglbtnLinija, tglbtnKvadrat, tglbtnPravougaonik, tglbtnKrug});
		pnlLijevo.setLayout(gl_pnlLijevo);

		JPanel pnlDesno = new JPanel();
		getContentPane().add(pnlDesno, BorderLayout.EAST);

		JPanel pnlDolje = new JPanel();
		getContentPane().add(pnlDolje, BorderLayout.SOUTH);

		JPanel pnlCentar = new JPanel();
		getContentPane().add(pnlCentar, BorderLayout.CENTER);
		setVisible(true);



		getContentPane().add(crtez, BorderLayout.CENTER);
	}

	public static void main(String[] args) {

		Aplikacija apk= new Aplikacija();
		System.out.println("*Napomena: Da bi se objekat modifikovao, ili obrisao, najprije ga je potrebno selektovati!");


		//Polje crtez= new Polje();
		//apk.getContentPane().add(crtez, BorderLayout.CENTER);
		apk.crtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int eX=e.getX();
				int eY=e.getY();
				//DlgLinija dijalogL = new DlgLinija();
				Tacka pomocna=new Tacka();
				Tacka pomocna2=new Tacka();
				if(apk.uLiniji==true)
				{
					//pomocna= new Tacka();
					pomocna.setX(eX);
					pomocna.setY(eY);
					apk.uLiniji=false;	
					Linija l= new Linija(apk.pomocna2,pomocna);

					//DlgLinija dijalogL = new DlgLinija(0,0,0,0,false);
					l.setBojaIviceL(apk.bojaLinijee);
					apk.crtez.oblici.add(l);
					System.out.println("2");
					apk.pomocna2=new Tacka();

				}
				else if(apk.uLiniji==false)
				{
					switch(apk.meni)
					{
					case 0:
					{
						//DlgTacka dijalog = new DlgTacka(0,0,false);
						Tacka t= new Tacka(eX, eY);
						t.setBojaTacke(Color.black);

						apk.crtez.oblici.add(t);
						//System.out.println("1");
						break;
					}
					case 1:
					{



						apk.pomocna2.setX(eX);
						apk.pomocna2.setY(eY);
						apk.uLiniji=true;
					//	System.out.println("1");
					//	DlgLinija dijalogL = new DlgLinija(0,0,0,0,false);
						apk.bojaLinijee=(Color.black);
						break;
					}
					case 2:
					{
						//DlgKvadrat dijalog = new DlgKvadrat(eX,eY,false,0);

						Tacka kv = new Tacka(eX,eY);
						Kvadrat k= new Kvadrat(kv,50);
						k.setBojaUnutrasnjost(Color.white);;
						k.setBojaIvice(Color.black);;
						apk.crtez.oblici.add(k);
				//		System.out.println(dijalog.bojaIvice);

						break;
					}
					case 3:
					{
						//DlgPravougaonik dijalog= new DlgPravougaonik(eX, eY, false,0,0);
						Tacka pr= new Tacka(eX, eY);
						Pravougaonik p= new Pravougaonik(pr, 50, 100);
						p.setBojaUP(Color.white);;
						p.setBojaIvicePr(Color.black);;
						apk.crtez.oblici.add(p);
						//System.out.println(dijalog.sirina);

						break;
					}
					case 4:
					{
						//DlgKrug dijalog= new DlgKrug(eX, eY,false,0);
						Tacka centar= new Tacka(eX, eY);
						Krug kr=new Krug(centar, 50);
						kr.setBojaUnutrasnjost(Color.white);;
						kr.setBojaIvice(Color.black);;
						apk.crtez.oblici.add(kr);
						//System.out.println(dijalog.poluprecnik);
						break;

					}
					case 5:
					{


						Iterator<Oblik> it = apk.crtez.oblici.iterator();

						for(int a=0;a<apk.crtez.oblici.size();a++)
						{
							Oblik o = apk.crtez.oblici.get(a);
							if(o.isSelektovan()==true)
							{
								apk.postojiSelektovan=true;
								//		System.out.println("a");
								apk.indexSelektovanog=a;
								System.out.println(apk.indexSelektovanog);
							}
						}
						if(apk.postojiSelektovan==false)
						{
							while(it.hasNext())
							{
								Oblik o = it.next();
								if(o instanceof Tacka)
								{
									Tacka pomocna3=(Tacka)o;
									int Xmin=pomocna3.getX()-3;
									int Xmax=pomocna3.getX()+3;
									int Ymin=pomocna3.getY()-3;
									int Ymax=pomocna3.getY()+3;
									if(eX>Xmin && eX<Xmax && eY>Ymin && eY<Ymax)
									{
										pomocna3.setSelektovan(true);
									}
								}
								if(o instanceof Linija)
								{
									Linija l =(Linija)o;
									if(l.sadrzi(eX, eY)==true)
									{
										l.setSelektovan(true);
									}
								}

								if(o instanceof Kvadrat) {
									Kvadrat k=(Kvadrat)o;
									if(k.sadrzi(eX,eY)==true) {
										k.setSelektovan(true);
									}
								}
								if(o instanceof Krug) {
									Krug kr=(Krug)o;
									if(kr.sadrzi(eX, eY)==true) {
										kr.setSelektovan(true);
									}
								}
								if(o instanceof Pravougaonik) {
									Pravougaonik p=(Pravougaonik)o;
									if(p.sadrzi(eX, eY)==true) {
										p.setSelektovan(true);
									}
								}
							}
						}
						if(apk.postojiSelektovan==true)
						{
							for(int a=0;a<apk.crtez.oblici.size();a++)
							{
								Oblik o = apk.crtez.oblici.get(a);
								o.setSelektovan(false);
							}
							apk.postojiSelektovan=false;
							apk.indexSelektovanog=9999;
						}
						break;
					}

					}
				}






			}
		});	

	}
}
