package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import clases.ArregloSueldos;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
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
		setBounds(100, 100, 605, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(36, 23, 89, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(216, 23, 89, 23);
		contentPane.add(btnReportar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(430, 23, 89, 23);
		contentPane.add(btnGenerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 569, 406);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(e);
		}
		if (e.getSource() == btnReportar) {
			actionPerformedBtnReportar(e);
		}
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		ArregloSueldos as = new ArregloSueldos();
		textArea.setText("");
		for(int i=0; i<as.tamaño(); i++) {
			imprimir(as.obtener(i) + "");
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
		ArregloSueldos as = new ArregloSueldos();
		textArea.setText("");
		imprimir("Cantidad de sueldo: " + as.tamaño());
		imprimir("Sueldo promedio: " + as.sueldoPromedio());
		imprimir("Sueldo mayor: " + as.sueldoMayor());
		imprimir("Sueldo menor: " + as.sueldoMenor());
		imprimir("Sueldos mayores o igual al promedio: " + as.cantMayoresSueldoPromedio());
		imprimir("Sueldos menores: " + as.cantMenoresSueldoPromedio());
		imprimir("Posicion del segundo sueldo mayor a 850.0 : " + as.posSegundoSueldoMayorAlMinimo());
		imprimir("Posición del último sueldo menor a 850.0: " + as.cantMenoresSueldoPromedio());
	}
	protected void actionPerformedBtnGenerar(ActionEvent e) {
		ArregloSueldos as = new ArregloSueldos();
		textArea.setText("");
		as.generarSueldo();
		
		imprimir("Sueldos generados aleatoriamente!!!");
		for(int i=0; i<as.tamaño(); i++) {
			imprimir(as.obtener(i) + "");
		}
	}
	
	public void imprimir(String string) {
		textArea.append( string + "\n");
	}
}
