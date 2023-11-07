package ModulosAPI.BuscarStatusDaAplicacao;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


@DisplayName("Testes de API Rest buscar status da Aplicação")
public class BuscarStatusDaAplicacaoTest {
    @Test
    @DisplayName("Buscar status da Aplicação")
    public void testValidarABuscaPorId(){
        baseURI = ("dummyjson.com/test");
        basePath = "";

        String statusAplicao = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"status\": \"ok\",\n" +
                        "    \"method\": \"GET\"\n" +
                        "}")
            .when()
                //.get()

            .then().statusCode(200).toString();
        Assertions.assertTrue(Boolean.parseBoolean(statusAplicao));

        System.out.println(statusAplicao);
    }

}
