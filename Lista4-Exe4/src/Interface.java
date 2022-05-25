// Exercício entregue por uma equipe e apresentado em sala.

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JCheckBox;

public class Interface {

	private JFrame frmDesempenhoVereadores;
	private JTextField tfPartido;
	private JTextField tfNomeVereador;
	private JTextField tfProjetosAprovados;
	private JTextField tfProjetosApresentados;
	private JTextField tfNumeroPartido;
	private Camara camara = new Camara();
	private Partido partidoAtual;
	private Vereador vereadorAtual;
	private ProjetoDeLei projetoAtual;
	private JTextField tfTituloProjeto;
	private JTextField tfDataApresentacao;
	private JTextField tfDataAprovacao;
	private JTextField tfNumeroProjeto;
	private JTextField tfLeiOrganica;
	private JTextField tfQtdVotosFavoraveis;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frmDesempenhoVereadores.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDesempenhoVereadores = new JFrame();
		frmDesempenhoVereadores.setTitle("Desempenho Vereadores");
		frmDesempenhoVereadores.setBounds(100, 100, 450, 326);
		frmDesempenhoVereadores.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesempenhoVereadores.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 265);
		frmDesempenhoVereadores.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro Partido", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Novo Partido:");
		lblNewLabel.setBounds(10, 14, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNmeroPartido = new JLabel("N\u00FAmero Partido:");
		lblNmeroPartido.setBounds(10, 48, 95, 14);
		panel.add(lblNmeroPartido);
		
		tfNumeroPartido = new JTextField();
		tfNumeroPartido.setBounds(135, 45, 95, 20);
		panel.add(tfNumeroPartido);
		tfNumeroPartido.setColumns(10);
		
		tfPartido = new JTextField();
		tfPartido.setBounds(135, 11, 191, 20);
		panel.add(tfPartido);
		tfPartido.setColumns(10);
		
		JButton btnPartido = new JButton("Cadastrar");
		btnPartido.setBounds(295, 180, 104, 23);
		panel.add(btnPartido);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Cadastro Vereador", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNovoVereador = new JLabel("Nome vereador:");
		lblNovoVereador.setBounds(10, 21, 104, 14);
		panel_1.add(lblNovoVereador);
		
		JLabel lblQuantidadeDeProjetos = new JLabel("Quantidade de projetos aprovados:");
		lblQuantidadeDeProjetos.setEnabled(false);
		lblQuantidadeDeProjetos.setBounds(10, 46, 242, 14);
		panel_1.add(lblQuantidadeDeProjetos);
		
		JLabel lblQuantidadeDeProjetos_2 = new JLabel("Quantidade de projetos apresentados:");
		lblQuantidadeDeProjetos_2.setEnabled(false);
		lblQuantidadeDeProjetos_2.setBounds(10, 71, 242, 14);
		panel_1.add(lblQuantidadeDeProjetos_2);
		
		tfProjetosApresentados = new JTextField();
		tfProjetosApresentados.setEditable(false);
		tfProjetosApresentados.setBounds(262, 68, 76, 20);
		panel_1.add(tfProjetosApresentados);
		tfProjetosApresentados.setColumns(10);
		
		tfProjetosAprovados = new JTextField();
		tfProjetosAprovados.setEditable(false);
		tfProjetosAprovados.setBounds(262, 43, 76, 20);
		panel_1.add(tfProjetosAprovados);
		tfProjetosAprovados.setColumns(10);
		
		tfNomeVereador = new JTextField();
		tfNomeVereador.setBounds(136, 18, 263, 20);
		panel_1.add(tfNomeVereador);
		tfNomeVereador.setColumns(10);
		
		JButton btnVereador = new JButton("Cadastrar");
		btnVereador.setBounds(295, 180, 104, 23);
		panel_1.add(btnVereador);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Cadastro de Projeto", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblTtuloDoProjeto = new JLabel("T\u00EDtulo do projeto:");
		lblTtuloDoProjeto.setBounds(10, 11, 104, 14);
		panel_3.add(lblTtuloDoProjeto);
		
		tfTituloProjeto = new JTextField();
		tfTituloProjeto.setColumns(10);
		tfTituloProjeto.setBounds(146, 8, 253, 20);
		panel_3.add(tfTituloProjeto);
		
		JLabel lblDataApresentao = new JLabel("Data Apresenta\u00E7\u00E3o:");
		lblDataApresentao.setBounds(10, 33, 129, 14);
		panel_3.add(lblDataApresentao);
		
		tfDataApresentacao = new JTextField();
		tfDataApresentacao.setColumns(10);
		tfDataApresentacao.setBounds(146, 30, 171, 20);
		panel_3.add(tfDataApresentacao);
		
		JLabel lblDataAprovao = new JLabel("Data Aprova\u00E7\u00E3o:");
		lblDataAprovao.setBounds(10, 55, 129, 14);
		panel_3.add(lblDataAprovao);
		
		tfDataAprovacao = new JTextField();
		tfDataAprovacao.setColumns(10);
		tfDataAprovacao.setBounds(146, 52, 171, 20);
		panel_3.add(tfDataAprovacao);
		
		JLabel lblNewLabel_1 = new JLabel("(dd/mm/yyyy)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(327, 55, 72, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNm = new JLabel("N\u00FAm Projeto:");
		lblNm.setBounds(10, 77, 104, 14);
		panel_3.add(lblNm);
		
		tfNumeroProjeto = new JTextField();
		tfNumeroProjeto.setColumns(10);
		tfNumeroProjeto.setBounds(146, 74, 171, 20);
		panel_3.add(tfNumeroProjeto);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Lei Complementar");
		chckbxNewCheckBox.setBounds(6, 96, 133, 23);
		panel_3.add(chckbxNewCheckBox);
		
		JLabel lblArtigoLeiOrgnica = new JLabel("Artigo Lei Org\u00E2nica:");
		lblArtigoLeiOrgnica.setBounds(10, 123, 137, 14);
		panel_3.add(lblArtigoLeiOrgnica);
		lblArtigoLeiOrgnica.setVisible(false);
		
		tfLeiOrganica = new JTextField();
		tfLeiOrganica.setColumns(10);
		tfLeiOrganica.setBounds(146, 120, 171, 20);
		panel_3.add(tfLeiOrganica);
		tfLeiOrganica.setVisible(false);
		
		JLabel lblQtdVotosFavorveis = new JLabel("Qtd Votos Favor\u00E1veis:");
		lblQtdVotosFavorveis.setBounds(10, 145, 137, 14);
		panel_3.add(lblQtdVotosFavorveis);
		lblQtdVotosFavorveis.setVisible(false);
		
		tfQtdVotosFavoraveis = new JTextField();
		tfQtdVotosFavoraveis.setColumns(10);
		tfQtdVotosFavoraveis.setBounds(146, 142, 171, 20);
		panel_3.add(tfQtdVotosFavoraveis);
		tfQtdVotosFavoraveis.setVisible(false);
		
		JButton btnNovoProjeto = new JButton("Novo Projeto");
		btnNovoProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(partidoAtual != null) {
					if(vereadorAtual != null) {
						try {
							if(chckbxNewCheckBox.isSelected()) {
								projetoAtual = new ProjetoDeLeiComplementar(tfTituloProjeto.getText(), tfDataApresentacao.getText(), 
											   tfDataAprovacao.getText(), Integer.parseInt(tfNumeroProjeto.getText()), tfLeiOrganica.getText(), Integer.parseInt(tfQtdVotosFavoraveis.getText()));
							} else {
								projetoAtual = new ProjetoDeLei(tfTituloProjeto.getText(), tfDataApresentacao.getText(), tfDataAprovacao.getText(), Integer.parseInt(tfNumeroProjeto.getText()));	
							}
							vereadorAtual.addProjeto(projetoAtual);
							JOptionPane.showMessageDialog(null,"Projeto Cadastrado!");
							tfTituloProjeto.setText(null);
							tfDataApresentacao.setText(null);
							tfDataAprovacao.setText(null);
							tfNumeroProjeto.setText(null);
							tfLeiOrganica.setText(null);
							tfQtdVotosFavoraveis.setText(null);
						} catch(IllegalArgumentException iae) {
							if(iae.getMessage().substring(0, 3).equals("For")) {
								JOptionPane.showMessageDialog(null,"Número inválido!");
							} else {
								JOptionPane.showMessageDialog(null,iae.getMessage());
							}
						} catch(DateTimeParseException dtpe) {
							JOptionPane.showMessageDialog(null,"Data inválida!");
						}
					} else {
						JOptionPane.showMessageDialog(null,"Nenhum vereador cadastrado!");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Nenhum partido cadastrado!");
				}
			}
		});
		btnNovoProjeto.setBounds(266, 190, 133, 23);
		panel_3.add(btnNovoProjeto);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_2, null);
		panel_2.setLayout(null);
		
		JButton btnTotalProj = new JButton("Total Projetos");
		btnTotalProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int projAprov = 0;
				int projApre = 0;
				for(Partido p : camara.partidos.values()) {
					projApre += p.getTotalApresentados();
					projAprov += p.getTotalAprovados();
				}
				JOptionPane.showMessageDialog(null,"Proj. Apresentados: "+projApre+"\nProj. Aprovados: "+projAprov);
			}
		});
		btnTotalProj.setBounds(10, 11, 174, 23);
		panel_2.add(btnTotalProj);
		
		JButton btnVereadorMenosDesemp = new JButton("Vereador Menor Desem.");
		btnVereadorMenosDesemp.setBounds(10, 68, 174, 23);
		panel_2.add(btnVereadorMenosDesemp);
		
		JButton btnVereadorMaisAprov = new JButton("Vereador Mais Aprov.");
		btnVereadorMaisAprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,camara.getVereadorMaisProjAprov());
			}
		});
		btnVereadorMaisAprov.setBounds(10, 40, 174, 23);
		panel_2.add(btnVereadorMaisAprov);
		
		JButton btnVereadoresAcimaMed = new JButton("Vereadores Acima M\u00E9d.");
		btnVereadoresAcimaMed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,camara.getVereadoresAcimaMedia());
			}
		});
		btnVereadoresAcimaMed.setBounds(212, 11, 174, 23);
		panel_2.add(btnVereadoresAcimaMed);
		
		JButton btnMdiaDeDesemp = new JButton("M\u00E9dia de Desemp Part.");
		btnMdiaDeDesemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				for(Partido p : camara.getPartidos().values()) {
					str += p.getNome()+" - "+p.getNumero()+": "+p.getMediaDesempenho()+"\n"; 
				}
				JOptionPane.showMessageDialog(null,str);
			}
		});
		btnMdiaDeDesemp.setBounds(212, 40, 174, 23);
		panel_2.add(btnMdiaDeDesemp);
		
		JButton btnProjAprovE = new JButton("Proj. Aprov. e Apre. Part.");
		btnProjAprovE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				for(Partido p : camara.getPartidos().values()) {
					str += p.getNome()+" - "+p.getNumero()+" Aprovados: "+p.getTotalAprovados()+" Apresentados: "+p.getTotalApresentados()+"\n"; 
				}
				JOptionPane.showMessageDialog(null,str);
			}
		});
		btnProjAprovE.setBounds(212, 68, 174, 23);
		panel_2.add(btnProjAprovE);
		
		JButton btnVereadorProjeto = new JButton("Vereador - Projeto");
		btnVereadorProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "";
				for(Partido p : camara.partidos.values()) {
					for(Vereador v : p.getListaVereadores()) {
						for(ProjetoDeLei l : v.getListaProjetos()) {
							str += v.getNome()+" ("+p.getNome()+" - "+p.getNumero()+") Desempenho: "+v.getDesempenho()+"\n "+
								   l.mostrar()+"\n";
						}
					}
				}
				JOptionPane.showMessageDialog(null,str);
			}
		});
		btnVereadorProjeto.setBounds(113, 102, 174, 23);
		panel_2.add(btnVereadorProjeto);
		btnVereadorMenosDesemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,camara.getVereadorMenorDesemp());
			}
		});
		btnVereador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(partidoAtual != null) {
					if(tfNomeVereador.getText()!= null && !tfNomeVereador.getText().isEmpty() /*&& tfProjetosAprovados.getText()!= null && !tfProjetosAprovados.getText().isEmpty() && tfProjetosApresentados.getText()!= null && !tfProjetosApresentados.getText().isEmpty() && tfProjetosApresentados.getText().matches("[0-9]+") == true && tfProjetosAprovados.getText().matches("[0-9]+") == true*/) {
						partidoAtual.addVereador(tfNomeVereador.getText()/*, Integer.parseInt(tfProjetosApresentados.getText()), Integer.parseInt(tfProjetosAprovados.getText())*/);
						JOptionPane.showMessageDialog(null,"Vereador cadastrado!");
						vereadorAtual = partidoAtual.getVereadorAtual();
						tfNomeVereador.setText(null);
						tfProjetosAprovados.setText(null);
						tfProjetosApresentados.setText(null);
					} else {
						JOptionPane.showMessageDialog(null,"Informe valores válidos!");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Nenhum partido cadastrado!");
				}
			}
		});
		btnPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfPartido.getText() != null && !tfPartido.getText().isEmpty() && tfNumeroPartido.getText() != null && !tfNumeroPartido.getText().isEmpty() && tfNumeroPartido.getText().matches("[0-9]+") == true) {
					if(!camara.isNumeroExistente(Integer.parseInt(tfNumeroPartido.getText()))) {
						camara.addPartido(Integer.parseInt(tfNumeroPartido.getText()), tfPartido.getText());
						partidoAtual = camara.partidos.get(Integer.parseInt(tfNumeroPartido.getText()));
						JOptionPane.showMessageDialog(null,"Partido cadastrado!");
						tfNomeVereador.setText(null);
						tfProjetosAprovados.setText(null);
						tfProjetosApresentados.setText(null);
					} else {
						JOptionPane.showMessageDialog(null,"Já existe um partido com esse número!");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Informe valores válidos!");
				}
			}
		});
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					lblQtdVotosFavorveis.setVisible(true);
					tfQtdVotosFavoraveis.setVisible(true);
					tfLeiOrganica.setVisible(true);
					lblArtigoLeiOrgnica.setVisible(true);
				} else {
					lblQtdVotosFavorveis.setVisible(false);
					tfQtdVotosFavoraveis.setVisible(false);
					tfLeiOrganica.setVisible(false);
					lblArtigoLeiOrgnica.setVisible(false);
				}
			}
		});
	}
}
