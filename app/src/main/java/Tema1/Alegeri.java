package Tema1;

import java.util.*;

public class Alegeri {
    private String id;
    private String nume;
    private StagiuAlegeri stagiu;

    public Alegeri(String id, String nume) {
        this.id = id;
        this.nume = nume;
        this.stagiu = StagiuAlegeri.NEINCEPUT;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public StagiuAlegeri getStagiu() {
        return stagiu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setStagiu(StagiuAlegeri stagiu) {
        this.stagiu = stagiu;
    }
}
