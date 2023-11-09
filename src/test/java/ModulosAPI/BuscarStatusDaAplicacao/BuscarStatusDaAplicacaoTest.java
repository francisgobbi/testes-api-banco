package ModulosAPI.BuscarStatusDaAplicacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


@DisplayName("Testes de API Rest buscar status da Aplicação")
public class BuscarStatusDaAplicacaoTest {
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
                .log().all()
                .assertThat()
                    .statusCode(200).toString();
    }

}
