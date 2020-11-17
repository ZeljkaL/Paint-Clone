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

public class DlgLinija extends JDialog {
	public Color bojaLinije=Color.BLACK;
	public JTextField txtX1;
	public JTextField txtY1;
	public JTextField txtX2;
	public JTextField txtY2;
	public boolean bojen=false;


	public DlgLinija(int x1, int y1, int x2, int y2, boolean i)
	{
		setSize(367,255);
		setTitle("Dijalog linija");
		setModal(true);

		JLabel lblIzaberiteBojuTake = new JLabel("Izaberite boju linije:");

		JPanel pnlPomocni = new JPanel();

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(Color.GREEN);
		btnPotvrdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

		JLabel lblIzaberiteKoordinatePoetne = new JLabel("Izaberite koordinate po\u010Detne ta\u010Dke:");

		JPanel pnl1 = new JPanel();

		JLabel lblIzaberiteKoordinateKrajnje = new JLabel("Izaberite koordinate krajnje ta\u010Dke:");

		JPanel pnl2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIzaberiteKoordinatePoetne)
								.addComponent(pnl1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIzaberiteKoordinateKrajnje)
								.addComponent(pnl2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIzaberiteBojuTake))
							.addContainerGap(157, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlPomocni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
							.addComponent(btnPotvrdi)
							.addGap(45))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIzaberiteKoordinatePoetne)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnl1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIzaberiteKoordinateKrajnje)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnl2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIzaberiteBojuTake)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPotvrdi)
						.addComponent(pnlPomocni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
		);

		JLabel lblX2 = new JLabel("X:");
		pnl2.add(lblX2);

		txtX2 = new JTextField();
		pnl2.add(txtX2);
		txtX2.setColumns(10);

		JLabel lblY2 = new JLabel("Y:");
		pnl2.add(lblY2);

		txtY2 = new JTextField();
		pnl2.add(txtY2);
		txtY2.setColumns(10);

		JLabel lblX1 = new JLabel("X:");
		pnl1.add(lblX1);

		txtX1 = new JTextField();
		pnl1.add(txtX1);
		txtX1.setColumns(10);

		JLabel lblY1 = new JLabel("Y:");
		pnl1.add(lblY1);

		txtY1 = new JTextField();
		pnl1.add(txtY1);
		txtY1.setColumns(10);
		JPanel pnlPokazujeBoju = new JPanel();
		JButton btnBojaLinije = new JButton("Boja linije");
		btnBojaLinije.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bojaLinije=JColorChooser.showDialog(rootPane, "Izaberite boju: ", Color.BLACK);
				pnlPokazujeBoju.setBackground(bojaLinije);
				bojen=true;
			}
		});
		pnlPomocni.add(btnBojaLinije);


		pnlPomocni.add(pnlPokazujeBoju);
		if(i==true) {
			txtX1.setText(Integer.toString(x1));
			txtY1.setText(Integer.toString(y1));
			txtX2.setText(Integer.toString(x2));
			txtY2.setText(Integer.toString(y2));

		}
		if(i==false) {
			txtX1.setVisible(false);
			txtY1.setVisible(false);
			txtX2.setVisible(false);
			txtY2.setVisible(false);
			lblX1.setVisible(false);
			lblX2.setVisible(false);
			lblY1.setVisible(false);
			lblY2.setVisible(false);
			lblIzaberiteKoordinateKrajnje.setVisible(false);
			lblIzaberiteKoordinatePoetne.setVisible(false);

		}
		getContentPane().setLayout(groupLayout);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
