package TestCases.BuscarProdutosComAutenticacao;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static java.lang.Math.log;

@DisplayName("Testes de API Rest buscar Produtos com autenticacao")
public class BuscarProdutosComAutenticacaoTest {

    @Test
    @DisplayName("Buscar produtos com autenticacao")
    public void testDadoUmUsuarioQuandoLogoNaApiEGeradoTokenEMostradosOsProdutosCadastradosEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/");
        basePath = "";

        String token = given()
                         .contentType(ContentType.JSON)
                         .body("{\n" +
                                   "    \"username\": \"kminchelle\",\n" +
                                   "    \"password\": \"0lelplR\"\n" +
                                   "}")
             .when()
                     .post("/auth/login")

             .then()
                        .extract()
                            .path("token");

              given()
                        .contentType(ContentType.JSON)
                        .header("Authorization",token)
              .when()
                        .get("auth/products")

              .then()
                        .log().all() ;

        Response response = given().contentType("application/json").get(baseURI + "auth/products");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar produtos com autenticação - " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar produtos com autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar produtos com autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar produtos com autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar produtos com autenticação, Fail!");
            extent.flush();
        }
    }
}

