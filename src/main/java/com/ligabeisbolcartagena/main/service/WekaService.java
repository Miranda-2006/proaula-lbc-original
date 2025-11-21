package com.ligabeisbolcartagena.main.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import weka.classifiers.Classifier;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

@Service
public class WekaService {

    private Classifier modelo;
    private Instances estructura;

    @PostConstruct
    public void init() {
        try {
            // Cargar estructura del ARFF
            InputStream arff = getClass().getResourceAsStream("/weka/lbc-dataset.arff");
            BufferedReader reader = new BufferedReader(new InputStreamReader(arff));
            estructura = new Instances(reader);
            estructura.setClassIndex(estructura.numAttributes() - 1);

            // Cargar el modelo
            InputStream modelFile = getClass().getResourceAsStream("/weka/lbcmodeltree.model");
            modelo = (Classifier) weka.core.SerializationHelper.read(modelFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String predecir(String localVisitante,
                           double rachaUlt3,
                           double promFavor,
                           double promContra,
                           String rivalFuerza) throws Exception {

        Instance inst = new DenseInstance(estructura.numAttributes());
        inst.setDataset(estructura);

        inst.setValue(0, localVisitante);
        inst.setValue(1, rachaUlt3);
        inst.setValue(2, promFavor);
        inst.setValue(3, promContra);
        inst.setValue(4, rivalFuerza);

        double r = modelo.classifyInstance(inst);
        String clase = estructura.classAttribute().value((int) r);
        return clase.trim(); // evita espacios extra del ARFF
    }
}
