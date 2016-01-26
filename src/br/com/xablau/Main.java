package br.com.xablau;


import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static final Memory memoria = new Memory(1000);

    public static final List<Process> processos = new ArrayList<Process>();
	
	public static final CPU cpu = new CPU();

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
        
        memoria.print();
        
        memoria.addProcess(p1);
        memoria.print();
        
        memoria.addProcess(p2);
        memoria.print();
        
        memoria.removeProcess(p2);
        memoria.print();
    }
}
