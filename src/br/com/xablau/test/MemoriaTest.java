package br.com.xablau.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.xablau.Memoria;
import br.com.xablau.Processo;

public class MemoriaTest {

	@Test
	public void createMemoria() {
		Memoria memoria = new Memoria(1000);
		
		assertEquals(1, memoria.getMemoria().size());
		assertEquals(1000, memoria.getMemoria().get(0).getTamanho(), 0);
	}

	@Test
	public void addProcesso() {
		Memoria memoria = new Memoria(1000);
		Processo processo = new Processo(100, 300);

		memoria.addProcesso(processo);
		
		assertEquals(2, memoria.getMemoria().size());
		assertEquals(300, memoria.getMemoria().get(0).getTamanho(), 0);
		assertEquals(700, memoria.getMemoria().get(1).getTamanho(), 0);
	}
	
	@Test
	public void removeProcesso() {
		Memoria memoria = new Memoria(1000);
		Processo p1 = new Processo(100, 300);
		Processo p2 = new Processo(100, 200);

		memoria.addProcesso(p1);
		memoria.addProcesso(p2);
		
		assertEquals(3, memoria.getMemoria().size());
		assertEquals(300, memoria.getMemoria().get(0).getTamanho(), 0);
		assertEquals(200, memoria.getMemoria().get(1).getTamanho(), 0);
		assertEquals(500, memoria.getMemoria().get(2).getTamanho(), 0);
		
		memoria.removeProcesso(p1);
		
		assertEquals(3, memoria.getMemoria().size());
		assertTrue(memoria.getMemoria().get(0).isDisponivel());
		assertFalse(memoria.getMemoria().get(1).isDisponivel());
		assertTrue(memoria.getMemoria().get(2).isDisponivel());
	}
	
	@Test
	public void removeProcessoUneEspacosVazios() {
		Memoria memoria = new Memoria(1000);
		Processo p1 = new Processo(100, 300);
		Processo p2 = new Processo(100, 200);

		memoria.addProcesso(p1);
		memoria.addProcesso(p2);
		
		memoria.removeProcesso(p2);
		
		assertEquals(2, memoria.getMemoria().size());
		assertEquals(700, memoria.getMemoria().get(1).getTamanho(), 0);
	}
}
