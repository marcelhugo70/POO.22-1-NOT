import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		TelefoneResidencial tr = new TelefoneResidencial("471111","João da Silva",
				"Rua 7",LocalDate.now(),true);
		System.out.println(tr.exibir());

		TelefoneComercial tc = new TelefoneComercial("442222","XPTO", 
				"Rua 7, 110",LocalDate.now(),"Vendas");
		System.out.println(tc.exibir());

		TelefoneEspecializado te = new TelefoneEspecializado("443333","Mil Serviços",
				"Rua XV,123", LocalDate.now(), 1680);
		System.out.println(te.exibir());
		
		Telefone t = new TelefoneResidencial("474444", "Maria",
						"Rua XV,250",LocalDate.now(),false);
		System.out.println(t.exibir());
		
	}

}
