package ModulosAPI.BuscarStatusDaAplicacao;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


@DisplayName("Testes de API Rest buscar status da Aplicação")
public class BuscarStatusDaAplicacaoTest {
    @Test
    @DisplayName("Buscar status da Aplicação")
    public void testDadoUsuarioQuandoAcessoApiEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/test");
        basePath = "";

             given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"status\": \"ok\",\n" +
                        "    \"method\": \"GET\"\n" +
                        "}")
            .when()
                .get()

            .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI);
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/"+"Buscar o status da aplicação - "+ response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar o status da aplicação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar o status da aplicação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar o status da aplicação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste Criar Produto, Fail!");
            extent.flush();
        }
    }
}


