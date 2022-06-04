import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Lista5Exe4 {  // ainda incompleto
	public static void main(String args[]) throws IOException {
		DataInputStream dis = null;
		ArrayList<ClimaDoDia> dias = new ArrayList<>();
		try {
			DateTimeFormatter df = DateTimeFormatter.ofPattern("d/M/y");
			FileInputStream fis = new FileInputStream("DadosMeteorologicos-OK - 15 dias de Outubro.dat");
			dis = new DataInputStream(fis);

			String strData;
			String dirVento;
			int velVento;
			int indPluv;
			double temp;
			ClimaDoDia umDia = null;
			
			while (true) {
				strData = dis.readUTF();
				dirVento = "" + dis.readChar() + dis.readChar();
				velVento = dis.readInt();
				indPluv = dis.readInt();
				temp = dis.readDouble();

				LocalDate data = LocalDate.parse(strData, df);
				umDia = new ClimaDoDia(data, dirVento, velVento, indPluv, temp);
				dias.add(umDia);
				System.out.println(
						"Dados lidos = " + data + "," + dirVento + ", " + velVento + ", " + indPluv + ", " + temp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException eof) {
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dis.close();
		
		
		FileOutputStream fos = new FileOutputStream("Objetos.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (ClimaDoDia c : dias) {
			oos.writeObject(c);
		}
		oos.close();
		
		FileInputStream fis = new FileInputStream("Objetos.obj");
		ObjectInputStream ois = new ObjectInputStream(fis);
		try {
		while (true) {
			ClimaDoDia umDia = (ClimaDoDia) ois.readObject();
			System.out.println(umDia);
		}
		} catch (EOFException eof) {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
