package ModulosAPI.BuscarApenasUmProdutoPorId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API Rest do modulo de Produto")
public class BuscarApenasUmProdutoPorIdTest {
    @Test
    @DisplayName("Buscar Apenas Um Produto Por Id")
    public void testValidarABuscaPorId(){
        baseURI = ("dummyjson.com/test");
        basePath = "";

        given()
          .contentType(ContentType.JSON)
          .body("")
                .when()
                .get("test")
                .then();


    }
}
