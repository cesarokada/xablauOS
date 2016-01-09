package br.com.xablau;


public class Main {
	
	public static final Memoria memoria = new Memoria(1000);

    public static void main(String[] args) {
        try {
            initOS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initOS() throws InterruptedException {
        System.out.println("Initiallizing XablauOS...");

        Processo p1 = new Processo(200, 100);
        Processo p2 = new Processo(200, 300);
        
        memoria.print();
        
        memoria.addProcesso(p1);
        memoria.print();
        
        memoria.addProcesso(p2);
        memoria.print();
        
        memoria.removeProcesso(p2);
        memoria.print();
    }
}
