package Tema1;

public class Candidat extends Persoana {
    private String idAlegeri;
    private int numarVoturi;

    public Candidat(String nume, String cnp, int varsta, String idAlegeri) {
        super(nume, cnp, varsta);
        this.idAlegeri = idAlegeri;
        this.numarVoturi = 0;
    }

    public String getIdAlegeri() {
        return idAlegeri;
    }

    public int getNumarVoturi() {
        return numarVoturi;
    }

    public void setIdAlegeri(String idAlegeri) {
        this.idAlegeri = idAlegeri;
    }

    public void setNumarVoturi(int numarVoturi) {
        this.numarVoturi = numarVoturi;
    }
}
