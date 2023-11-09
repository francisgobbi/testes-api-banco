package ModulosAPI.BuscarApenasUmProdutoPorId;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest modulo de Produto")
public class BuscarApenasUmProdutoPorIdTest {

    @Test
    @DisplayName("Buscar Apenas Um Produto Por um Id")
    public void testDadoUsuarioQuandoTenhoCadastradoUmProdutoEBuscoPorUmIdEntaoObtenhoStatusCode200(){
        baseURI = ("https://dummyjson.com/products/");
        basePath = "";

       given()
              .contentType(ContentType.JSON)
              .body("")
       .when()
             .get("80")

       .then()
                .log().all()
                .assertThat()
                    .statusCode(200).toString();
    }
}
