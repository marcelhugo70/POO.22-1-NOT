import static org.junit.jupiter.api.Assertions.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import org.junit.jupiter.api.Test;

class Exe3Test {

	@Test
	void testHistograma() throws IOException{
		// criar o arquivo a ser usado no teste
		FileOutputStream fos = new FileOutputStream("ArquivoTesteHistrograma.tst");
		Random r = new Random();
		int LINHAS = 400;
		int COLUNAS = 400;
		int valor;
		int[] esperado = new int[256];
		for (int i=0; i < LINHAS; i++) {
			for (int j=0; j < COLUNAS; j++) {
				valor = r.nextInt(256);
				esperado[valor]++;
				fos.write(valor);
			}
		}
		fos.close();
		
		Exe3 exe = new Exe3();
		Path caminho = Paths.get("ArquivoTesteHistrograma.tst");
		int[] retorno = exe.histograma(caminho);
		assertArrayEquals(esperado, retorno);
	}

}
