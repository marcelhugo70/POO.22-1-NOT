import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventoApresentacao extends JFrame
{

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtValor;
	private JTextField txtData;
	private JTextField txtQtdPagantes;
	private JTextField txtOpiniaoGeral;
	private JTextField txtNomeBanda;
	private JTextField txtEstiloMusical;
	private JCheckBox checkShowMusical;
	private JButton btnCadastrar;
	private JLabel lblEstiloMusical;
	private JLabel lblNomeBanda;

	private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					EventoApresentacao frame = new EventoApresentacao();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public EventoApresentacao()
	{
		setResizable(false);
		setTitle("Gest\u00E3o de Eventos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EDtulo:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(73, 8, 214, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Valor:");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);

		txtValor = new JTextField();
		txtValor.setBounds(73, 33, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Data:");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);

		txtData = new JTextField();
		txtData.setBounds(73, 58, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Avalia\u00E7\u00E3o");
		lblNewLabel_3.setBounds(10, 86, 65, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Qtd pagantes:");
		lblNewLabel_4.setBounds(10, 111, 86, 14);
		contentPane.add(lblNewLabel_4);

		txtQtdPagantes = new JTextField();
		txtQtdPagantes.setBounds(106, 108, 86, 20);
		contentPane.add(txtQtdPagantes);
		txtQtdPagantes.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Opini\u00E3o geral:");
		lblNewLabel_5.setBounds(10, 136, 86, 14);
		contentPane.add(lblNewLabel_5);

		txtOpiniaoGeral = new JTextField();
		txtOpiniaoGeral.setBounds(106, 133, 318, 20);
		contentPane.add(txtOpiniaoGeral);
		txtOpiniaoGeral.setColumns(10);

		checkShowMusical = new JCheckBox("Show musical");
		checkShowMusical.setBounds(6, 157, 126, 23);
		contentPane.add(checkShowMusical);

		lblNomeBanda = new JLabel("Nome banda:");
		lblNomeBanda.setEnabled(false);
		lblNomeBanda.setBounds(10, 190, 86, 14);
		contentPane.add(lblNomeBanda);

		txtNomeBanda = new JTextField();
		txtNomeBanda.setEnabled(false);
		txtNomeBanda.setBounds(106, 184, 181, 20);
		contentPane.add(txtNomeBanda);
		txtNomeBanda.setColumns(10);

		lblEstiloMusical = new JLabel("Estilo musical:");
		lblEstiloMusical.setEnabled(false);
		lblEstiloMusical.setBounds(10, 215, 86, 14);
		contentPane.add(lblEstiloMusical);

		txtEstiloMusical = new JTextField();
		txtEstiloMusical.setEnabled(false);
		txtEstiloMusical.setBounds(106, 209, 181, 20);
		contentPane.add(txtEstiloMusical);
		txtEstiloMusical.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				cadastra();
			}
		});
		btnCadastrar.setBounds(10, 250, 89, 23);
		contentPane.add(btnCadastrar);

		JButton btnRelatorio = new JButton("Relat\u00F3rio");
		btnRelatorio.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				StringBuilder sb = new StringBuilder("Eventos:\n");
				for (Evento evento : EventoRepository.getAll())
				{
					sb.append(evento.exibir() + "\n");  // polimorfismo
				}
				
				JOptionPane.showMessageDialog(null, sb.toString());
			}
		});
		btnRelatorio.setBounds(335, 250, 89, 23);
		contentPane.add(btnRelatorio);

		checkShowMusical.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				checkShowMusicalChanged();
			}
		});

		txtTitulo.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusLost(FocusEvent e)
			{
				btnCadastrar.setText("Cadastrar");
				String titulo = txtTitulo.getText();
				if (titulo == null || titulo.length() == 0)
					return;

				Evento evento = EventoRepository.get(titulo);
				if (evento == null)
					return;

				btnCadastrar.setText("Alterar");

				txtValor.setText(String.format("%.2f", evento.getValor()));
				txtData.setText(evento.getData().format(dateTimeFormatter));

				if (evento.possuiAvaliacao())
				{
					txtQtdPagantes.setText(Integer.toString(evento.getAvaliacao().getQtdPagantes()));
					txtOpiniaoGeral.setText(evento.getAvaliacao().getOpiniaoGeral());
				}
				else
				{
					txtQtdPagantes.setText(null);
					txtOpiniaoGeral.setText(null);
				}

				if (evento instanceof ShowMusical)
				{
					checkShowMusical.setSelected(true);

					ShowMusical show = (ShowMusical) evento;
					txtNomeBanda.setText(show.getNomeBanda());
					txtEstiloMusical.setText(show.getEstiloMusical());
				}
				else
				{
					checkShowMusical.setSelected(false);
				}
			}
		});
	}

	private void checkShowMusicalChanged()
	{
		txtNomeBanda.setText(null);
		txtEstiloMusical.setText(null);

		if (checkShowMusical.isSelected())
		{
			lblNomeBanda.setEnabled(true);
			txtNomeBanda.setEnabled(true);
			lblEstiloMusical.setEnabled(true);
			txtEstiloMusical.setEnabled(true);
		}
		else
		{
			lblNomeBanda.setEnabled(false);
			txtNomeBanda.setEnabled(false);
			lblEstiloMusical.setEnabled(false);
			txtEstiloMusical.setEnabled(false);
		}
	}

	private void cadastra()
	{
		String titulo = txtTitulo.getText();
		float valor = 0f;
		try
		{
			valor = Float.parseFloat(txtValor.getText().replace(',', '.'));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Valor inválido");
			txtValor.requestFocus();
			return;
		}

		LocalDate data = null;
		try
		{
			data = LocalDate.parse(txtData.getText(), dateTimeFormatter);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Data inválida (deve ser no formato dd/MM/yyyy)");
			txtData.requestFocus();
			return;
		}

		Evento evento = null;
		try
		{
			if (checkShowMusical.isSelected())
			{
				evento = new ShowMusical(titulo, valor, data, txtNomeBanda.getText(), txtEstiloMusical.getText());
			}
			else
			{
				evento = new Evento(titulo, valor, data);
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}

		String qtdPagantesString = txtQtdPagantes.getText();
		String opiniaoGeral = txtOpiniaoGeral.getText();
		if ((qtdPagantesString != null && !qtdPagantesString.equals(""))
				|| (opiniaoGeral != null && !opiniaoGeral.equals("")))
		{
			int qtdPagantes = 0;
			try
			{
				qtdPagantes = Integer.parseInt(txtQtdPagantes.getText());
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "Quantidade de pagantes inválida");
				txtQtdPagantes.requestFocus();
				return;
			}

			try
			{
				Avaliacao avaliacao = new Avaliacao(qtdPagantes, opiniaoGeral);
				evento.setAvaliacao(avaliacao);
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage());
				return;
			}
		}

		if (EventoRepository.exists(evento))
		{
			if (EventoRepository.update(evento))
			{
				JOptionPane.showMessageDialog(this, "Evento atualizado com sucesso.");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Não foi possível atualizar o evento.");
			}
		}
		else
		{
			if (EventoRepository.add(evento))
			{
				JOptionPane.showMessageDialog(this, "Evento cadastrado com sucesso.");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Não foi possível cadastrar o evento.");
			}
		}
	}
}
