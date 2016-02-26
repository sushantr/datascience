package mahout;

import org.junit.Test;

/**
 * Date: 12/11/14
 * Time: 8:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class EvaluateRecommenderTest {
    @Test
    public void testHoldOutTest() throws Exception {
        EvaluateRecommender sut = new EvaluateRecommender();

        sut.holdOutTest();
    }
}
