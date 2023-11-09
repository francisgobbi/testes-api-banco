package ModulosAPI.CriarProduto;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@DisplayName("Testes de API Rest criar produto")
public class CriarProdutoTest {
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
                .log().all()
                    .assertThat()
                        .statusCode(201).toString();
    }

}
