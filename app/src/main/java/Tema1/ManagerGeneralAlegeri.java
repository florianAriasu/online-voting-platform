package Tema1;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ManagerGeneralAlegeri {
    FunctiiAuxiliare fAux = new FunctiiAuxiliare();

    public void CreareAlegeri(String id, String nume) {
        for (Alegeri alegeri : fAux.listaAlegeri) {
            if (alegeri.getId().equals(id)) {
                System.out.println("EROARE: Deja exista alegeri cu id " + id);
            }
        }

        Alegeri a = new Alegeri(id, nume);
        fAux.listaAlegeri.add(a);
        System.out.println("S-au creat alegerile " + a.getNume());
    }

    public void PornireAlegeri(String id) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        } else {
            for (Alegeri a : fAux.listaAlegeri) {
                if (a.getId().equals(id)) {
                    if (a.getStagiu() == StagiuAlegeri.IN_CURS) {
                        System.out.println("EROARE: Alegerile deja au inceput");
                    }
                }
            }

            for (Alegeri a : fAux.listaAlegeri) {
                if (a.getId().equals(id)) {
                    a.setStagiu(StagiuAlegeri.IN_CURS);
                    System.out.println("Au pornit alegerile " + a.getNume());
                }
            }
        }
    }

    public void AdaugaCircumscriptie(String id, String nume, String regiune) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        for (Circumscriptie c : fAux.listaCircumscriptii) {
            if (c.getNume().equals(nume)) {
                System.out.println("EROARE: Deja exista o circumscriptie cu numele " + c.getNume());
            }
        }

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        } else {
            for (Alegeri a : fAux.listaAlegeri) {
                if (a.getId().equals(id)) {
                    if (a.getStagiu() != StagiuAlegeri.IN_CURS) {
                        System.out.println("EROARE: Nu este perioada de votare");
                    }
                }
            }
        }

        Circumscriptie c = new Circumscriptie(id, nume, regiune);
        fAux.listaCircumscriptii.add(c);
        System.out.println("S-a adaugat circumscriptia " + c.getNume());
    }

    public void EliminaCircumscriptie(String id, String nume) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, nume);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + nume);
        }

        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                if (a.getStagiu() != StagiuAlegeri.IN_CURS) {
                    System.out.println("EROARE: Nu este perioada de votare");
                }
            }
        }

        for (Circumscriptie c : fAux.listaCircumscriptii) {
            if (c.getNume().equals(nume)) {
                fAux.listaCircumscriptii.remove(c);
                System.out.println("S-a sters circumscriptia " + c.getNume());
                break;
            }
        }
    }

    public void AdaugaCandidat(String id, String cnp, int varsta, String nume) {
        if (varsta < 35) {
            System.out.println("EROARE: Varsta invalida");
        }

        if (cnp.length() != 13) {
            System.out.println("EROARE: CNP invalid");
        }

        for (Candidat candidat : fAux.listaCandidati) {
            if (candidat.getCnp().equals(cnp)) {
                System.out.println("EROARE: Candidatul " + nume + " are deja acelasi CNP");
            }
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                if (a.getStagiu() != StagiuAlegeri.IN_CURS) {
                    System.out.println("EROARE: Nu este perioada de votare");
                }
            }
        }

        Candidat c = new Candidat(nume, cnp, varsta, id);
        fAux.listaCandidati.add(c);
        System.out.println("S-a adaugat candidatul " + c.getNume());
    }

    public void EliminaCandidat(String id, String cnp) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean existaCandidat = fAux.VerificaExistentaCandidat(fAux.listaCandidati, cnp);

        if (!existaCandidat) {
            System.out.println("EROARE: Nu exista un candidat cu CNP-ul " + cnp);
        }

        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                if (a.getStagiu() != StagiuAlegeri.IN_CURS) {
                    System.out.println("EROARE: Nu este perioada de votare");
                }
            }
        }

        for (Candidat candidat : fAux.listaCandidati) {
            if (candidat.getCnp().equals(cnp)) {
                fAux.listaCandidati.remove(candidat);
                System.out.println("S-a sters candidatul " + candidat.getNume());
                break;
            }
        }
    }

    public void AdauagaVotant(String id, String numeCircumscriptie, String cnp, int varsta, String neindemanatic, String nume) {
        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, numeCircumscriptie);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }

        if (cnp.length() != 13) {
            System.out.println("EROARE: CNP invalid");
        }

        if (varsta < 18) {
            System.out.println("EROARE: Varsta invalida");
        }

        for (Votant votant : fAux.listaVotanti) {
            if (votant.getCnp().equals(cnp)) {
                System.out.println("EROARE: Votantul " + nume + " are deja acelasi CNP");
            }
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                if (a.getStagiu() != StagiuAlegeri.IN_CURS) {
                    System.out.println("EROARE: Nu este perioada de votare");
                }
            }
        }

        Votant v = new Votant(nume, cnp, varsta, neindemanatic, numeCircumscriptie);
        fAux.listaVotanti.add(v);
        System.out.println("S-a adaugat votantul " + v.getNume());
    }

    public void ListareCandidatiAlegeri(String id) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        if (fAux.listaCandidati.isEmpty()) {
            System.out.println("GOL: Nu sunt candidati");
        }

        boolean esteStagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);

        if (esteStagiuNeinceput) {
            System.out.println("EROARE: Inca nu au inceput alegerile");
        }

        fAux.SortareCrescDupaCNP(fAux.listaCandidati);

        System.out.println("Candidatii:");
        for (Candidat candidat : fAux.listaCandidati) {
            if (candidat.getIdAlegeri().equals(id)) {
                System.out.println(candidat.getNume() + " " + candidat.getCnp() + " " + candidat.getVarsta());
            }
        }
    }

    public void ListareVotantiCircumscriptie(String id, String numeCircumscriptie) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, numeCircumscriptie);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }

        if (fAux.listaVotanti.isEmpty()) {
            System.out.println("GOL: Nu sunt votanti in " + numeCircumscriptie);
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);

        if (stagiuNeinceput) {
            System.out.println("EROARE: Inca nu au inceput alegerile");
        }

        System.out.println("Votantii din " + numeCircumscriptie + ":");
        for (Votant votant : fAux.listaVotanti) {
            if (votant.getNumeCircumscriptie().equals(numeCircumscriptie)) {
                System.out.println(votant.getNume() + " " + votant.getCnp() + " " + votant.getVarsta());
            }
        }
    }

    public void Votare(String id, String numeCircumscriptie, String cnpVotant, String cnpCandidat) {
        boolean votantInregistratCircumscriptie = false;

        for (Votant votant : fAux.listaVotanti) {
            if (votant.getCnp().equals(cnpVotant)) {
                if (votant.getNumeCircumscriptie().equals(numeCircumscriptie)) {
                    votantInregistratCircumscriptie = true;
                    break;
                }
            }
        }

        if (!votantInregistratCircumscriptie) {
            boolean existaVotantFraudulos = fAux.CautaVotantFraudulosDupaCNP(fAux.listaVotantiFraudulosi, cnpVotant);

            if (!existaVotantFraudulos) {
                int varsta = fAux.CautaVarstaDupaCNP(fAux.listaVotanti, cnpVotant);
                String nume = fAux.CautaNumeVotantDupaCNP(fAux.listaVotanti, cnpVotant);
                String neindemanatic = fAux.CautaNeindemanaticDupaCNP(fAux.listaVotanti, cnpVotant);

                Votant votant = new Votant(nume, cnpVotant, varsta, neindemanatic, numeCircumscriptie);
                fAux.listaVotantiFraudulosi.add(votant);
            }

            System.out.println("FRAUDA: Votantul cu CNP-ul " + cnpVotant + " a incercat sa comita o frauda. Votul a fost anulat");
        }

        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, numeCircumscriptie);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }

        boolean existaVotant = fAux.VerificaExistentaVotant(fAux.listaVotanti, cnpVotant);

        if (!existaVotant) {
            System.out.println("EROARE: Nu exista un votant cu CNP-ul " + cnpVotant);
        }

        boolean existaCandidat = fAux.VerificaExistentaCandidat(fAux.listaCandidati, cnpCandidat);

        if (!existaCandidat) {
            System.out.println("EROARE: Nu exista un candidat cu CNP-ul " + cnpCandidat);
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean esteStagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean esteStagiuTerminat = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.TERMINAT);

        if (esteStagiuNeinceput || esteStagiuTerminat) {
            System.out.println("EROARE: Nu este perioada de votare");
        }

        for (Votant votant : fAux.listaVotanti) {
            if (votant.getCnp().equals(cnpVotant)) {
                if (votant.getAVotatDeja()) {
                    boolean existaVotantFraudulos = fAux.CautaVotantFraudulosDupaCNP(fAux.listaVotantiFraudulosi, cnpVotant);

                    if (!existaVotantFraudulos) {
                        fAux.listaVotantiFraudulosi.add(votant);
                    }

                    System.out.println("FRAUDA: Votantul cu CNP-ul " + cnpVotant + " a incercat sa comita o frauda. Votul a fost anulat");
                }
            }
        }

        String numeCandidat = fAux.CautaNumeCandidatDupaCNP(fAux.listaCandidati, cnpCandidat);

        for (Votant votant : fAux.listaVotanti) {
            if (votant.getCnp().equals(cnpVotant)) {
                if (votant.getNeindemanatic().equals("DA")) {
                    if (numeCandidat == null) {
                        return;
                    }

                    votant.setAVotatDeja(true);
                    System.out.println(votant.getNume() + "a votat pentru " + numeCandidat);
                } else {
                    if (numeCandidat == null) {
                        return;
                    }

                    votant.setAVotatDeja(true);
                    System.out.println(votant.getNume() + " a votat pentru " + numeCandidat);
                    Vot vot = new Vot(id, numeCircumscriptie, cnpVotant, cnpCandidat);
                    fAux.listaVoturi.add(vot);
                }
                break;
            }
        }
    }

    public void OprireAlegeri(String id) {
        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean esteStagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);

        if (esteStagiuNeinceput) {
            System.out.println("EROARE: Nu este perioada de votare");
        }

        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                a.setStagiu(StagiuAlegeri.TERMINAT);
                System.out.println("S-au terminat alegerile " + a.getNume());
            }
        }
    }

    public void RaportVoturiPerCircumscriptie(String id, String numeCircumscriptie) {
        int numarVoturi = 0;

        for (Vot vot : fAux.listaVoturi) {
            if (vot.getIdAlegeri().equals(id) && vot.getNumeCircumscriptie().equals(numeCircumscriptie)) {
                numarVoturi++;
            }
        }

        if (numarVoturi == 0) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in " + numeCircumscriptie);
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, numeCircumscriptie);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean stagiuInCurs = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.IN_CURS);

        if (stagiuNeinceput || stagiuInCurs) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
        }

        for (Vot vot : fAux.listaVoturi) {
            if (vot.getIdAlegeri().equals(id) && vot.getNumeCircumscriptie().equals(numeCircumscriptie)) {
                fAux.listaVoturiPerCircumscriptie.add(vot);
            }
        }

        for (Vot vot : fAux.listaVoturiPerCircumscriptie) {
            for (Candidat candidat : fAux.listaCandidati) {
                if (vot.getCnpCandidat().equals(candidat.getCnp())) {
                    candidat.setNumarVoturi(candidat.getNumarVoturi() + 1);
                }
            }
        }

        fAux.SortareDescDupaNrVoturi(fAux.listaCandidatiPerCircumscriptie);

        System.out.println("Raport voturi " + numeCircumscriptie + ":");
        for (Candidat candidat : fAux.listaCandidatiPerCircumscriptie) {
            System.out.println(candidat.getNume() + " " + candidat.getCnp() + " - " + candidat.getNumarVoturi());
        }
    }

    public void RaportVoturiNational(String id) {
        int numarVoturi = 0;

        for (Vot vot : fAux.listaVoturi) {
            if (vot.getIdAlegeri().equals(id)) {
                numarVoturi++;
            }
        }

        if (numarVoturi == 0) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in Romania");
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean stagiuInCurs = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.IN_CURS);

        if (stagiuNeinceput || stagiuInCurs) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
        }

        for (Vot vot : fAux.listaVoturi) {
            if (vot.getIdAlegeri().equals(id)) {
                fAux.listaVoturiNational.add(vot);
            }
        }

        for (Vot vot : fAux.listaVoturiNational) {
            for (Candidat candidat : fAux.listaCandidati) {
                if (vot.getCnpCandidat().equals(candidat.getCnp())) {
                    candidat.setNumarVoturi(candidat.getNumarVoturi() + 1);
                }
            }
        }

        fAux.SortareDescDupaNrVoturi(fAux.listaCandidati);

        System.out.println("Raport voturi Romania:");
        for (Candidat candidat : fAux.listaCandidati) {
            System.out.println(candidat.getNume() + " " + candidat.getCnp() + " - " + candidat.getNumarVoturi());
        }
    }

    public void StergeAlegeri(String id) {
        for (Alegeri a : fAux.listaAlegeri) {
            if (a.getId().equals(id)) {
                fAux.listaAlegeri.remove(a);
                System.out.println("S-au sters alegerile " + a.getNume());
                break;
            }
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }
    }

    public void ListareAlegeri() {
        System.out.println("Alegeri:");
        for (Alegeri a : fAux.listaAlegeri) {
            System.out.println(a.getId() + " " + a.getNume());
        }

        if (fAux.listaAlegeri.isEmpty()) {
            System.out.println("GOL: Nu sunt alegeri");
        }
    }

    public void AnalizaDetaliataPerCircumscriptie(String id, String numeCircumscriptie) {
        int numarVoturi = 0;

        for (Vot vot : fAux.listaVoturi) {
            if (vot.getIdAlegeri().equals(id) && vot.getNumeCircumscriptie().equals(numeCircumscriptie)) {
                numarVoturi++;
            }
        }

        if (numarVoturi == 0) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in " + numeCircumscriptie);
        }

        boolean existaCircumscriptie = fAux.VerificaExistentaCircumscriptie(fAux.listaCircumscriptii, numeCircumscriptie);

        if (!existaCircumscriptie) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean stagiuInCurs = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.IN_CURS);

        if (stagiuNeinceput || stagiuInCurs) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }
    }

    public void AnalizaDetaliataNational(String id) {
        if (fAux.listaVoturi.isEmpty()) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in Romania");
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean stagiuInCurs = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.IN_CURS);

        if (stagiuNeinceput || stagiuInCurs) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }
    }

    public void RaportFraude(String id) {
        if (fAux.listaVotantiFraudulosi.isEmpty()) {
            System.out.println("GOL: Romanii sunt cinstiti");
        }

        boolean stagiuNeinceput = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.NEINCEPUT);
        boolean stagiuInCurs = fAux.VerificaStagiuVotare(fAux.listaAlegeri, StagiuAlegeri.IN_CURS);

        if (stagiuNeinceput || stagiuInCurs) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
        }

        boolean existaId = fAux.VerificaExistentaIdAlegeri(fAux.listaAlegeri, id);

        if (!existaId) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        }

        System.out.println("Fraude comise:");
        for (Votant votant : fAux.listaVotantiFraudulosi) {
            System.out.println("In " + votant.getNumeCircumscriptie() + ": " + votant.getCnp() + " " + votant.getNume());
        }
    }
}
