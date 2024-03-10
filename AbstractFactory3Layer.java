//Abstract factory 3 layers

interface Ram {
    void process();
}

class Ddr2 implements Ram {
    public void process() {
        // Implementation for Ddr2
    }
}

class Ddr1 implements Ram {
    public void process() {
        // Implementation for Ddr1
    }
}

interface Storage {
    void process();
}

class S1 implements Storage {
    public void process() {
        // Implementation for S1
    }
}

class S2 implements Storage {
    public void process() {
        // Implementation for S2
    }
}

interface CPU {
    Ram processRam();
    Storage processStorage();
}

class Intel implements CPU {
    public Ram processRam() {
        return new Ddr2();
    }

    public Storage processStorage() {
        return new S1();
    }
}

class Amd implements CPU {
    public Ram processRam() {
        return new Ddr1();
    }

    public Storage processStorage() {
        return new S2();
    }
}

interface GPU {
    Ram processRam();
    Storage processStorage();
}

class Nvidia implements GPU {
    public Ram processRam() {
        return new Ddr1();
    }

    public Storage processStorage() {
        return new S1();
    }
}

class Amdg implements GPU {
    public Ram processRam() {
        return new Ddr2();
    }

    public Storage processStorage() {
        return new S2();
    }
}

interface Computer {
    CPU processCPU();
    GPU processGPU();
}

class HighPerf implements Computer {
    public CPU processCPU() {
        return new Intel();
    }

    public GPU processGPU() {
        return new Nvidia();
    }
}

class LowPerf implements Computer {
    public CPU processCPU() {
        return new Amd();
    }

    public GPU processGPU() {
        return new Amdg();
    }
}

class ClientCode {
    public static void main(String[] args) {
        Computer hf = new HighPerf();
        CPU i = hf.processCPU();
        GPU g = hf.processGPU();
        Ram r = i.processRam();
        Storage s = i.processStorage();
        r.process();
        s.process();
    }
}
