import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Apresentacao {

	private JFrame frmLista;
	private JTextField tf_Nome;
	private JTextField tf_CPF;
	private JTextField tf_UF;
	private JTextField tf_Renda;
	private JTextField tf_ValorConsulta;
	// usaremos dois containers para fins de exemplo didático. Normalmente opta-se por um deles.
	private ArrayList<Contribuinte> contribuintes = new ArrayList<>();
	private HashMap<String,Contribuinte> contribHash = new HashMap<>();
	private JTextField tfCPFConsulta;
	
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
		frmLista.setTitle("Lista 2 - Exerc\u00EDcio 1");
		frmLista.setBounds(100, 100, 450, 300);
		frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLista.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do contribuinte:");
		lblNewLabel.setBounds(10, 30, 125, 14);
		frmLista.getContentPane().add(lblNewLabel);
		
		tf_Nome = new JTextField();
		tf_Nome.setBounds(120, 27, 200, 20);
		frmLista.getContentPane().add(tf_Nome);
		tf_Nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(10, 55, 46, 14);
		frmLista.getContentPane().add(lblNewLabel_1);
		
		tf_CPF = new JTextField();
		tf_CPF.setBounds(120, 55, 86, 20);
		frmLista.getContentPane().add(tf_CPF);
		tf_CPF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Estado:");
		lblNewLabel_2.setBounds(10, 80, 46, 14);
		frmLista.getContentPane().add(lblNewLabel_2);
		
		tf_UF = new JTextField();
		tf_UF.setBounds(120, 77, 46, 20);
		frmLista.getContentPane().add(tf_UF);
		tf_UF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Renda anual: R$");
		lblNewLabel_3.setBounds(10, 105, 99, 14);
		frmLista.getContentPane().add(lblNewLabel_3);
		
		tf_Renda = new JTextField();
		tf_Renda.setBounds(120, 102, 86, 20);
		frmLista.getContentPane().add(tf_Renda);
		tf_Renda.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contribuinte c = new Contribuinte(tf_Nome.getText(),
						tf_CPF.getText(), tf_UF.getText(),
						Double.parseDouble(tf_Renda.getText()));
				double imposto = c.calcularImposto();
				JOptionPane.showMessageDialog(frmLista, "Imposto a pagar = "+imposto);
				// adicionar nos containers (lembrando que é um exemplo)
				contribuintes.add(c);
				contribHash.put(c.getCpf(), c);
			}
		});
		btnNewButton.setBounds(254, 101, 89, 23);
		frmLista.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Valor a consultar: R$");
		lblNewLabel_4.setBounds(10, 195, 125, 14);
		frmLista.getContentPane().add(lblNewLabel_4);
		
		tf_ValorConsulta = new JTextField();
		tf_ValorConsulta.setBounds(120, 192, 86, 20);
		frmLista.getContentPane().add(tf_ValorConsulta);
		tf_ValorConsulta.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valorConsulta = Double.parseDouble(tf_ValorConsulta.getText());
				Contribuinte c;
				for (int i=0; i < contribuintes.size(); i++) {
					c = contribuintes.get(i);
					if (c.calcularImposto() > valorConsulta) {
						String str = "Contribuinte: "+c.getNome()
									+"\nCPF:"+c.getCpf()
									+"\nRenda = "+c.getRendaAnual()
									+"\nImposto = "+c.calcularImposto();
						JOptionPane.showMessageDialog(null, str);
					}
				}
			}
		});
		btnNewButton_1.setBounds(216, 191, 89, 23);
		frmLista.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("CPF a consultar:");
		lblNewLabel_5.setBounds(10, 220, 99, 14);
		frmLista.getContentPane().add(lblNewLabel_5);
		
		tfCPFConsulta = new JTextField();
		tfCPFConsulta.setBounds(120, 220, 86, 20);
		frmLista.getContentPane().add(tfCPFConsulta);
		tfCPFConsulta.setColumns(10);
		
		JButton btnConsultaCPF = new JButton("Consultar");
		btnConsultaCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = tfCPFConsulta.getText();
				// consulta usando o ArrayList
				Contribuinte achado = null;
				for (Contribuinte c: contribuintes) { // for-each
					if (c.getCpf().equals(cpf)) {
						achado = c;
						break;
					}
				}
				if (achado != null) {
					JOptionPane.showMessageDialog(null, "Nome: "+achado.getNome()+"  Imposto = "+achado.calcularImposto());
				}
				else {
					JOptionPane.showMessageDialog(null, "CPF não localizado - ArrayList");
				}
					
				// consulta usando o HashMap
				Contribuinte c = contribHash.get(cpf);
				if (c != null) {
					JOptionPane.showMessageDialog(null, "Nome: "+c.getNome()+"  Imposto = "+c.calcularImposto());
				}
				else {
					JOptionPane.showMessageDialog(null, "CPF não localizado - HashMap");
				}
			}
		});
		btnConsultaCPF.setBounds(216, 219, 89, 23);
		frmLista.getContentPane().add(btnConsultaCPF);
		
		JButton btnEstados = new JButton("% dos estados");
		btnEstados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totSC, totPR, totRS, totGeral, imposto;
				totSC = totPR = totRS = totGeral = 0;
				for (Contribuinte c: contribuintes) {
					imposto = c.calcularImposto();
					if (c.getUf().equals("SC")) {
						totSC += imposto;
					}
					else if(c.getUf().equals("PR")) {
						totPR += imposto;
					}
					else if (c.getUf().equals("RS")){
						totRS += imposto;
					}
					totGeral += imposto;
				}
				String str="Participação % dos estados";
				str += "\nRS = "+ totRS+" = "+(totRS/totGeral)*100;
				str += "\nSC = "+ totSC+" = "+(totSC/totGeral)*100;
				str += "\nPR = "+ totPR+" = "+(totPR/totGeral)*100;
				str += "\nGeral = "+ totGeral;
				JOptionPane.showMessageDialog(null, str);
			}
		});
		btnEstados.setBounds(254, 157, 125, 23);
		frmLista.getContentPane().add(btnEstados);
	}
}
