package br.com.xablau;

import static org.junit.Assert.assertEquals;

public class CPUTest {

	public void executeProcesses() throws InterruptedException {
		Memory memory = new Memory(400);

		Process p1 = new Process(200, 100, -1, "1");
		Process p2 = new Process(200, 300, -1, "2");
		Process p3 = new Process(200, 300, -1, "3");
		Process p4 = new Process(200, 300, -1, "4");
		Process p5 = new Process(200, 300, -1, "5");
		Process p6 = new Process(200, 300, -1, "6");

		CPU cpu = new CPU(memory);

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(1200, cpu.executeProcesses());
	}

	public void executeProcessesCPUPriority() throws InterruptedException {
		Memory memory = new Memory(400);

		Process p1 = new Process(200, 100, 1, "1");
		Process p2 = new Process(200, 300, 2, "2");
		Process p3 = new Process(200, 300, 3, "3");
		Process p4 = new Process(200, 300, 4, "4");
		Process p5 = new Process(200, 300, 5, "5");
		Process p6 = new Process(200, 300, 6, "6");

		CPU cpu = new CPUPriority(memory);

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(1200, cpu.executeProcesses());
	}

	public void executeProcessesCPURoundRobin() throws InterruptedException {
		Memory memory = new Memory(1000);

		Process p1 = new Process(100, 200, 1, "1");
		Process p2 = new Process(200, 200, 2, "2");
		Process p3 = new Process(300, 200, 3, "3");
		Process p4 = new Process(400, 200, 4, "4");
		Process p5 = new Process(500, 200, 5, "5");
		Process p6 = new Process(600, 200, 6, "6");

		CPU cpu = new CPURoundRobin(memory);

		cpu.addProcess(p1);
		cpu.addProcess(p2);
		cpu.addProcess(p3);
		cpu.addProcess(p4);
		cpu.addProcess(p5);
		cpu.addProcess(p6);

		assertEquals(3150, cpu.executeProcesses());
	}
}
