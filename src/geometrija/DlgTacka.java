package geometrija;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class DlgTacka extends JDialog {
	public Color bojaTacke=Color.BLACK;
	public JTextField txtX;
	public JTextField txtY;
	public boolean bojen=false;




	public DlgTacka(int x, int y, boolean i)
	{
		setSize(338,182);
		setTitle("Dijalog tačka");
		setModal(true);

		JLabel lblIzaberiteBojuTake = new JLabel("Izaberite boju ta\u010Dke:");

		JPanel pnlPomocni = new JPanel();

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.GREEN);
		btnPotvrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JLabel lblUnesiteKoordinateTake = new JLabel("Unesite koordinate tačke:");

		JPanel pnlKT = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUnesiteKoordinateTake)
					.addContainerGap(251, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlKT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(157, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlPomocni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(lblIzaberiteBojuTake)
									.addPreferredGap(ComponentPlacement.RELATED, 8, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
							.addComponent(btnPotvrdi)
							.addGap(42))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUnesiteKoordinateTake)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlKT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIzaberiteBojuTake)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlPomocni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnPotvrdi))
					.addContainerGap(91, Short.MAX_VALUE))
		);

		JLabel lblX = new JLabel("X:");
		pnlKT.add(lblX);

		txtX = new JTextField();
		pnlKT.add(txtX);
		txtX.setColumns(10);

		JLabel lblY = new JLabel("Y:");
		pnlKT.add(lblY);

		txtY = new JTextField();
		pnlKT.add(txtY);
		txtY.setColumns(10);
		JPanel pnlPokazujeBoju = new JPanel();
		JButton btnBojaTake = new JButton("Boja ta\u010Dke");
		btnBojaTake.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bojaTacke=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.BLACK);
				pnlPokazujeBoju.setBackground(bojaTacke);
				bojen=true;
			}
		});
		pnlPomocni.add(btnBojaTake);


		pnlPomocni.add(pnlPokazujeBoju);
		getContentPane().setLayout(groupLayout);


		if(i==true) {
			txtX.setText(Integer.toString(x));
			txtY.setText(Integer.toString(y));
		}

		if(i==false) {
			lblUnesiteKoordinateTake.setVisible(false);
			lblX.setVisible(false);
			lblY.setVisible(false);
			txtX.setVisible(false);
			txtY.setVisible(false);
			setSize(250,200);
		}
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
