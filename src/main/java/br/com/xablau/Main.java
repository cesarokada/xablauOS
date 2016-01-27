package br.com.xablau;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static final Memory memory = new Memory(1000);

	public static final List<Process> processos = new ArrayList<Process>();

	public static final CPU cpu = new CPU(memory);

	public static void main(String[] args) {
		try {
			initOS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initOS() throws InterruptedException {
		System.out.println("Initiallizing XablauOS...");

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
		
		cpu.executeProcesses();
	}
}
