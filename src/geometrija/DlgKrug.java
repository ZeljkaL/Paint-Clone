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

public class DlgKrug extends JDialog{


	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtStranica;
	public int poluprecnik;
	public Color bojaIvice=Color.BLACK;
	public Color bojaUKrugu=Color.WHITE;
	public boolean bojen=false;
	public boolean bojen2=false;

	public int getStrana() {
		return poluprecnik;
	}

	public void setStrana(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

	public DlgKrug(int x,int y,boolean i,int pp)
	{
		setSize(466,249);
		setTitle("Dijalog krug");
		setModal(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblKoordinateCentra = new JLabel("Koordinate centra:");

		JPanel panel = new JPanel();

		JLabel lblPomocni = new JLabel("");

		JPanel panel_1 = new JPanel();

		JPanel pnlBoja1 = new JPanel();

		JPanel pnlBoja2 = new JPanel();

		JPanel pnlKraj = new JPanel();
		
				JLabel lblPoluprecnik = new JLabel("Du\u017Eina polupre\u010Dnika:");
		
		JPanel panel_2 = new JPanel();
		
				JLabel lblY = new JLabel("    Y:");
				panel_2.add(lblY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPomocni)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblKoordinateCentra)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
							.addGap(125))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPoluprecnik)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlBoja2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlBoja1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblKoordinateCentra, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPoluprecnik, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblPomocni)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pnlBoja1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlBoja2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(16)
					.addComponent(pnlKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
				txtY = new JTextField();
				panel_2.add(txtY);
				txtY.setColumns(10);
				txtY.setText(Integer.toString(y));

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.GREEN);
		btnPotvrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				//setVisible(false);
				boolean kec=false;
				try
				{
					poluprecnik =Integer.parseInt(txtStranica.getText());

				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Potreban je unos cijelog broja. ");
					kec=true;				}

				if(poluprecnik>0)
				{
					setVisible(false);
				}
				else if(kec==false)
				{
					JOptionPane.showMessageDialog(null, "Potreban je unos pozitivnog broja. ");
				}

			}
		});
		pnlKraj.add(btnPotvrdi);

		JButton btnOtkazi = new JButton("Otka\u017Ei");
		btnOtkazi.setBackground(Color.LIGHT_GRAY);
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
			public void mouseClicked(MouseEvent e) {
				bojaUKrugu=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju2.setBackground(bojaUKrugu);
				bojen2=true;
			}
		});
		pnlBoja2.add(btnBojaUnutranjosti);


		//pnlPokazujeBoju2.setBackground(Color.GREEN);
		pnlBoja2.add(pnlPokazujeBoju2);
		JButton btnBojaIvice = new JButton("Boja ivice");
		pnlBoja1.add(btnBojaIvice);
		JPanel pnlPokazujeBoju = new JPanel();
		btnBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				bojaIvice=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.WHITE);
				pnlPokazujeBoju.setBackground(bojaIvice);
				bojen=true;
			}
		});
		


		//pnlPokazujeBoju.setBackground(Color.RED);
		pnlBoja1.add(pnlPokazujeBoju);

		txtStranica = new JTextField();
		txtStranica.setText("50");
		panel_1.add(txtStranica);
		txtStranica.setColumns(10);

		JLabel lblX = new JLabel("X:");
		panel.add(lblX);

		txtX = new JTextField();
		panel.add(txtX);
		txtX.setColumns(10);
		txtX.setText(Integer.toString(x));
		getContentPane().setLayout(groupLayout);
		txtStranica.requestFocus();
		if(i==true)
		{
			txtStranica.setText(Integer.toString(pp));
		}
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
