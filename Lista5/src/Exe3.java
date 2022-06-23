import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

public class Exe3 {

	public int[] histograma(Path p) {
		int[] dados = new int[256];
		try {
			FileInputStream fis = new FileInputStream(p.toString());
			int lido = fis.read();
			while (lido != -1) {
				dados[lido]++;
				lido = fis.read();
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;
	}

}
