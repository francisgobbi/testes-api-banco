package ModulosAPI.CriacaoDeTokenParaAutenticacao;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest criar token para autenticação")
public class CriacaoDeTokenParaAutenticacaoTest {

    @Test
    @DisplayName("Criar Token")
    public void testDadoUsuarioQuandoEfetuoLoginNaApiEntaoObtenhoStatusCode201() {
        baseURI = ("https://dummyjson.com");
        basePath = "";

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"username\": \"kminchelle\",\n" +
                        "    \"password\": \"0lelplR\"\n" +
                        "}")
        .when()
                .post("/auth/login")

        .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI + "/auth/login");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Obter Token - " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste Obter Token - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Obter Token, Passed!");
            extent.flush();
        } else {
            extent.createTest("Obter Token - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste Obter Token, Fail!");
            extent.flush();
        }
    }
}


