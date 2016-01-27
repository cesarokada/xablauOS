package br.com.xablau;

public class MemoryLRU extends Memory {

	public MemoryLRU(double size) {
		super(size);
	}
	
	@Override
	public TrechoMemoria getAvailableMemory(double processSize) {
		TrechoMemoria trechoToRemove = null;

		for (TrechoMemoria trecho : memory) {
			if (trecho.isDisponivel() && trecho.getTamanho() >= processSize)
				return trecho;

			if (trechoToRemove == null && !trecho.getProcesso().isRunning() 
					|| trecho.getLastUse().compareTo(trechoToRemove.getLastUse()) < 0) {
				trechoToRemove = trecho;
			}
		}

		return trechoToRemove;
	}
	
}
