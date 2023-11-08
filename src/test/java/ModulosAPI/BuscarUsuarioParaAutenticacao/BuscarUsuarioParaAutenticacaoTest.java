package ModulosAPI.BuscarUsuarioParaAutenticacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest buscar usuario para autenticacao")
public class BuscarUsuarioParaAutenticacaoTest {

    @Test
    @DisplayName("Buscar usuario para autenticação")
    public void testBuscarUsuarioParaAutenticacao() {
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


        System.out.println(token);
    }
}
