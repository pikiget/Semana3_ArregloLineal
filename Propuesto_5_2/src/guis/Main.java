package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ArregloPrecios;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 635, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(42, 23, 89, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(262, 23, 89, 23);
		contentPane.add(btnReportar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(486, 23, 89, 23);
		contentPane.add(btnGenerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 599, 378);
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
		textArea.setText("");
		ArregloPrecios ap = new ArregloPrecios();
		
		for(int i=0; i<ap.tamaño(); i++) {
			textArea.append(ap.obtener(i) + "\n");
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
		ArregloPrecios ap = new ArregloPrecios();
		textArea.setText("Cantidad precios: " + ap.tamaño() + "\n");
		textArea.append("Precio promedio: " + ap.precioPromedio() + "\n");
		textArea.append("Precio mayor: " + ap.precioMayor() + "\n");
		textArea.append("Precio menor: " + ap.precioMenor() + "\n");
		textArea.append("cantidad de productos cuyo precio es mayor o igual al precio promedios: " + ap.cantMayoresPrecioPromedio() + "\n");
		textArea.append("cantidad de productos cuyo precio es menor al precio promedio: " + ap.cantMenoresPrecioPromedio() + "\n");
		textArea.append("posición del primer precio mayor al segundo de los precios: " + ap.posPrimerPrecioMayorAlSegundo() + "\n");
		textArea.append("posición del último precio menor al penúltimo de los precios: " + ap.posUltimoPrecioMenorAlPenultimo() + "\n");
	}
	protected void actionPerformedBtnGenerar(ActionEvent e) {
		ArregloPrecios ap = new ArregloPrecios();
		ap.generarPrecios();
		textArea.setText("Notas generadas de forma aleatoria!!" + "\n");
		for(int i=0; i<ap.tamaño(); i++) {
			textArea.append(ap.obtener(i) + "\n");
		}
	}
}
