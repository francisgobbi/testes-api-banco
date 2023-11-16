package TestCases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class CriarProdutoTest {
    @Test
    @DisplayName("Testes de API Rest criar produto")
    public void testDadoQuandoCrioUmProdutoEntaoObtenhoStatusCode201() {
        baseURI = ("https://dummyjson.com");
        basePath = "";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"title\": \"Perfume Oil\",\n" +
                        "  \"description\": \"Mega Discount, Impression of A...\",\n" +
                        "  \"price\": 13,\n" +
                        "  \"discountPercentage\": 8.4,\n" +
                        "   \"rating\": 4.26,\n" +
                        "   \"stock\": 65,\n" +
                        "   \"brand\": \"Impression of Acqua Di Gio\",\n" +
                        "   \"category\": \"fragrances\",\n" +
                        "   \"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumnail.jpg\"\n" +
                        "}")
        .when()
                .post("/products/add")

        .then()
                .log().all();


        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Adicionar uma produto - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste adicionar uma produto - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste adicionar uma produto, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste adicionar uma produto - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste adicionar uma produto, Fail!");
            extent.flush();
        }
    }
}
