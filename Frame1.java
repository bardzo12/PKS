import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Button;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class Frame1 {

	private JFrame frmPostanalyzer;
	public static String meno_suboru;
	public static String output;
	private static Zadanie1 zacni;
	public static int podprogram;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frmPostanalyzer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Button button_2 = new Button("Analyzuj");
		button_2.setVisible(false);
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		TextField textField = new TextField();
		frmPostanalyzer = new JFrame();
		frmPostanalyzer.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmPostanalyzer.setTitle("PostAnalyzer");
		frmPostanalyzer.setBounds(100, 100, 792, 802);
		frmPostanalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPostanalyzer.getContentPane().setLayout(null);
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("TELNET");
		rdbtnNewRadioButton_8.setVisible(false);
		rdbtnNewRadioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=3;
			}
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("FTP riadiace");
		rdbtnNewRadioButton_1.setVisible(false);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=5;
			}
		});
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("SSH komunik\u00E1cia");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=4;
			}
		});
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("HTTPS komunik\u00E1cia");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=2;
			}
		});
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("FTP d\u00E1tov\u00E9");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=6;
			}
		});
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("TFTP");
		rdbtnNewRadioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=9;
			}
		});
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("ICMP");
		rdbtnNewRadioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=7;
			}
		});
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("ARP");
		rdbtnNewRadioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=8;
			}
		});
		JRadioButton rdbtnNewRadioButton = new JRadioButton("HTTP komunik\u00E1cia");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				podprogram=1;
			}
		});
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_4);
		group.add(rdbtnNewRadioButton_5);
		group.add(rdbtnNewRadioButton_6);
		group.add(rdbtnNewRadioButton_7);
		group.add(rdbtnNewRadioButton_8);
		
		Label label = new Label("Zadaj meno s\u00FAboru na anal\u00FDzu:");
		label.setBounds(10, 11, 213, 24);
		frmPostanalyzer.getContentPane().add(label);
		
		Button button = new Button("Vypis v\u0161etk\u00FDch komunik\u00E1ci\u00ED");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				button_2.setVisible(false);
				rdbtnNewRadioButton.setVisible(false);
				rdbtnNewRadioButton_1.setVisible(false);
				rdbtnNewRadioButton_2.setVisible(false);
				rdbtnNewRadioButton_3.setVisible(false);
				rdbtnNewRadioButton_4.setVisible(false);
				rdbtnNewRadioButton_5.setVisible(false);
				rdbtnNewRadioButton_6.setVisible(false);
				rdbtnNewRadioButton_7.setVisible(false);
				rdbtnNewRadioButton_8.setVisible(false);
				zacni.program1();
				textArea.setText(Zadanie1.getStream().toString());
			}
		});
		button.setBounds(10, 134, 200, 35);
		frmPostanalyzer.getContentPane().add(button);
		
		textField.setText(".pcap");
		textField.setBounds(229, 11, 217, 24);
		frmPostanalyzer.getContentPane().add(textField);
		
		Label label_1 = new Label("Anal\u00FDza s\u00FAboru:");
		label_1.setBounds(10, 40, 159, 24);
		frmPostanalyzer.getContentPane().add(label_1);
		
		
		textArea.addTextListener(new TextListener() {
			public void textValueChanged(TextEvent arg0) {
			}
		});
		textArea.setIgnoreRepaint(true);
		textArea.setBounds(10, 169, 600, 576);
		frmPostanalyzer.getContentPane().add(textArea);
		
		Button button_1 = new Button("Anal\u00FDza komunik\u00E1cie");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				rdbtnNewRadioButton.setVisible(true);
				rdbtnNewRadioButton_1.setVisible(true);
				rdbtnNewRadioButton_2.setVisible(true);
				rdbtnNewRadioButton_3.setVisible(true);
				rdbtnNewRadioButton_4.setVisible(true);
				rdbtnNewRadioButton_5.setVisible(true);
				rdbtnNewRadioButton_6.setVisible(true);
				rdbtnNewRadioButton_7.setVisible(true);
				rdbtnNewRadioButton_8.setVisible(true);
				button_2.setVisible(true);
			}
		});
		button_1.setBounds(205, 134, 200, 35);
		frmPostanalyzer.getContentPane().add(button_1);
		rdbtnNewRadioButton_1.setBounds(623, 282, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2.setVisible(false);
		rdbtnNewRadioButton_2.setBounds(623, 252, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3.setVisible(false);
		rdbtnNewRadioButton_3.setBounds(623, 195, 143, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_4.setVisible(false);
		rdbtnNewRadioButton_4.setBounds(623, 312, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_4);
		
		rdbtnNewRadioButton_5.setVisible(false);
		rdbtnNewRadioButton_5.setBounds(623, 342, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_5);
		
		rdbtnNewRadioButton_6.setVisible(false);
		rdbtnNewRadioButton_6.setBounds(623, 372, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_6);
		
		rdbtnNewRadioButton_7.setVisible(false);
		rdbtnNewRadioButton_7.setBounds(623, 402, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_7);
		
		rdbtnNewRadioButton_8.setVisible(false);
		rdbtnNewRadioButton_8.setBounds(623, 222, 127, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton_8);
		
		rdbtnNewRadioButton.setVisible(false);
		rdbtnNewRadioButton.setBounds(623, 169, 143, 25);
		frmPostanalyzer.getContentPane().add(rdbtnNewRadioButton);
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					zacni.program2();
				textArea.setText(Zadanie1.getStream().toString());
			}
		});
		button_2.setBounds(613, 433, 153, 35);
		frmPostanalyzer.getContentPane().add(button_2);
		
		Button button_3 = new Button("Otvoriù");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meno_suboru = textField.getText();
				zacni = new Zadanie1();
				zacni.program0();
			}
		});
		button_3.setBounds(470, 11, 159, 24);
		frmPostanalyzer.getContentPane().add(button_3);
		
		System.out.printf(Zadanie1.baos.toString());
	}
}
