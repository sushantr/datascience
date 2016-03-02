package mahout;


import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Date: 12/11/14
 * Time: 7:01 PM
 */
public class RecommenderDemo {


    public void recommendItem() throws IOException, TasteException {
        /**
         * Use DataModel to load data into
         */
        DataModel model = new FileDataModel(Helper.readFile());
        /*
        For finding similar members, we have to compare their interactions.
         */
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        /*
        Define which similar members we want to leverage for the recommender.
         */
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        //Feed the model, neighborhood and similarity graph into the recommender
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        /*
        Compute recommender for recommendations for each member.
         */
        for (Map.Entry mp : DataAccess.getMemberMap().entrySet()) {
            String memName = (String) mp.getValue();
            System.out.println("Recommendation for : " + memName);

            Helper.printLine();

            List<RecommendedItem> recommendations = recommender.recommend((Long) mp.getKey(), 3);
            for (RecommendedItem recommendation : recommendations) {
                System.out.println(memName + " | " + recommendation);
            }
        }
    }


}
