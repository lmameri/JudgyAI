/*
* Auteur : Lycia Mameri
*/

package judgyai;


import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;

import weka.core.Instances;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;


public class Classification {
    protected static String conclusion;
    public static Vector<String> NaiveBayes(String file_training, String file_to_analyse) throws FileNotFoundException, IOException,Exception {
        //filtre
        StringToWordVector filter = new StringToWordVector();

        Classifier naive = new NaiveBayes();
        
        //VECTOR DE STRING A RETOURNER POUR INTERFACE GRAPHIQUE
        Vector<String> toReturn = new Vector<String>();


        Instances train = new Instances(new BufferedReader(new FileReader(file_training)));
        int lastIndex = train.numAttributes() - 1;
        train.setClassIndex(lastIndex);
        filter.setInputFormat(train);
        train = Filter.useFilter(train, filter);

        Instances tweets = new Instances(new BufferedReader(new FileReader(file_to_analyse)));
        tweets.setClassIndex(lastIndex);
        Instances test2 = Filter.useFilter(tweets, filter);
        naive.buildClassifier(train);

        
        
        //Creation fichier resulat de la classification
        try {
            PrintWriter writer = new PrintWriter("resultats.txt", "UTF-8");
            double nbPos=0;
            double nbNeg=0;
            
        for(int i=0; i<test2.numInstances(); i++) {
            writer.println(tweets.instance(i));
            double index = naive.classifyInstance(test2.instance(i));
            String className = train.attribute(0).value((int)index);
            toReturn.add(className + "\r\n");
            writer.println(className);
            if ("positif".equals(className)){nbPos++;}
            if ("negatif".equals(className)){nbNeg++;}
        }
        conclusion="\nGlobalement: sur "+test2.numInstances()+" tweets: "+(int)nbPos+" sont positifs et "+(int)nbNeg+" sont négatifs.";
        double percentPos = (nbPos/(test2.numInstances()))*100;
        double percentNeg = 100-percentPos;
        if (percentPos>60){
        conclusion+=(" La majorité est positive.");
        }else if (percentPos<40){
        conclusion+=(" La majorité est négative");
        }else{
        conclusion+=(" Les avis divergent trop pour trouver une majorité");
        }
        writer.println(conclusion);
        writer.close();
        } catch (IOException e) {
            System.out.println("Erreur avec l'ouverture du fichier resultats.txt");
        }
        return toReturn;
    }
    



}
