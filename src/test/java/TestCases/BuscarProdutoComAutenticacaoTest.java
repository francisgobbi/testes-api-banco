package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BuscarProdutoComAutenticacaoTest {

    @Test
    @DisplayName("Buscar Produto com Autenticação")
    public void testDadoUsuarioQuandoObtenhoTokenEBuscoPorumProdutoEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/");
        basePath = "";

        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"username\": \"kminchelle\",\n" +
                        "  \"password\": \"0lelplR\"\n" +
                        "}")
                .when()
                .post("/auth/login")

                .then()
                 .extract()
                 .path("token");

        given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
        .when()
                .get("/auth/products")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar produto com autenticação - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar produto com autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar produto com autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar apenas um produto por id - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar apenas um produto por id, Fail!");
            extent.flush();
        }
    }

}
