package com.arunsoorya.myresearch.mvp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arunsoorya.myresearch.R;


public class MVCActivity extends AppCompatActivity implements MainMVP.RequiredViewOps {

    protected final String TAG = getClass().getSimpleName();
    // Responsible to maintain the Objects state
    // during changing configuration
    private final StateMaintainer mStateMaintainer = new StateMaintainer(this.getFragmentManager(), TAG);
    // Presenter operations
    private MainMVP.PresenterOps mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        startMVPOps();
    }

    /**
     * Initialize and restart the Presenter.
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void startMVPOps() {
        try {
            if (mStateMaintainer.firstTimeIn()) {
                Log.d(TAG, "onCreate() called for the first time");
                initialize(this);
            } else {
                Log.d(TAG, "onCreate() called more than once");
                reinitialize(this);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            Log.d(TAG, "onCreate() " + e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialize relevant MVP Objects.
     * Creates a Presenter instance, saves the presenter in {@link StateMaintainer}
     */
    private void initialize(MainMVP.RequiredViewOps view) throws InstantiationException, IllegalAccessException {
        mPresenter = new MainPresenter(view);
        mStateMaintainer.put(MainMVP.PresenterOps.class.getSimpleName(), mPresenter);
    }

    /**
     * Recovers Presenter and informs Presenter that occurred a config change.
     * If Presenter has been lost, recreates a instance
     */
    private void reinitialize(MainMVP.RequiredViewOps view) throws InstantiationException, IllegalAccessException {
        mPresenter = mStateMaintainer.get(MainMVP.PresenterOps.class.getSimpleName());

        if (mPresenter == null) {
            Log.w(TAG, "recreating Presenter");
            initialize(view);
        } else {
            mPresenter.onConfigurationChanged(view);
        }
    }


    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showAlert(String msg) {

    }
}
