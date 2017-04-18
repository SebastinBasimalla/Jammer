package devdreamers.dev.codingnight1.filter;

import android.os.Bundle;

import devdreamers.dev.codingnight1.Base.App;
import devdreamers.dev.codingnight1.Base.ServerAPI;
import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Presenter of FilterActivity which interacts with the views,
 * Presenter perfom all the actions for the view as in MVP is required.
 * Created by jlcs on 4/17/17.
 */
public class FilterActivityPresenter extends RxPresenter<FilterActivity>{

    private static String TAG = FilterActivity.class.getSimpleName() + "#name";
    private static final int REQUEST_ITEMS = 1;
    private String name = "coldplay";

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        if (savedState!= null){
            name = savedState.getString(TAG);
        }
        //Getting latest cache
        restartableLatestCache(REQUEST_ITEMS,
                new Func0<Observable<ServerAPI.Response>>() {
                    @Override
                    public Observable<ServerAPI.Response> call() {
                        return App.getRestClient()
                                .getServerAPI()
                                .getItems("term",name)
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                },
                new Action2<FilterActivity, ServerAPI.Response>() {
                    @Override
                    public void call(FilterActivity filterActivity, ServerAPI.Response t) {
                        filterActivity.onResponse(t.response);
                    }
                },
                new Action2<FilterActivity, Throwable>() {
                    @Override
                    public void call(FilterActivity filterActivity, Throwable throwable) {
                        filterActivity.onNetworkError(throwable);
                    }
                });

        if(savedState == null){
            start(REQUEST_ITEMS);
        }
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        state.putString(TAG,name);
    }

    public void request(String name){
        this.name = name;
        start(REQUEST_ITEMS);
    }
}
