import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Veiculo> cars = new LinkedList<Veiculo>();
		Veiculo v = new Veiculo("NMR9999", "golf", 2013, "Matheus");
		cars.add(v);
		v = new Veiculo("MEU2314", "fusca", 1800, "Jorge");
		cars.add(v);
		v = new Veiculo("MKI8989", "uno escada", 2000, "NET");
		cars.add(v);
		v = new Veiculo("CAR0901", "ferrari", 2020, "Velho da Lancha");
		cars.add(v);
		v = new Veiculo("NAR6666", "maquina mortifera", 1999, "Chucky");
		cars.add(v);
		v = new Veiculo("LIK0000", " gol bolinha", 2006, "desconhecido");
		cars.add(v);
		v = new Veiculo("KIK7878", "gol quadrado", 2006, "Toni");
		cars.add(v);
		v = new Veiculo("TKJ1552", "submarino", 2020, "Marinha");
		cars.add(v);
		v = new Veiculo("$$$0001", "foguete", 2022, "NASA");
		cars.add(v);
		v = new Veiculo("NSEI90", "transformes", 9999, "Otimus Prime");
		cars.add(v);

		Veiculo v2 = v;

		System.out.println(cars);

		cars.remove(v2);  // removendo pelo objeto
		System.out.println(cars);
		cars.remove(6);  // removendo pela posição
		System.out.println(cars);
		
		// removendo pelo iterador
		ListIterator<Veiculo> li;
		li = cars.listIterator(cars.size());
		v2 = li.previous();
		v2 = li.previous();
		v2 = li.previous();
		System.out.println(v2);
		li.remove();
		System.out.println(cars);
		
		System.out.println("Ordenação=-=-=-=-=-=");
		// opção 1
		Collections.sort(cars);
		System.out.println(cars);
		Collections.shuffle(cars);
		System.out.println(cars);
		// opção 2
		cars.sort(null);
		System.out.println(cars);
		
		Comparator<Veiculo> comparaAnoPlaca = new Comparator<Veiculo>() {
			public int compare(Veiculo v1, Veiculo v2) {
				if (v1.getAno() > v2.getAno()) {
					// v1 é maior que v2
					return 1;
				}
				else if (v1.getAno() < v2.getAno()) {
					// v1 é menor que v2
					return -1;
				}
				return v1.compareTo(v2);
			}
		};
		
		Collections.shuffle(cars);
		System.out.println(cars);
		cars.sort(comparaAnoPlaca);
		System.out.println(cars);
		
		// 3a ordem
		Comparator<Veiculo> comparaModeloAnoPlaca = new Comparator<Veiculo>() {
			public int compare(Veiculo v1, Veiculo v2) {
				int retorno = v1.getModelo().compareTo(v2.getModelo());
				if (retorno == 0) {
					return comparaAnoPlaca.compare(v1, v2);
				}
				else
					return retorno;
			}
		};
		Collections.shuffle(cars);
		System.out.println(cars);
		cars.sort(comparaModeloAnoPlaca);
		System.out.println(cars);
	}
}
