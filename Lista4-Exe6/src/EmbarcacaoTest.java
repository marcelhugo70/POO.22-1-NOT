import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

class EmbarcacaoTest {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Test
	void TesteSegurancaTransatlanticoNavioEmPerigo() {
		Transatlantico embarcacao = new Transatlantico("Titanic II", LocalDate.of(2010,05,14), "FTR 1267", 5000);
		BoteSalvaVidas bote1 = new BoteSalvaVidas("BSV 001", 28, true, 5, 28);
		embarcacao.addBote(bote1);
		embarcacao.addBote("BSV 1966", 142, false, 12, 145);
		embarcacao.addBote("BSV 244", 122, false, 12, 120);

		assertEquals("CUIDADO: navio em perigo!", embarcacao.verificaSeguranca());
	}

	@Test
	void TesteSegurancaTransatlanticoNavioOK() {
		Transatlantico embarcacao = new Transatlantico("Titanic II", LocalDate.parse("14/05/2010", formatter), "FTR 1267", 100);
		BoteSalvaVidas bote1 = new BoteSalvaVidas("BSV 001", 28, true, 5, 25);
		embarcacao.addBote(bote1);
		embarcacao.addBote("BSV 1966", 142, false, 12, 50);
		embarcacao.addBote("BSV 244", 122, false, 12, 25);

		assertEquals("Está em condições adequadas de segurança.", embarcacao.verificaSeguranca());
	}

	@Test
	void TesteSegurancaTransatlanticoNavioMaisBotes() {
		Transatlantico embarcacao = new Transatlantico("Titanic II",
				LocalDate.now().plusDays(1), "FTR 1267", 5000);
		BoteSalvaVidas bote1 = new BoteSalvaVidas("BSV 001", 28, true, 5, 28);
		embarcacao.addBote(bote1);
		embarcacao.addBote("BSV 1966", 142, false, 12, 145);
		embarcacao.addBote("BSV 244", 122, false, 12, 120);

		assertEquals("ALERTA: navio necessitando de mais botes!", embarcacao.verificaSeguranca());
	}

	@Test
	void TesteSegurancaBoteSalvaVidaOK() {
		BoteSalvaVidas bote = new BoteSalvaVidas("FTR 1267", 150, false, 10, 200);

		assertEquals("Bote OK!", bote.verificaSeguranca());
	}

	@Test
	void TesteSegurancaBoteSalvaVidaNaoOK() {
		BoteSalvaVidas bote = new BoteSalvaVidas("FTR 1267", 150, false, 10, 50);

		assertEquals("Insuficiência de 100 coletes salva-vidas.", bote.verificaSeguranca());
	}

}
