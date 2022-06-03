import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lista5Exe1 {

	public static void main(String[] args) throws IOException {
		
		// gravar os arquivos
		FileWriter fw = new FileWriter("ArqTextoLista5-Exe1.txt");
		fw.write("12345");
		fw.close();
		
		FileOutputStream fos = new FileOutputStream("ArqBinárioLista5-Exe1.bin");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(12345);
		dos.close();
		
		
		// ler os arquivos como texto
		FileReader fr = new FileReader("ArqTextoLista5-Exe1.txt");
		BufferedReader br = new BufferedReader(fr);
		System.out.println("Lendo texto arquivo texto = "+br.readLine());
		br.close();
		fr = new FileReader("ArqBinárioLista5-Exe1.bin");
		br = new BufferedReader(fr);
		System.out.println("Lendo texto arquivo binário = "+br.readLine());
		br.close();
		
		// ler os arquivos como binário
		FileInputStream fis = new FileInputStream("ArqTextoLista5-Exe1.txt");
		DataInputStream dis = new DataInputStream(fis);
		System.out.println("Lendo binário arquivo texto = "+dis.readInt());
		dis.close();
		fis = new FileInputStream("ArqBinárioLista5-Exe1.bin");
		dis = new DataInputStream(fis);
		System.out.println("Lendo binário arquivo binário = "+dis.readInt());
		dis.close();
		
	}

}
