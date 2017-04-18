package devdreamers.dev.codingnight1.Network;

import devdreamers.dev.codingnight1.Base.ServerAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jlcs on 4/17/17.
 */
public class RestClient {

    public static final String BASE_URL = "https://itunes.apple.com/";
    private ServerAPI serverAPI;

    public RestClient() {

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serverAPI = restAdapter.create(ServerAPI.class);
    }

    public ServerAPI getServerAPI() {
        return serverAPI;
    }
}
