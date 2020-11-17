package database.apis;

import com.google.gson.Gson;
import database.apis.geoDBAPI.City;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Objects;

/**
 * @author Marius on 2020-11-16.
 * @version %I%, %G%
 */
public class APIHandler {

    public static City getCity() throws Exception {
        City city;
        try {
            OkHttpClient client = new OkHttpClient();
            Dotenv dotenv = Dotenv.load();

            Request request = new Request.Builder()
                    .url("https://wft-geo-db.p.rapidapi.com/v1/geo/cities?countryIds=SE&minPopulation=60000&sort=population")
                    .get()
                    .addHeader("x-rapidapi-key", dotenv.get("API_GEO_DB_KEY"))
                    .addHeader("x-rapidapi-host", "wft-geo-db.p.rapidapi.com")
                    .build();

            Response response = client.newCall(request).execute();

            if (response.code() != 200) {
                throw new RuntimeException("HttpResponseCode: " + response.code());
            } else {
                Gson gson = new Gson();
                city = gson.fromJson(Objects.requireNonNull(response.body()).string(), City.class);
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(e.toString());
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return city;
    }

}
