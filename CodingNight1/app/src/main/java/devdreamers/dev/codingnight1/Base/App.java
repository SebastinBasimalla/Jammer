package devdreamers.dev.codingnight1.Base;

import android.app.Application;

import devdreamers.dev.codingnight1.Network.RestClient;

/**
 *  App class to run for the very first time the instance of the services
 * Created by jlcs on 4/17/17.
 */
public class App extends Application {

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
