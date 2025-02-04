package Tema1;

import java.util.*;

public class Circumscriptie {
    private String id;
    private String nume;
    private String regiune;

    public Circumscriptie(String id, String nume, String regiune) {
        this.id = id;
        this.nume = nume;
        this.regiune = regiune;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getRegiune() {
        return regiune;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setRegiune(String regiune) {
        this.regiune = regiune;
    }
}
