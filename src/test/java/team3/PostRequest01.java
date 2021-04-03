package team3;

import org.junit.Test;

public class PostRequest01 {
    /*
    When
      I send a POST Request to the Url http://dummy.restapiexample.com/api/v1/create
      by using the following Request Body {
                                     "name":"Ahmet Aksoy",
                                     "salary":"1000",
                                     "age":"18",
                                     "profile_image": ""
                                 }
    Then
      Status code is 200
      And response body should be like {
                                  "status": "success",
                                  "data": {
                                      "name": "Ahmet Aksoy",
                                      "salary": "1000",
                                      "age": "18",
                                      "profile_image": null
                                  },
                                  "message": "Successfully! Record has been added."
                            }
*/
   /*
   Genel olarak API ler authorization isterler (yetki)--- Post islemi icin
    */
    @Test
    public void post01(){

    }


}
