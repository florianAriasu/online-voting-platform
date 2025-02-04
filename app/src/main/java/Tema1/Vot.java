package Tema1;

public class Vot {
    String idAlegeri;
    String numeCircumscriptie;
    String cnpVotant;
    String cnpCandidat;

    public Vot(String idAlegeri, String numeCircumscriptie, String cnpVotant, String cnpCandidat) {
        this.idAlegeri = idAlegeri;
        this.numeCircumscriptie = numeCircumscriptie;
        this.cnpVotant = cnpVotant;
        this.cnpCandidat = cnpCandidat;
    }

    public String getIdAlegeri() {
        return idAlegeri;
    }

    public String getNumeCircumscriptie() {
        return numeCircumscriptie;
    }

    public String getCnpVotant() {
        return cnpVotant;
    }

    public String getCnpCandidat() {
        return cnpCandidat;
    }

    public void setIdAlegeri(String idAlegeri) {
        this.idAlegeri = idAlegeri;
    }

    public void setNumeCircumscriptie(String numeCircumscriptie) {
        this.numeCircumscriptie = numeCircumscriptie;
    }

    public void setCnpVotant(String cnpVotant) {
        this.cnpVotant = cnpVotant;
    }

    public void setCnpCandidat(String cnpCandidat) {
        this.cnpCandidat = cnpCandidat;
    }
}
