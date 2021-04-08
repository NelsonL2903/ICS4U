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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CCAProject6 extends JPanel implements ActionListener {

	static CCAProject6 cca6 = new CCAProject6();
	static CCAProject5 cca5 = new CCAProject5();
	JFrame frame;
	JTextField jtf;
	JButton button;
	JLabel title;

	public static void main(String[] args) {

		cca6.gui();

	}

	public void gui() {

		frame = new JFrame("Maximize");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLocation(550, 300);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(null);
		frame.setVisible(true);
		
		jtf = new JTextField();
		jtf.setBounds(675, 310, 150, 20);
		jtf.addActionListener(cca6);
		frame.add(jtf);
		
		button = new JButton("Start Game");
		button.setBounds(675, 600, 200, 50);
		button.addActionListener(cca6);
		frame.add(button);
		
		title = new JLabel("Nelson's Target Practice");
		title.setBounds(640, 25, 450, 150);
		title.setFont(new Font("ComicSans", Font.BOLD, 25));
		frame.add(title);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
