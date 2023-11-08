package ModulosAPI.BuscarTodosOsProdutos;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest buscar todos produtos")
public class BuscarTodosOsProdutosTest {

    @Test
    @DisplayName("Buscar todos produtos")
    public void testBuscarTodosProdutos() {
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
        given()
                        .contentType(ContentType.JSON)
                        .body(token)

                .when()
                        .get("auth/products")
                .then()
                        .extract()
                                .path("products");

    }

}
