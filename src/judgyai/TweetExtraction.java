/*
* Auteur : Lycia Mameri
*/
package judgyai;

import emoji4j.EmojiUtils;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Elle
 */
public class TweetExtraction {
    
    public static void tweetExt(String hashtag) throws ParseException, Exception{
        
        ArrayList<String> tweetsList = new ArrayList<String>();

        

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("zvYg9wMMOfJoEXcjipXS2zLJV")
                .setOAuthConsumerSecret("eNKIcT01e5tdAAfIxnaO79dxPNChqn80H75l5F9B7WS9el9LXP")
                .setOAuthAccessToken("860242806362787840-ccJCOsT1QPkc1JA6948Bgjy2onaZxu8")
                .setOAuthAccessTokenSecret("HjhH0d5GPPJBOZYJGIn93ixguyPzRyCkRQ0TxHI2LpaN7");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            Query query = new Query("#"+hashtag + " lang:en -RT -https");
            QueryResult result;
            int cmpt = 0;
            int nbQuery = 0;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                String tweetText;
                for (Status tweet : tweets) {
                    tweetText = EmojiUtils.shortCodify(tweet.getText());
                    tweetText = tweetText.replace("'", "");
                    tweetText = tweetText.replace("\n", "");
                    tweetText = tweetText.replace("\r", "");

                    tweetsList.add(tweetText);
                    cmpt++;
                }
                nbQuery++;
                //limitation nbr de tweets qui sortent
                if (tweetsList.size() > 50) {

                    break;
                }
            } while ((query = result.nextQuery()) != null);
            TweetToARFF.tweetToARFF(tweetsList);
            Classification.NaiveBayes("training.arff", "tweets.arff");
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }



    }
    
}
