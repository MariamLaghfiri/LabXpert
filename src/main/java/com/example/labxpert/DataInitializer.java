package com.example.labxpert;

import com.example.labxpert.entites.*;
import com.example.labxpert.entites.Enum.*;
import com.example.labxpert.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@SpringBootApplication
public class DataInitializer implements CommandLineRunner {
    private final UtilisateurRepository utilisateurRepository;
    private final AnalyseRepository analyseRepository;
    private final AnalysePreRepository analysePreRepository;
    private final EchantillonRepository echantillonRepository;
    private final PatientRepository patientRepository;
    private final RapportStatiqueRepository rapportStatiqueRepository;
    private final ReactifRepository reactifRepository;
    private final ResultatRepository resultatRepository;
    private final TestRepository testRepository;
    private final TestReactifRepository testReactifRepository;
    private final TestPreRepository testPreRepository;

    @Autowired
    public DataInitializer(UtilisateurRepository utilisateurRepository,TestPreRepository testPreRepository, TestReactifRepository testReactifRepository, TestRepository testRepository, ResultatRepository resultatRepository, ReactifRepository reactifRepository, AnalyseRepository analyseRepository, AnalysePreRepository analysePreRepository,EchantillonRepository echantillonRepository,PatientRepository patientRepository, RapportStatiqueRepository rapportStatiqueRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.testPreRepository = testPreRepository;
        this.testReactifRepository = testReactifRepository;
        this.testRepository = testRepository;
        this.resultatRepository = resultatRepository;
        this.reactifRepository = reactifRepository;
        this.rapportStatiqueRepository = rapportStatiqueRepository;
        this.patientRepository = patientRepository;
        this.echantillonRepository = echantillonRepository;
        this.analysePreRepository = analysePreRepository;
        this.analyseRepository = analyseRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        // Create new Patient
        Patient patient = new Patient("John", "Doe", new Date(), Sexe.HOMME, "123456789", "123 Main St", null, null);
        patientRepository.save(patient);

        // Create new Utilisateur
        Utilisateur utilisateur = new Utilisateur("admin", "password", Role.ADMINISTRATEUR, "123456789", "456 Admin St", null);
        utilisateurRepository.save(utilisateur);

        // Create new AnalysePre
        AnalysePre analysePre = new AnalysePre("Blood Test", Branches.HEMATOLOGIE, null, null);
        analysePreRepository.save(analysePre);

        // Create new Analyse
        Analyse analyse = new Analyse(LocalDateTime.now(), LocalDateTime.now().plusHours(2), "Comments", utilisateur, patient, analysePre, null);
        analyseRepository.save(analyse);

        // Create new TestPre
        TestPre testPre = new TestPre("Test Name", 10.0, 20.0, analysePre, null);
        testPreRepository.save(testPre);

        // Create new Resultat
        Resultat resultat = new Resultat(null, 15.02, "ml", StatutR.NORMAL);
        resultatRepository.save(resultat);

        // Create new Test
        Test test = new Test(null, null, analyse, resultat, null);
        testRepository.save(test);

        // Create new Echantillon
        Echantillon echantillon = new Echantillon(patient, "Blood Sample", new Date(), StatutE.EN_ATTENTE, null);
        echantillonRepository.save(echantillon);

        // Create new RapportStatique
        RapportStatique rapportStatique = new RapportStatique("Monthly Report", "January 2024");
        rapportStatiqueRepository.save(rapportStatique);

        // Create new Reactif
        Reactif reactif = new Reactif("Test Reagent", "Description", 100.0, new Date(), "Supplier Inc.", null);
        reactifRepository.save(reactif);

        // Create new TestReactif
        TestReactif testReactif = new TestReactif(test, reactif, 50.0);
        testReactifRepository.save(testReactif);

    }
}
