package br.com.xablau;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MemoriaTest {

	@Test
	public void createMemoria() {
		Memory memoria = new Memory(1000);
		
		assertEquals(1, memoria.getMemoria().size());
		assertEquals(1000, memoria.getMemoria().get(0).getTamanho(), 0);
	}

	@Test
	public void addProcesso() {
		Memory memoria = new Memory(1000);
		Process processo = new Process(100, 300, -1);

		memoria.addProcess(processo);
		
		assertEquals(2, memoria.getMemoria().size());
		assertEquals(300, memoria.getMemoria().get(0).getTamanho(), 0);
		assertEquals(700, memoria.getMemoria().get(1).getTamanho(), 0);
	}
	
	@Test
	public void removeProcesso() {
		Memory memoria = new Memory(1000);
		Process p1 = new Process(100, 300, -1);
		Process p2 = new Process(100, 200, -1);

		memoria.addProcess(p1);
		memoria.addProcess(p2);
		
		assertEquals(3, memoria.getMemoria().size());
		assertEquals(300, memoria.getMemoria().get(0).getTamanho(), 0);
		assertEquals(200, memoria.getMemoria().get(1).getTamanho(), 0);
		assertEquals(500, memoria.getMemoria().get(2).getTamanho(), 0);
		
		memoria.removeProcess(p1);
		
		assertEquals(3, memoria.getMemoria().size());
		assertTrue(memoria.getMemoria().get(0).isDisponivel());
		assertFalse(memoria.getMemoria().get(1).isDisponivel());
		assertTrue(memoria.getMemoria().get(2).isDisponivel());
	}
	
	@Test
	public void removeProcessoUneEspacosVazios() {
		Memory memoria = new Memory(1000);
		Process p1 = new Process(100, 300, -1);
		Process p2 = new Process(100, 200, -1);

		memoria.addProcess(p1);
		memoria.addProcess(p2);
		
		memoria.removeProcess(p2);
		
		assertEquals(2, memoria.getMemoria().size());
		assertEquals(700, memoria.getMemoria().get(1).getTamanho(), 0);
	}
}