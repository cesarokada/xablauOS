package br.com.xablau;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			initOS();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initOS() throws InterruptedException {
		System.out.println("Initiallizing XablauOS...");

		initRoundRobin();
                
                System.out.println("\nPróxima execução em 5s");
                Thread.sleep(5000);
                
                initPriority();
                
                System.out.println("\nPróxima execução em 5s");
                Thread.sleep(5000);
                
                initFCFS();
                
                System.out.println("\nPróxima execução em 5s");
                Thread.sleep(5000);
                
                initLRU();
               
	}
        
        private static void initRoundRobin() throws InterruptedException{
            Memory memory = new Memory(1000);

            Process p1 = new Process(100, 1000, 1, "Word");
            Process p2 = new Process(200, 200, 2, "Excel");
            Process p3 = new Process(300, 200, 3, "Power Point");
            Process p4 = new Process(400, 200, 4, "Photoshop");
            Process p5 = new Process(500, 200, 5, "Google Chrome");
            Process p6 = new Process(600, 200, 6, "Steam");

            CPU cpu = new CPURoundRobin(memory);

            cpu.addProcess(p1);
            cpu.addProcess(p2);
            cpu.addProcess(p3);
            cpu.addProcess(p4);
            cpu.addProcess(p5);
            cpu.addProcess(p6);

            System.out.println("\nSimulação do algoritmo de escalonamento Round Robin");
            System.out.println("\nTempo de execução do algoritmo: " + cpu.executeProcesses() + " ms");
        }
        
        private static void initPriority() throws InterruptedException{
            Memory memory= new Memory(1000);
            
            Process p1 = new Process(100, 200, 5, "Word");
            Process p2 = new Process(200, 200, 3, "Excel");
            Process p3 = new Process(300, 200, 1, "Power Point");
            Process p4 = new Process(400, 200, 4, "Photoshop");
            Process p5 = new Process(500, 200, 2, "Google Chrome");
            Process p6 = new Process(600, 200, 6, "Steam");

            CPU cpu = new CPUPriority(memory);

            cpu.addProcess(p1);
            cpu.addProcess(p2);
            cpu.addProcess(p3);
            cpu.addProcess(p4);
            cpu.addProcess(p5);
            cpu.addProcess(p6);

            System.out.println("\nSimulação do algoritmo de escalonamento de prioridades");
            System.out.println("\nTempo de execução do algoritmo: " + cpu.executeProcesses() + " ms");
        }
        
        private static void initFCFS() throws InterruptedException{
            Memory memory = new Memory(1000);
            
            Process p1 = new Process(100, 200, 5, "Word");
            Process p2 = new Process(200, 200, 3, "Excel");
            Process p3 = new Process(300, 200, 1, "Power Point");
            Process p4 = new Process(400, 200, 4, "Photoshop");
            Process p5 = new Process(500, 200, 2, "Google Chrome");
            Process p6 = new Process(600, 200, 6, "Steam");

            CPU cpu = new CPU(memory);

            cpu.addProcess(p1);
            cpu.addProcess(p2);
            cpu.addProcess(p3);
            cpu.addProcess(p4);
            cpu.addProcess(p5);
            cpu.addProcess(p6);

            System.out.println("\nSimulação do algoritmo de escalonamento FCFS");
            System.out.println("\nTempo de execução do algoritmo: " + cpu.executeProcesses() + " ms");
        }
        
        private static void initLRU() throws InterruptedException{
            Memory memory = new MemoryLRU(1000);
            
            Process p1 = new Process(100, 1000, 1, "Word");
            Process p2 = new Process(200, 200, 2, "Excel");
            Process p3 = new Process(300, 600, 3, "Power Point");
            Process p4 = new Process(400, 400, 4, "Photoshop");
            Process p5 = new Process(500, 200, 5, "Google Chrome");
            Process p6 = new Process(600, 400, 6, "Steam");
            
            CPU cpu = new CPU(memory);
            
            cpu.addProcess(p1);
            cpu.addProcess(p2);
            cpu.addProcess(p3);
            cpu.addProcess(p4);
            cpu.addProcess(p5);
            cpu.addProcess(p6);

            System.out.println("\nSimulação do algoritmo de paginação LRU");
            cpu.executeProcesses();
        }
}
