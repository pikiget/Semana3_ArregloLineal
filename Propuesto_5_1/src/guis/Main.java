package guis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.ArregloNotas;

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
		setBounds(100, 100, 614, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(33, 11, 89, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(231, 11, 89, 23);
		contentPane.add(btnReportar);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(422, 11, 89, 23);
		contentPane.add(btnGenerar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 578, 366);
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
		ArregloNotas an = new ArregloNotas();
		textArea.setText("");
		for(int i=0; i<an.tamaño(); i++) {
			textArea.append(an.obtener(i) + "\n");
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent e) {
		ArregloNotas an = new ArregloNotas();
		textArea.setText("");
		textArea.append("Cantidad de notas: " + an.tamaño() + "\n");
		textArea.append("Nota promedio: " + an.notaPromedio() + "\n");
		textArea.append("Nota mayor: " + an.notaMayor() + "\n");
		textArea.append("Nota menor: " + an.notaMenor() + "\n");
		textArea.append("Cantidad de notas aprobadas: " + an.cantNotasAprobatorias() + "\n");
		textArea.append("Cantidad de notas desaprobatorias: " + an.cantNotasDesaprobatorias() + "\n");
		textArea.append("Cantidad de notas mayores a 15: " + an.cantNotasMayoresA15() + "\n");
		textArea.append("Posición de la primera nota mayor o igual a 13: " + an.posPrimeraNotaAprobatoria() + "\n");
		textArea.append(" posición de la penúltima nota menor a 13: " + an.posPenultimaNotaDesaprobatoria() + "\n");
	}
	protected void actionPerformedBtnGenerar(ActionEvent e) {
		ArregloNotas an = new ArregloNotas();
		textArea.setText("");
		an.generarNotas();
		
		textArea.append("NOTAS GENERADAS!!!!");
		for(int i=0; i<an.tamaño(); i++) {
			textArea.append(an.obtener(i) + "\n");
		}
	}
}
