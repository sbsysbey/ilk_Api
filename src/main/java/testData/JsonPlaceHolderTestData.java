package testData;
import java.util.HashMap;
import java.util.Map;
public class JsonPlaceHolderTestData {
    /*
    {
    "userId": 7,
    "id": 123,
    "title": "esse et quis iste est earum aut impedit",
    "completed": false
     }
     */
    public Map<String, Object> setUpDataMap() {
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("userId", 7);
        expectedDataMap.put("id", 123);
        expectedDataMap.put("title", "esse et quis iste est earum aut impedit");
        expectedDataMap.put("completed", false);
        expectedDataMap.put("Status Code", 200);
        expectedDataMap.put("Server", "cloudflare");
        return expectedDataMap;
    }
    public String setUpObjectMapper() {
        String expectedJson = "{\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 123,\n" +
                "    \"title\": \"esse et quis iste est earum aut impedit\",\n" +
                "    \"completed\": false\n" +
                "     }";
        return expectedJson;
    }
}