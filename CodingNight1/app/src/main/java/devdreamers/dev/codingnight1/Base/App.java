package devdreamers.dev.codingnight1.Base;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  App class to run for the very first time the instance of the services
 * Created by jlcs on 4/17/17.
 */
public class App extends Application {

    private static Retrofit serverAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        serverAPI = new Retrofit.Builder()
                .baseUrl(ServerAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static Retrofit getServerAPI() {
        return serverAPI;
    }
}
