package ModulosAPI.CriacaoDeTokenParaAutenticacao;

import io.restassured.http.ContentType;
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

        String token = given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "    \"username\": \"kminchelle\",\n" +
                        "    \"password\": \"0lelplR\"\n" +
                        "}")
                .when()
                    .post("/auth/login")

                .then()
                    .log().all()
                    .assertThat()
                        .statusCode(201).toString();

        System.out.println(token);
    }
}
