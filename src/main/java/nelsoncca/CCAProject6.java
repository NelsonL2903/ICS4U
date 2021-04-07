package nelsoncca;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CCAProject6 extends JPanel implements MouseListener, ActionListener {

	static CCAProject6 cca6 = new CCAProject6();
	static CCAProject5 cca5 = new CCAProject5();
	
	public static void main(String[] args) {

		cca6.gui();

	}

	public void gui() {

		// initializes the JFrame
		JFrame frame = new JFrame("Aim Trainer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(cca6);
		frame.setSize(1000, 550);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.addMouseListener(cca6);

		// Creates a title on the JFrame
		JLabel title = new JLabel("Nelson's Aim Trainer!", SwingConstants.CENTER);
		title.setPreferredSize(new Dimension(300, 100));
		title.setFont(new Font("ComicSans", Font.BOLD, 25));
		frame.getContentPane().add(title, BorderLayout.NORTH);

		// creates a JButton which starts the game
		JButton pa = new JButton("Start");
		frame.getContentPane().add(pa, BorderLayout.SOUTH);
		pa.addActionListener(cca6);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		cca5.starter();		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
