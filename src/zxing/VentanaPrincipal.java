package zxing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.zxing.WriterException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfFrase;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton bCrear = new JButton("Crear QR");
		
		bCrear.setBounds(103, 56, 89, 23);
		contentPane.add(bCrear);
		
		tfFrase = new JTextField();
		tfFrase.setBounds(31, 25, 239, 20);
		contentPane.add(tfFrase);
		tfFrase.setColumns(10);
		
		JLabel lImagen = new JLabel("");
		lImagen.setBounds(125, 91, 350, 350);
		contentPane.add(lImagen);
		
		bCrear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				QRCodeGenerator qr = new QRCodeGenerator(tfFrase.getText());
				ImageIcon image = null;
				try {
					image = new ImageIcon(qr.QRToByte());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lImagen.setIcon(image);
			}
		});
	}
}
