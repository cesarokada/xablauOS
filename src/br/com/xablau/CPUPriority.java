package br.com.xablau;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by guilherme on 19/01/16.
 */
public class CPUPriority extends CPU {
    public CPUPriority(List<Processo> processes) {
        super(processes);
    }

    @Override
    public void executeProcesses() throws InterruptedException {
        this.processes.sort(new Comparator<Processo>() {
            @Override
            public int compare(Processo o1, Processo o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        super.executeProcesses();
    }
}
