import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Exe2 {

	public static void main(String[] args) {
		JFileChooser jfc = new JFileChooser();
		int retorno = jfc.showOpenDialog(null);
		int chave = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor da chave (1-200):"));
		if (retorno == JFileChooser.APPROVE_OPTION) {
			File arquivoOrigem = jfc.getSelectedFile();
			
			try {
				String nomeSaida = arquivoOrigem.getAbsolutePath();
				int ponto = nomeSaida.lastIndexOf('.');
				nomeSaida = nomeSaida.substring(0, ponto)+"-saida"+nomeSaida.substring(ponto);
				FileReader leitura = new FileReader(arquivoOrigem);
				FileWriter saida = new FileWriter(nomeSaida);
				
				int lido = leitura.read();
				int novo;
				while(lido != -1) {
					novo = converter(lido,chave);
					saida.write(novo);
					lido = leitura.read();
				}
				// fechar os arquivos
				leitura.close();
				saida.close();
			} catch (FileNotFoundException fnfe) {
				JOptionPane.showMessageDialog(null, "Arquivo de leitura não encontrado");
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(null, "Erro de gravação");
			}
		}
	}

	private static int converter(int lido, int chave) {
		int valor = lido+chave;
		if (valor > 255) {
			valor = valor - 256;
		}
		//  linhas 46 a 48 poderiam ser substituídas por: valor = valor % 256;
		return valor;
	}
	

}
