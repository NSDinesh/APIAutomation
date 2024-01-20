package reqres.payload;

import java.util.HashMap;
import java.util.Map;

public class CreateUsersPayload {

    public static Map<String,String> get(String name, String job) {
        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("name",name);
        userDetails.put("job",job);

        return userDetails;
    }


}
