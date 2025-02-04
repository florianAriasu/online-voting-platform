package Tema1;

import java.util.*;

public class FunctiiAuxiliare {
    final List<Alegeri> listaAlegeri = new ArrayList<>();
    final List<Circumscriptie> listaCircumscriptii = new ArrayList<>();
    final List<Candidat> listaCandidati = new ArrayList<>();
    final List<Candidat> listaCandidatiPerCircumscriptie = new ArrayList<>();
    final List<Votant> listaVotanti = new ArrayList<>();
    final List<Votant> listaVotantiFraudulosi = new ArrayList<>();
    final List<Vot> listaVoturi = new ArrayList<>();
    final List<Vot> listaVoturiPerCircumscriptie = new ArrayList<>();
    final List<Vot> listaVoturiNational = new ArrayList<>();

    public void SortareCrescDupaCNP(List<Candidat> listaCandidati) {
        for (int i = 0; i < listaCandidati.size() - 1; i++) {
            for (int j = i + 1; j < listaCandidati.size(); j++) {
                if (listaCandidati.get(i).getNume().compareTo(listaCandidati.get(j).getNume()) > 0) {
                    Candidat aux = listaCandidati.get(i);
                    listaCandidati.set(i, listaCandidati.get(j));
                    listaCandidati.set(j, aux);
                }
            }
        }
    }

    public void SortareDescDupaNrVoturi(List<Candidat> listaCandidatiPerCircumscriptie) {
        for (int i = 0; i < listaCandidatiPerCircumscriptie.size() - 1; i++) {
            for (int j = i + 1; j < listaCandidatiPerCircumscriptie.size(); j++) {
                if (listaCandidatiPerCircumscriptie.get(i).getNumarVoturi() < listaCandidatiPerCircumscriptie.get(j).getNumarVoturi()) {
                    Candidat aux = listaCandidatiPerCircumscriptie.get(i);
                    listaCandidatiPerCircumscriptie.set(i, listaCandidatiPerCircumscriptie.get(j));
                    listaCandidatiPerCircumscriptie.set(j, aux);
                } else if (listaCandidatiPerCircumscriptie.get(i).getNumarVoturi() == listaCandidatiPerCircumscriptie.get(j).getNumarVoturi()) {
                    if (listaCandidatiPerCircumscriptie.get(i).getCnp().compareTo(listaCandidatiPerCircumscriptie.get(j).getCnp()) < 0) {
                        Candidat aux = listaCandidatiPerCircumscriptie.get(i);
                        listaCandidatiPerCircumscriptie.set(i, listaCandidatiPerCircumscriptie.get(j));
                        listaCandidatiPerCircumscriptie.set(j, aux);
                    }
                }
            }
        }
    }

    public String CautaNeindemanaticDupaCNP(List<Votant> listaVotanti, String cnp) {
        for (Votant votant : listaVotanti) {
            if (votant.getCnp().equals(cnp)) {
                return votant.getNeindemanatic();
            }
        }

        return null;
    }

    public String CautaNumeVotantDupaCNP(List<Votant> listaVotanti, String cnp) {
        for (Votant votant : listaVotanti) {
            if (votant.getCnp().equals(cnp)) {
                return votant.getNume();
            }
        }

        return null;
    }

    public int CautaVarstaDupaCNP(List<Votant> listaVotanti, String cnp) {
        for (Votant votant : listaVotanti) {
            if (votant.getCnp().equals(cnp)) {
                return votant.getVarsta();
            }
        }

        return 0;
    }

    public boolean CautaVotantFraudulosDupaCNP(List<Votant> listaVotantiFraudulosi, String cnp) {
        for (Votant votant : listaVotantiFraudulosi) {
            if (votant.getCnp().equals(cnp)) {
                return true;
            }
        }

        return false;
    }

    public String CautaNumeCandidatDupaCNP(List<Candidat> listaCandidati, String cnp) {
        for (Candidat candidat : listaCandidati) {
            if (candidat.getCnp().equals(cnp)) {
                return candidat.getNume();
            }
        }

        return null;
    }

    public boolean VerificaExistentaIdAlegeri(List<Alegeri> listaAlegeri, String idAlegeri) {
        for (Alegeri alegeri : listaAlegeri) {
            if (alegeri.getId().equals(idAlegeri)) {
                return true;
            }
        }

        return false;
    }

    public boolean VerificaExistentaCircumscriptie(List<Circumscriptie> listaCircumscriptii, String numeCircumscriptie) {
        for (Circumscriptie circumscriptie : listaCircumscriptii) {
            if (circumscriptie.getNume().equals(numeCircumscriptie)) {
                return true;
            }
        }

        return false;
    }

    public boolean VerificaExistentaCandidat(List<Candidat> listaCandidati, String cnpCandidat) {
        for (Candidat candidat : listaCandidati) {
            if (candidat.getCnp().equals(cnpCandidat)) {
                return true;
            }
        }

        return false;
    }

    public boolean VerificaExistentaVotant(List<Votant> listaVotanti, String cnpVotant) {
        for (Votant votant : listaVotanti) {
            if (votant.getCnp().equals(cnpVotant)) {
                return true;
            }
        }

        return false;
    }

    public boolean VerificaStagiuVotare(List<Alegeri> listaAlegeri, StagiuAlegeri stagiuAlegeri) {
        for (Alegeri alegeri : listaAlegeri) {
            if (alegeri.getStagiu() == stagiuAlegeri) {
                return true;
            }
        }

        return false;
    }
}
