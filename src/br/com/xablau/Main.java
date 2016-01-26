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

        Process p1 = new Process(200, 100, -1);
        Process p2 = new Process(200, 300, -1);
        
        memory.print();
        
        memory.addProcess(p1);
        memory.print();
        
        memory.addProcess(p2);
        memory.print();
        
        memory.removeProcess(p2);
        memory.print();
    }
}
