import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frmLista;
	private JTextField tfTamanho;
	private JTextField tfValor;
	private JTextField tfPosicao;
	private VetorDeReais vetReais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frmLista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLista = new JFrame();
		frmLista.setTitle("Lista 2 - Exerc\u00EDcio 6");
		frmLista.setBounds(100, 100, 450, 300);
		frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLista.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Qual o tamanho do vetor?");
		lblNewLabel.setBounds(10, 23, 163, 14);
		frmLista.getContentPane().add(lblNewLabel);
		
		tfTamanho = new JTextField();
		tfTamanho.setBounds(179, 20, 42, 20);
		frmLista.getContentPane().add(tfTamanho);
		tfTamanho.setColumns(10);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetReais = new VetorDeReais(Integer.parseInt(tfTamanho.getText()));
			}
		});
		btnCriar.setBounds(257, 19, 89, 23);
		frmLista.getContentPane().add(btnCriar);
		
		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setBounds(10, 75, 46, 14);
		frmLista.getContentPane().add(lblNewLabel_1);
		
		tfValor = new JTextField();
		tfValor.setBounds(67, 72, 86, 20);
		frmLista.getContentPane().add(tfValor);
		tfValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Posi\u00E7\u00E3o:");
		lblNewLabel_2.setBounds(10, 106, 46, 14);
		frmLista.getContentPane().add(lblNewLabel_2);
		
		tfPosicao = new JTextField();
		tfPosicao.setBounds(67, 103, 42, 20);
		frmLista.getContentPane().add(tfPosicao);
		tfPosicao.setColumns(10);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetReais.setValor(Double.parseDouble(tfValor.getText()),
				Integer.parseInt(tfPosicao.getText()));
			}
		});
		btnInserir.setBounds(132, 102, 89, 23);
		frmLista.getContentPane().add(btnInserir);
		
		JButton btnNewButton = new JButton("Quantidade de pares");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quant = vetReais.quantosPares();
				JOptionPane.showMessageDialog(null, "Quantidade de pares = "+quant);
			}
		});
		btnNewButton.setBounds(10, 159, 143, 23);
		frmLista.getContentPane().add(btnNewButton);
	}
}
