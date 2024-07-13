import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda consultaMoneda(String baseCurrency, String targetCurrency){
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/171b045082952926dbd2c387/pair/"+baseCurrency+"/"+targetCurrency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direction)
                .build();

        try{
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Moneda.class);
        }catch (Exception e){
            throw new RuntimeException("No encontre esa moneda");
        }


    }

}
