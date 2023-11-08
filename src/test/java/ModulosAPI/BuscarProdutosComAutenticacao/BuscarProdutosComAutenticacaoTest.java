package ModulosAPI.BuscarProdutosComAutenticacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static java.lang.Math.log;

@DisplayName("Testes de API Rest buscar Produtos com autenticacao")
public class BuscarProdutosComAutenticacaoTest {

    @Test
    @DisplayName("Buscar produtos com autenticacao")
    public void testValidarABuscaPorIdEntaoObtenhoStatusCode200(){
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
                        .log().all()
                        .assertThat()
                            .statusCode(200).toString();
    }
}
