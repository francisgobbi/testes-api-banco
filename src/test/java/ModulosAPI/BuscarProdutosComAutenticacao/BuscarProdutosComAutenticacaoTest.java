package ModulosAPI.BuscarProdutosComAutenticacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest buscar Produtos com autenticacao")
public class BuscarProdutosComAutenticacaoTest {

    @Test
    @DisplayName("Buscar produtos com autenticacao")
    public void testValidarABuscaPorIdEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/auth/products");
        basePath = "";

              given()
                        .contentType(ContentType.JSON)
                        .body("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTUsInVzZXJuYW1lIjoia21pbmNoZWxsZSIsImVtYWlsIjoia21pbmNoZWxsZUBxcS5jb20iLCJmaXJzdE5hbWUiOiJKZWFubmUiLCJsYXN0TmFtZSI6IkhhbHZvcnNvbiIsImdlbmRlciI6ImZlbWFsZSIsImltYWdlIjoiaHR0cHM6Ly9yb2JvaGFzaC5vcmcvYXV0cXVpYXV0LnBuZyIsImlhdCI6MTY5OTM5ODMwNCwiZXhwIjoxNjk5NDAxOTA0fQ.GFLdCZbs6Qhx6qWrByiI-SnwzcTnmZ17tYky-pepc-U")
              .when()
                        .get()

              .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200).toString();
    }
}
