package utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JSonUtil {


 private static ObjectMapper mapper;

 static {
     mapper =new ObjectMapper();
 }
    public static <T> T convertJsonToJava(String json,Class<T> cls){
        T javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            System.err.println("Json Datasını Java'ya donusturemedi"+ e.getMessage());
        }
        return  javaResult;
    }
}
