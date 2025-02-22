package TestCases;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class CriacaoDeTokenParaAutenticacaoTest {

    @Test
    @DisplayName("Testes de API Rest criar token para autenticação")
    public void testDadoQueTenhoLoginESenhaQuandoLogarEntaoObtenhoTokenStatusCode201() {
        baseURI = ("https://dummyjson.com/");
        basePath="";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"kminchelle\",\n" +
                        "    \"password\": \"0lelplR\"\n" +
                        "}")
        .when()
                .post("auth/login")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar token para autenticação - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste busca token para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste token para autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste token para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste token para autenticação, Fail!");
            extent.flush();
        }
    }
}

