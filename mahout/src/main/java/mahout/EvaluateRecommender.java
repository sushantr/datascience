package mahout;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.IOException;

/**
 * Date: 12/11/14
 * Time: 8:26 PM
 */
public class EvaluateRecommender implements RecommenderBuilder {

    /**
     * Check how much the recommender misses the real interaction strength on average.
     * @throws IOException
     * @throws TasteException
     */
    public void holdOutTest() throws IOException, TasteException {

        DataModel model = new FileDataModel(Helper.readFile());//new File(AppConstants.TEST_FILE));
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        RecommenderBuilder builder = new EvaluateRecommender();
        double result;
        for(int i = 0; i < 5; i++){
            result = evaluator.evaluate(builder, null, model, 0.9, 1.0);
            System.out.println(result);
        }
    }

    /**
     * This will do the hold-out test
     * Start by partitioning the dataset into two sets:
     *      a trainingset consisting of 90% of the data and
     *      a testset consisting of 10%.
     * Then train recommender using the training set and observe its predictions for the unknown interactions in the testset
     * @param dataModel
     * @return
     * @throws TasteException
     */
    @Override
    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
            UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
            UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);
            return new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
    }
}

