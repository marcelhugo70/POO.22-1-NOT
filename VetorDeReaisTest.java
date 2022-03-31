import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VetorDeReaisTest {

	@Test
	void testDivisao_objetos_de_tamanho_diferentes() {
		// Arrange
		VetorDeReais vr1 = new VetorDeReais(3);
		vr1.setValor(2, 0);  // 2 , -1, 3.5
		vr1.setValor(-1, 1);
		vr1.setValor(3.5, 2);
		VetorDeReais vr2 = new VetorDeReais(1);
		vr2.setValor(3, 0);
		// Act
		VetorDeReais vr3 = vr1.divisao(vr2);
		// Assert
		assertNull(vr3);
	}
	
	@Test
	void testDivisao_objetos_de_tamanho_iguais() {
		// Arrange
		VetorDeReais vr1 = new VetorDeReais(3);
		vr1.setValor(2, 0);  // 2 , -1, 3.5
		vr1.setValor(-1, 1);
		vr1.setValor(3.5, 2);
		VetorDeReais vr2 = new VetorDeReais(3);
		vr2.setValor(3, 0);
		vr2.setValor(2, 1);
		vr2.setValor(1, 2);
		// Act
		VetorDeReais vr3 = vr1.divisao(vr2);
		// Assert
		double[] esperado = {0.66666666, -0.5 , 3.5};
		for (int i=0; i < esperado.length; i++) {
			assertEquals(esperado[i], vr3.getValor(i),0.00001);
		}
	}

}
