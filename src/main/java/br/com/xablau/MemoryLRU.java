package br.com.xablau;

public class MemoryLRU extends Memory {

	public MemoryLRU(double size) {
		super(size);
	}

	@Override
	public TrechoMemoria getAvailableMemory(double processSize) {
		TrechoMemoria trechoToRemove = null;

		for (TrechoMemoria trecho : memory) {
			if (trecho.isDisponivel() && trecho.getTamanho() >= processSize){
                            System.out.println("Alocando memória");
                            return trecho;
                        }

			if (trecho.getTamanho() >= processSize) {
				if (trechoToRemove == null && processIsNotRunning(trecho) || processUsedMoreRecently(trechoToRemove, trecho)) {
					trechoToRemove = trecho;
				}
			}
		}

                System.out.println("Liberando memória");
		return trechoToRemove;
	}

	private boolean processIsNotRunning(TrechoMemoria trecho) {
		return trecho.getProcesso() != null && !trecho.getProcesso().isRunning();
	}

	private boolean processUsedMoreRecently(TrechoMemoria trechoToRemove, TrechoMemoria trecho) {
		return trecho.getLastUse().compareTo(trechoToRemove.getLastUse()) < 0;
	}

}
