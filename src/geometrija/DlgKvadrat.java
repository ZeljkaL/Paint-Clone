package geometrija;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DlgKvadrat extends JDialog {
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtStranica;
	public int strana;
	public Color bojaIvice=Color.BLACK;
	public Color bojaUnutrasnjosti=Color.WHITE;
	public boolean bojen=false;
	public boolean bojen2=false;

	public int getStrana() {
		return strana;
	}

	public void setStrana(int strana) {
		this.strana = strana;
	}

	public DlgKvadrat(int x,int y,boolean i,int stranica)
	{
		setSize(491,259);
		setTitle("Dijalog kvadrat");
		setModal(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblKoordinateTackeGore = new JLabel("Koordinate po\u010Detne ta\u010Dke");

		JPanel pnlKoordinate = new JPanel();

		JLabel lblPomocni = new JLabel("");

		JPanel pnlDuzina = new JPanel();

		JPanel pnlBoja1 = new JPanel();

		JPanel pnlBoja2 = new JPanel();

		JPanel pnlKraj = new JPanel();
		
				JLabel lblStranica = new JLabel("Du\u017Eina stranice kvadrata:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPomocni)
							.addGap(123))
						.addComponent(lblKoordinateTackeGore, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlDuzina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(pnlKoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(292))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStranica, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addGap(412))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnlBoja2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlBoja1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(349, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblKoordinateTackeGore))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pnlKoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlDuzina, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblStranica, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlBoja1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlBoja2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(lblPomocni)
					.addGap(64))
		);

		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.setBackground(Color.GREEN);
				pnlKraj.add(btnPotvrdi);
				btnPotvrdi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						boolean kec=false;
						try
						{
							strana =Integer.parseInt(txtStranica.getText());
						}
						catch(Exception e)
						{
							JOptionPane.showMessageDialog(null, "Potreban je unos cijelog broja. ");
							kec=true;				}

						if(strana>0)
						{
							setVisible(false);
						}
						else if(kec==false)
						{
							JOptionPane.showMessageDialog(null, "Potreban je unos pozitivnog broja. ");
						}

						//	System.out.println(strana);
					}
				});
		pnlKraj.add(btnOtkazi);
		JPanel pnlPokazujeBoju2 = new JPanel();
		JButton btnBojaUnutranjosti = new JButton("Boja unutra\u0161njosti");
		btnBojaUnutranjosti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bojaUnutrasnjosti=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju2.setBackground(bojaUnutrasnjosti);
				bojen2=true;
			}
		});
		pnlBoja2.add(btnBojaUnutranjosti);


		//pnlPokazujeBoju2.setBackground(Color.GREEN);
		pnlBoja2.add(pnlPokazujeBoju2);
		JPanel pnlPokazujeBoju = new JPanel();
		JButton btnBojaIvice = new JButton("Boja ivice");
		btnBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				bojaIvice=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju.setBackground(bojaIvice);
				bojen=true;
			}
		});
		pnlBoja1.add(btnBojaIvice);


		//pnlPokazujeBoju.setBackground(Color.RED);
		pnlBoja1.add(pnlPokazujeBoju);

		txtStranica = new JTextField();
		txtStranica.setText("50");
		pnlDuzina.add(txtStranica);
		txtStranica.setColumns(10);

		JLabel lblX = new JLabel("X:");
		pnlKoordinate.add(lblX);

		txtX = new JTextField();
		pnlKoordinate.add(txtX);
		txtX.setColumns(10);
		
				JLabel lblY = new JLabel("    Y:");
				pnlKoordinate.add(lblY);

		txtY = new JTextField();
		pnlKoordinate.add(txtY);
		txtY.setColumns(10);
		txtX.setText(Integer.toString(x));
		txtY.setText(Integer.toString(y));
		getContentPane().setLayout(groupLayout);
		txtStranica.requestFocus();

		if(i==true)
		{
			txtStranica.setText(Integer.toString(stranica));
		}


		setLocationRelativeTo(null);
		setVisible(true);
	}


}
