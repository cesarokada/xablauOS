package br.com.xablau;


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
        Thread.sleep(5000);

        System.out.println("Initiallizing drivers...");
        Thread.sleep(5000);

        Processo processo = new Processo(300);
        processo.run();
    }
}
