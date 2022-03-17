import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Apresentacao {

	private JFrame frame;
	private JTextField tf_Frase;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a frase:");
		lblNewLabel.setBounds(10, 36, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		
		tf_Frase = new JTextField();
		tf_Frase.setBounds(88, 33, 313, 20);
		frame.getContentPane().add(tf_Frase);
		tf_Frase.setColumns(10);
		
		JButton btnNewButton = new JButton("Separar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frase f = new Frase();
				f.setTexto(tf_Frase.getText());
				String[] vetor = f.separar();
				textArea.setText("Palavras separadas:\n");
				for (int i=0; i < vetor.length;i++) {
					textArea.append("\n"+vetor[i]+ " = "+vetor[i].length());
				}
			}
		});
		btnNewButton.setBounds(88, 66, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(88, 113, 313, 115);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
	}
}
