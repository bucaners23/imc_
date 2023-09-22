package IMC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class imc {

	private JFrame frmCalculadoraDeImc;
	private JTextField txtPes;
	private JTextField txtAlt;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnCal;
	private JButton btnNewButton;
	private JLabel lbIMc;
	private JLabel lblSta;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imc window = new imc();
					window.frmCalculadoraDeImc.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public imc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraDeImc = new JFrame();
		frmCalculadoraDeImc.setIconImage(Toolkit.getDefaultToolkit().getImage(imc.class.getResource("/IMC/IMC.png")));
		frmCalculadoraDeImc.setTitle("CALCULADORA DE IMC");
		frmCalculadoraDeImc.setBounds(100, 100, 689, 385);
		frmCalculadoraDeImc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraDeImc.getContentPane().setLayout(null);
		frmCalculadoraDeImc.setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("Peso (Kg)");
		lblNewLabel.setBounds(34, 33, 73, 14);
		frmCalculadoraDeImc.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Altura (m)");
		lblNewLabel_1.setBounds(34, 68, 73, 14);
		frmCalculadoraDeImc.getContentPane().add(lblNewLabel_1);
		
		txtPes = new JTextField();
		txtPes.setBounds(154, 30, 86, 20);
		frmCalculadoraDeImc.getContentPane().add(txtPes);
		txtPes.setColumns(10);
		
		txtAlt = new JTextField();
		txtAlt.setColumns(10);
		txtAlt.setBounds(154, 65, 86, 20);
		frmCalculadoraDeImc.getContentPane().add(txtAlt);
		
		btnCal = new JButton("Calcular IMC");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double peso=Double.parseDouble(txtPes.getText());
				double alt=Double.parseDouble(txtAlt.getText());
				double imc=peso/(alt*alt);
				DecimalFormat formateador = new DecimalFormat("####.###");
				lbIMc.setText("El IMC es de : "+formateador.format(imc));
				//STATUS
				if(imc<18.5) {
					lblSta.setText("Bajo Peso");
					lblSta.setBackground(new Color(0,159,227));
					lbIMc.setBackground(new Color(0,159,227));
				}else if(imc<24.9) {
					lblSta.setBackground(new Color(147,192,31));
					lbIMc.setBackground(new Color(147,192,31));
					lblSta.setText("Normal");
					
				}else if(imc<29.9) {
					lblSta.setText("SobrePeso");
					lblSta.setBackground(new Color(249,194,49));
					lbIMc.setBackground(new Color(249,194,49));
				}else if(imc<34.9) {
					lblSta.setText("Obesidad 1");
					lblSta.setBackground(new Color(262,154,18));
					lbIMc.setBackground(new Color(262,154,18));

				}else if(imc<39.9) {
					lblSta.setText("Obesidad 2");
					lblSta.setBackground(new Color(223,93,16));
					lbIMc.setBackground(new Color(223,93,16));

				}else {
					lblSta.setText("Obesidad 3");
					lblSta.setBackground(new Color(224,9,17));
					lbIMc.setBackground(new Color(224,9,17));

				}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"E R R O R","Calculadora IMC",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnCal.setBounds(34, 137, 119, 23);
		frmCalculadoraDeImc.getContentPane().add(btnCal);
		
		btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPes.setText("");
				txtAlt.setText("");
				lbIMc.setText("");
				lblSta.setText("");
				//lblSta.setBackground(new Color(0,0,0));
				//lblIMc.setBackground(new Color(0,0,0));
				
			}
		});
		btnNewButton.setBounds(163, 137, 89, 23);
		frmCalculadoraDeImc.getContentPane().add(btnNewButton);
		
		lbIMc = new JLabel("I M C");
		lbIMc.setOpaque(true);
		lbIMc.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lbIMc.setBounds(34, 215, 188, 14);
		frmCalculadoraDeImc.getContentPane().add(lbIMc);
		
		lblSta = new JLabel("Status");
		lblSta.setOpaque(true);
		lblSta.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblSta.setBounds(34, 255, 188, 14);
		frmCalculadoraDeImc.getContentPane().add(lblSta);
		
		lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setIcon(new ImageIcon(imc.class.getResource("/IMC/ok.png")));
		lblNewLabel_2.setBounds(262, 33, 340, 247);
		frmCalculadoraDeImc.getContentPane().add(lblNewLabel_2);
	}
}
