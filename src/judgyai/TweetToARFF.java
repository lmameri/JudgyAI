/*
* Auteur : Lycia Mameri
*/

package judgyai;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;


public class TweetToARFF {

    public static void tweetToARFF(ArrayList<String> tweets) throws ParseException {

        try {
            PrintWriter writer = new PrintWriter("tweets.arff", "UTF-8");
            writer.println("@relation tweets\n");
            writer.println("@attribute text string");
            writer.println("@attribute class {negatif,positif}\n");
            writer.println("@data");
            for (int i=0;i<tweets.size();i++){
                writer.println("'"+tweets.get(i)+"',?");
            }
            
            writer.close();
        } catch (IOException e) {
            System.out.println("Erreur avec l'ouverture du fichier tweets.arff");
        }

    }

}
