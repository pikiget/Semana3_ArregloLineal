package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ArregloEdades;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnReportar;
	private JButton btnListar;
	private JButton btnGenerar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("N° en la pocision: ");
		lblNewLabel.setBounds(10, 11, 102, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(106, 8, 238, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(458, 7, 89, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(354, 7, 89, 23);
		contentPane.add(btnListar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(561, 7, 89, 23);
		contentPane.add(btnGenerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 634, 437);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
		ArregloEdades a = new ArregloEdades();
		int position = Integer.parseInt(textField.getText());
		
		textArea.setText("");
		imprimir("Tamaño                   : " + a.getTamaño());
		imprimir("Obtener número           : " + a.getObtener(position));
		imprimir("Promedio edades          : " + a.gerPromedio());
		imprimir("Edad Mayor               : " + a.edadMayor());
		imprimir("Edad menor               : " + a.edadMenor());
		imprimir("Mayores de edad          : " + a.cantidadMayoresEdad());
		imprimir("Menores de edad          : " + a.cantidadMenoresEdad());
		imprimir("Pimera edad entre 12 y 20: " + a.posPrimeraEdadAdolescente());
		imprimir("Ultima edad entre 12 y 20: " + a.posUltimaEdadAdolescente());
		
		
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		ArregloEdades ae = new ArregloEdades();
		textArea.setText("");
		for(int i=0; i<ae.getTamaño(); i++) {
			imprimir(ae.getObtener(i) + "");;
		}
	}


	protected void actionPerformedBtnGenerar(ActionEvent e) {
		ArregloEdades ae = new ArregloEdades();
		textArea.setText("");
		ae.generarEdades();
		imprimir("Edades generadas de forma aleatoria!!!");
		
		for(int i=0; i<ae.getTamaño(); i++) {
			imprimir(ae.getObtener(i) + "");
		}
	}
	
	public void imprimir (String s) {
		textArea.append(s +"\n");
	}
}
