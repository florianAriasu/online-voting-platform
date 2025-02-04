package Tema1;

public abstract class Persoana {
    private String nume;
    private int varsta;
    private String cnp;

    public Persoana(String nume, String cnp, int varsta) {
        this.nume = nume;
        this.cnp = cnp;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}
