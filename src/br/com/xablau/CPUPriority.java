package br.com.xablau;

import java.util.Comparator;

public class CPUPriority extends CPU {
    public CPUPriority() {
    }

    @Override
    public long executeProcesses() throws InterruptedException {
        this.processes.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                return o1.getPriority() - o2.getPriority();
            }
        });

        return super.executeProcesses();
    }
}
