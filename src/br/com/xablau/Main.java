package br.com.xablau;


import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static final Memoria memoria = new Memoria(1000);

    public static final List<Processo> processos = new ArrayList<Processo>();
	
	public static final CPU cpu = new CPU(processos);

    public static void main(String[] args) {
        try {
            initOS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initOS() throws InterruptedException {
        System.out.println("Initiallizing XablauOS...");

        Processo p1 = new Processo(200, 100, -1);
        Processo p2 = new Processo(200, 300, -1);
        
        memoria.print();
        
        memoria.addProcesso(p1);
        memoria.print();
        
        memoria.addProcesso(p2);
        memoria.print();
        
        memoria.removeProcesso(p2);
        memoria.print();
    }
}
