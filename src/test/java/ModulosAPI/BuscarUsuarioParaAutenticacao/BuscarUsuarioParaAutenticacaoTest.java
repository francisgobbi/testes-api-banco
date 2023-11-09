package ModulosAPI.BuscarUsuarioParaAutenticacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest buscar usuario para autenticacao")
public class BuscarUsuarioParaAutenticacaoTest {

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
                .post("/auth/login")

       .then()
                .log().all()
                .assertThat()
                    .statusCode(201).toString();
    }
}
