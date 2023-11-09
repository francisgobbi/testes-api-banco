package TestSuites;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class AllTests {
    @Test
    @DisplayName("Buscar Apenas Um Produto Por um Id")
    public void testDadoUsuarioQuandoTenhoCadastradoUmProdutoEBuscoPorUmIdEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/products/75");
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
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar apenas um produto por id - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste Buscar apenas um produto por id - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar apenas um produto por id, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar apenas um produto por id - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar apenas um produto por id, Fail!");
            extent.flush();
        }
    }

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

    @Test
    @DisplayName("Buscar todos produtos")
    public void testDadoUsuarioQuandoEfetuoLoginNaApiEtenhoTokenEntaoObtenhoStatusCode200() {
        baseURI = ("https://dummyjson.com");
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
                .log().all();

        Response response = given().contentType("application/json").get(baseURI + "auth/products");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar usuário para autenticação - " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 200) {
            extent.createTest("Teste buscar usuário para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar usuário para autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar usuário para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar usuário para autenticação, Fail!");
            extent.flush();
        }
    }
    @Test
    @DisplayName("Buscar usuario para autenticação")
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
                .get("/users")

                .then()
                .log().all();

        Response response = given().contentType("application/json").get(baseURI + "/auth/login");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar usuário para autenticação - " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste buscar usuário para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar usuário para autenticação, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar usuário para autenticação - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar usuário para autenticação, Fail!");
            extent.flush();
        }
    }

    @Test
    @DisplayName("Criar Token")
    public void testDadoUsuarioQuandoEfetuoLoginNaApiEntaoObtenhoStatusCode() {
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

    @Test
    @DisplayName("Criar Produto")
    public void testDadoUsuarioQuandoCadastroUmProdutoEntaoObtenhoStatusCode201() {
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

        Response response = given().contentType("application/json").get(baseURI+"/products/add");
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/"+"Criação de produto - "+ response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 201) {
            extent.createTest("Teste Criar Produto - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste Criar Produto, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste Criar Produto - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste Criar Produto, Fail!");
            extent.flush();
        }
    }

    @Test
    @DisplayName("Buscar Apenas Um Produto Por um Id")
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
        ExtentSparkReporter spark = new ExtentSparkReporter("Report/" + "Buscar apenas um produto por id - Status Code " + response.getStatusCode() + ".html");
        extent.attachReporter(spark);

        if (response.getStatusCode() == 404) {
            extent.createTest("Teste Buscar apenas um produto por id - Status Code " + response.getStatusCode())
                    .log(Status.PASS, "Teste buscar apenas um produto por id, Passed!");
            extent.flush();
        } else {
            extent.createTest("Teste buscar apenas um produto por id - Status Code " + response.getStatusCode())
                    .log(Status.FAIL, "Teste buscar apenas um produto por id, Fail!");
            extent.flush();
        }
    }

}
