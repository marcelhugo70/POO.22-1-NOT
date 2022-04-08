import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;

class AgendaTest {


	// cada método de teste pode durar no máximo 1 segundo
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);
	


	@Test
	public void testMediaCompromisso01() {
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		int mediaCalculada = da.getTempoMedio();

		assertEquals(103, mediaCalculada);
	}

	@Test
	public void testMediaCompromisso02() {
		LocalDate ld = LocalDate.of(2019, 5, 20);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(14, 0);
		Compromisso c = new Compromisso(lt, "Teste de sistema", 90, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(17, 30);
		c = new Compromisso(lt, "Visita", 30, 'B');
		da.addCompromisso(c);

		int mediaCalculada = da.getTempoMedio();

		assertEquals(60, mediaCalculada);
	}

	@Test
	public void testAdicionarMesmaData() {
		Agenda agenda = new Agenda();

		LocalDate ld = LocalDate.of(2021,04,06);
		DataAgenda da1 = new DataAgenda(ld,"");

		ld = LocalDate.of(2021,04,06);
		DataAgenda da2 = new DataAgenda(ld,"");

		assertTrue(agenda.addData(da1));
		assertFalse(agenda.addData(da2));
	}

	@Test
	public void testAdicionarDatasDiferentes() {
		Agenda agenda = new Agenda();

		LocalDate ld = LocalDate.of(2021,04,06);
		DataAgenda da1 = new DataAgenda(ld,"");

		ld = LocalDate.of(2021,04,07);
		DataAgenda da2 = new DataAgenda(ld,"");

		assertTrue(agenda.addData(da1));
		assertTrue(agenda.addData(da2));
	}

	@Test
	public void testQuantidadeCompromisso01() {
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		assertEquals(2, da.getQtdCompromissosPrioridade('A'));
	}

	@Test
	public void testQuantidadeCompromisso02() {
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		assertEquals(0, da.getQtdCompromissosPrioridade('B'));
	}

	@Test
	public void testBuscarCompromisso01() {
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		ArrayList retorno = da.getCompromissosPrioridade('A');
		assertEquals(2, retorno.size());
	}

	@Test
	public void testBuscarCompromisso02() {
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		ArrayList retorno = da.getCompromissosPrioridade('B');
		assertEquals(0, retorno.size());
	}

	@Test
	public void testAddCompromissoMesmaHora() {
		LocalDate ld = LocalDate.of(2019, 5, 20);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(14, 0);
		Compromisso c = new Compromisso(lt, "Teste de sistema", 90, 'A');
		assertTrue(da.addCompromisso(c));

		lt = LocalTime.of(14, 0);
		c = new Compromisso(lt, "Visita", 30, 'B');
		assertFalse(da.addCompromisso(c));
	}

	@Test
	public void testPrioridadeInvalida() {
		LocalTime lt = LocalTime.of(14, 0);
		Compromisso c = new Compromisso(lt, "Teste de sistema", 90, 'A');
		//assertThrows(IllegalArgumentException.class,()->c.setPrioridade('X'));
		c.setPrioridade('X');
		assertEquals('A',c.getPrioridade());
	}

	@Test
	public void testMenorCompromisso01() {
		Agenda agenda = new Agenda();
		Compromisso menor;

		// primeiro dia com seus compromissos
		LocalDate ld = LocalDate.of(2019, 5, 18);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(8, 0);
		Compromisso c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		agenda.addData(da);

		// segundo dia com seus compromissos e o menor
		ld = LocalDate.of(2019, 5, 20);
		da = new DataAgenda(ld,"");

		lt = LocalTime.of(17, 30);
		c = new Compromisso(lt, "Visita", 30, 'B');
		da.addCompromisso(c);
		menor = c;

		lt = LocalTime.of(14, 0);
		c = new Compromisso(lt, "Teste de sistema", 90, 'A');
		da.addCompromisso(c);

		agenda.addData(da);

		c = agenda.getMenorCompromisso();

		assertSame(menor, c);
	}

	@Test
	public void testMenorCompromisso02() {
		Agenda agenda = new Agenda();
		Compromisso menor;

		// primeiro dia com seus compromissos e o menor
		LocalDate ld = LocalDate.of(2019, 5, 20);
		DataAgenda da = new DataAgenda(ld,"");

		LocalTime lt = LocalTime.of(17, 30);
		Compromisso c = new Compromisso(lt, "Visita", 30, 'B');
		da.addCompromisso(c);
		menor = c;

		lt = LocalTime.of(14, 0);
		c = new Compromisso(lt, "Teste de sistema", 90, 'A');
		da.addCompromisso(c);

		agenda.addData(da);

		// segundo dia com seus compromissos
		ld = LocalDate.of(2019, 5, 18);
		da = new DataAgenda(ld,"");

		lt = LocalTime.of(8, 0);
		c = new Compromisso(lt, "Missa", 120, 'A');
		da.addCompromisso(c);

		lt = LocalTime.of(12, 0);
		c = new Compromisso(lt, "Almoço", 90, 'N');
		da.addCompromisso(c);

		lt = LocalTime.of(18, 30);
		c = new Compromisso(lt, "Cinema", 100, 'A');
		da.addCompromisso(c);

		agenda.addData(da);

		c = agenda.getMenorCompromisso();

		assertSame(menor, c);
	}

}
