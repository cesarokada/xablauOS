package br.com.xablau.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.xablau.CPU;
import br.com.xablau.CPUPriority;
import br.com.xablau.CPURoundRobin;
import br.com.xablau.Process;

public class CPUTest {

	@Test
	public void executeProcesses() throws InterruptedException {
		Process p1 = new Process(200, 100, -1);
		Process p2 = new Process(200, 300, -1);
		Process p3 = new Process(200, 300, -1);
		Process p4 = new Process(200, 300, -1);
		Process p5 = new Process(200, 300, -1);
		Process p6 = new Process(200, 300, -1);

		CPU cpu = new CPU();

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(1200, cpu.executeProcesses());
	}
	
	@Test
	public void executeProcessesCPUPriority() throws InterruptedException {
		Process p1 = new Process(200, 100, 1);
		Process p2 = new Process(200, 300, 2);
		Process p3 = new Process(200, 300, 3);
		Process p4 = new Process(200, 300, 4);
		Process p5 = new Process(200, 300, 5);
		Process p6 = new Process(200, 300, 6);

		CPU cpu = new CPUPriority();

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(1200, cpu.executeProcesses());
	}
	
	@Test
	public void executeProcessesCPURoundRobin() throws InterruptedException {
		Process p1 = new Process(100, 100, 1);
		Process p2 = new Process(200, 300, 2);
		Process p3 = new Process(300, 300, 3);
		Process p4 = new Process(400, 300, 4);
		Process p5 = new Process(500, 300, 5);
		Process p6 = new Process(600, 300, 6);

		CPU cpu = new CPURoundRobin();

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(3150, cpu.executeProcesses());
	}
}
