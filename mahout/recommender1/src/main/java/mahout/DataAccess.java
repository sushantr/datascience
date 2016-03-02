package mahout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 2/20/2015.
 */
public class DataAccess {
    public static Map<Long, String> getMemberMap() {
        Map<Long, String> memberMap = new HashMap<Long, String>();

        memberMap.put(1l, "Member A");
        memberMap.put(2l, "Member B");
        memberMap.put(3l, "Member C");
        memberMap.put(4l, "Member D");

        return memberMap;
    }
}
