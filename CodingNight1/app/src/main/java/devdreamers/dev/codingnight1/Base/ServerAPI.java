package devdreamers.dev.codingnight1.Base;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by jlcs on 4/17/17.
 */
public interface ServerAPI {

    public static final String BASE_URL = "https://itunes.apple.com/";

    public static class Item{
        @SerializedName("song")
        public String song;

        public String getSong() {
            return song;
        }

        public void setSong(String song) {
            this.song = song;
        }
    }

    public static class Response{
        @SerializedName("jsonResponse")
        public String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }

    /**
     * Method which returns the whole response as a string, the expectation is get an Object as a response
     * @param lookUp
     * @param parameter
     * @return
     */
    @GET("search?{key1}={value1}")
    Observable<Response> getItems(@Path("key1") String lookUp, @Path("value1") String parameter);

}
