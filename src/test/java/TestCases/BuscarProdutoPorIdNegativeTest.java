package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class BuscarProdutoPorIdNegativeTest {
    @Test
    @DisplayName("Buscar Apenas Um Produto Por um Id - Negative")
    public void testDadoUsuarioQuandoTenhoCadastradoUmProdutoEBuscoPorUmIdEntaoObtenhoStatusCode404(){
        baseURI = ("https://dummyjson.com/products/0");
        basePath = "";

        given()
                .contentType(ContentType.JSON)
                .body("")
       .when()
                .get("")

       .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar apenas um produto por id negativo - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 404) {
            extent.createTest("Teste Buscar apenas um produto por id negativo - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar apenas um produto por id negativo, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar apenas um produto por id negativo - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar apenas um produto por id negativo, Fail!");
            extent.flush();
        }
    }
}
