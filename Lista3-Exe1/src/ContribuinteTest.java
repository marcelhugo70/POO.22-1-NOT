import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContribuinteTest {

	@Test
	void testSetUf_SC() {
		Contribuinte c = new Contribuinte("Gui", "123", "SC", 1000);
		assertEquals("SC", c.getUf());
	}

	@Test
	void testSetUf_RS() {
		Contribuinte c = new Contribuinte("Gui", "123", "RS", 1000);
		assertEquals("RS", c.getUf());
	}
	
	@Test
	void testSetUf_PR() {
		Contribuinte c = new Contribuinte("Gui", "123", "PR", 1000);
		assertEquals("PR", c.getUf());
	}
	
	@Test
	void testSetUf_SP_invalido() {
		Contribuinte c = new Contribuinte("Gui", "123", "PR", 1000);
		c.setUf("SP");
		assertEquals("PR", c.getUf());
	}
	
	@Test
	void testSetUf_RJ_invalido() {
		Contribuinte c = new Contribuinte("Gui", "123", "PR", 1000);
		c.setUf("RJ");
		assertEquals("PR", c.getUf());
	}
	
	@Test
	void testSetRendaAnualNegativa() {
		// Assert
		Contribuinte c = new Contribuinte("Gui", "123", "SC", 1000);

		// Act
		c.setRendaAnual(-818.5);

		// Assert
		assertEquals(1000, c.getRendaAnual());
	}

	@Test
	void testCalcularImposto_para_uma_renda_de_3000() {
		// Padrão para teste = 3A
		// Arrange
		Contribuinte c = new Contribuinte("João", "123", "SC", 3000);

		// Act
		double imposto = c.calcularImposto();

		// Assert
		assertEquals(0.0, imposto);
	}

	@Test
	void testCalcularImposto_para_uma_renda_de_9000() {
		// Arrange
		Contribuinte c = new Contribuinte("João", "123", "SC", 9000);

		// Act
		double imposto = c.calcularImposto();

		// Assert
		assertEquals(522.0, imposto);
	}

	@Test
	final void testCalcularImposto_para_uma_renda_de_10000() {
		Contribuinte c1 = new Contribuinte("João", "123", "SC", 10000);
		assertEquals(1500, c1.calcularImposto());
	}

	@Test
	final void testCalcularImposto_para_uma_renda_de_34911_73() {
		Contribuinte c1 = new Contribuinte("João", "123", "SC", 34911.73);
		assertEquals(9600.72, c1.calcularImposto(), 0.006);
	}

}
