import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class RestApi {

@Test
    public void successRegTest(){
Specifications.installSpecification(Specifications.requestSpec(),Specifications.responseSpecOK200());
    Integer code = 200;
    String type = "unknown";
    String message = "1649763480838";
    Registr user = new Registr(0, "Alex57","Alex", "Karpov", "123@mail.ru", "qwerty", "89108541456", 5);
    successReg successReg = given()
    .body(user)
    .when()
    .post("https://petstore.swagger.io/v2/user")
    .then().log().all()
    .extract().as(successReg.class);
    Assert.assertEquals(code,successReg.getCode());
    Assert.assertEquals(type,successReg.getType());
    Assert.assertEquals(message,successReg.getMessage());}
}