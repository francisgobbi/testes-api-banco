package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class BuscarUsuarioParaAutenticacaoTest {

    @Test
    @DisplayName("Testes de API Rest buscar usuario para autenticacao")
    public void testDadoQueTenhoLoginESenhaQuandoLogoEntaoObtenhoTokenStatusCode201() {
        baseURI = ("https://dummyjson.com");
        basePath = "";

        given()
                .contentType(ContentType.JSON)

        .when()
                .get("/users")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI + "/users");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar usuario para autenticação - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste usuario para autenticação " + response.getStatusCode())
                    .log(Status.PASS, "Teste usuario para autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar usuario para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste usuario para autenticação, Fail!");
            extent.flush();
        }

    }
}

