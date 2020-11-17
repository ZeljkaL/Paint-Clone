package geometrija;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgPravougaonik extends JDialog{

	public JTextField txtSirina;
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtDuzina;
	public int duzina;
	public int sirina;
	public Color bojaIviceP=Color.BLACK;
	public Color bojaUnutrasnjostiP=Color.WHITE;
	public boolean bojen=false;
	public boolean bojen2=false;
	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}



	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}

	public DlgPravougaonik(int x,int y, boolean i, int sirina1,int duzina1)
	{
		setSize(400,300);
		setTitle("Dijalog pravougaonik");
		setModal(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblKoordinateTakeGore = new JLabel("Koordinate ta\u010Dke gore lijevo:");

		JPanel panel = new JPanel();

		JLabel lblPomocni = new JLabel("");

		JPanel pnlDuzina = new JPanel();

		JPanel pnlBoja1 = new JPanel();

		JPanel pnlBoja2 = new JPanel();

		JPanel pnlKraj = new JPanel();

		JPanel pnlSirina = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKoordinateTakeGore)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPomocni)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlBoja2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlBoja1, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlDuzina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblKoordinateTakeGore)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPomocni)
						.addComponent(pnlDuzina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlSirina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlBoja2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlBoja1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);

		JLabel lblSirina = new JLabel("\u0160irina pravougaonika:");
		pnlSirina.add(lblSirina);

		txtSirina = new JTextField();
		txtSirina.setText("100");
		pnlSirina.add(txtSirina);
		txtSirina.setColumns(10);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.GREEN);
		btnPotvrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				boolean kec=false;
				try
				{
					duzina =Integer.parseInt(txtDuzina.getText());
					sirina =Integer.parseInt(txtSirina.getText());

				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Potreban je unos cijelog broja. ");
					kec=true;				}

				if(duzina>0 && sirina>0)
				{
					setVisible(false);
				}
				else if(kec==false)
				{
					JOptionPane.showMessageDialog(null, "Potreban je unos pozitivnog broja. ");
				}


				//setVisible(false);

			}

		});
		pnlKraj.add(btnPotvrdi);

		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
			}
		});
		pnlKraj.add(btnOtkazi);
		JPanel pnlPokazujeBoju2 = new JPanel();
		JButton btnBojaUnutranjosti = new JButton("Boja unutra\u0161njosti");
		btnBojaUnutranjosti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bojaUnutrasnjostiP=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju2.setBackground(bojaUnutrasnjostiP);
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

				bojaIviceP=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju.setBackground(bojaIviceP);
				bojen=true;
			}
		});
		pnlBoja1.add(btnBojaIvice);


		//pnlPokazujeBoju.setBackground(Color.RED);
		pnlBoja1.add(pnlPokazujeBoju);

		JLabel lblDuzina = new JLabel("Du\u017Eina pravougaonika:");
		pnlDuzina.add(lblDuzina);

		txtDuzina = new JTextField();
		txtDuzina.setText("50");
		pnlDuzina.add(txtDuzina);
		txtDuzina.setColumns(10);

		JLabel lblX = new JLabel("X:");
		panel.add(lblX);

		txtX = new JTextField();
		panel.add(txtX);
		txtX.setColumns(10);

		JLabel lblY = new JLabel("    Y:");
		panel.add(lblY);

		txtY = new JTextField();
		panel.add(txtY);
		txtY.setColumns(10);
		txtX.setText(Integer.toString(x));
		txtY.setText(Integer.toString(y));
		if(i==true)
		{
			txtDuzina.setText(Integer.toString(sirina1));
			txtSirina.setText(Integer.toString(duzina1));
		}
		getContentPane().setLayout(groupLayout);
		txtDuzina.requestFocus();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
