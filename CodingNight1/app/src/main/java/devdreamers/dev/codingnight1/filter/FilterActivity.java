package devdreamers.dev.codingnight1.filter;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import devdreamers.dev.codingnight1.R;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;
import rx.functions.Action1;

/**
 * Activity which is going to perform just the view Interaction with the user
 * Created by jlcs on 4/17/17.
 */
@RequiresPresenter(FilterActivityPresenter.class)
public class FilterActivity extends NucleusActivity<FilterActivityPresenter> {

    //This is how ButterKnife bind the views for ya!
    @BindView(R.id.textView)
    TextView mSearchField;
    @BindView(R.id.button)
    TextView mButton;
    @BindView(R.id.responsePanel)
    Button   mBtnSearch;

    private String TAG = FilterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting up the view
        setContentView(R.layout.filter_layout);
        //binfing the views
        ButterKnife.bind(this);
        setupListeners();
    }

    private void setupListeners() {

        RxView.clicks(mButton).subscribe(new Action1<Object>() {
            @Override
            public void call(Object aVoid) {
                getPresenter().request(mSearchField.getText().toString());
            }
        });


    }


    public void onResponse(String response) {
        Log.d(TAG, "onResponse: "+ response);

    }

    public void onNetworkError(Throwable throwable) {
        Log.e(TAG, "onNetworkError: "+throwable.getMessage().toString(),throwable);

    }
}
