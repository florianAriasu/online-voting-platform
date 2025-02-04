package Tema1;

public class Votant extends Persoana {
    private String neindemanatic;
    private String numeCircumscriptie;
    private boolean aVotatDeja = false;

    public Votant(String nume, String cnp, int varsta, String neindemanatic, String numeCircumscriptie) {
        super(nume, cnp, varsta);
        this.neindemanatic = neindemanatic;
        this.numeCircumscriptie = numeCircumscriptie;
    }

    public String getNeindemanatic() {
        return neindemanatic;
    }

    public String getNumeCircumscriptie() {
        return numeCircumscriptie;
    }

    public boolean getAVotatDeja() {
        return aVotatDeja;
    }

    public void setNeindemanatic(String neindemanatic) {
        this.neindemanatic = neindemanatic;
    }

    public void setNumeCircumscriptie(String numeCircumscriptie) {
        this.numeCircumscriptie = numeCircumscriptie;
    }

    public void setAVotatDeja(boolean aVotatDeja) {
        this.aVotatDeja = aVotatDeja;
    }
}
