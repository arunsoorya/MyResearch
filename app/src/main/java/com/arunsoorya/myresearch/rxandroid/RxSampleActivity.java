package com.arunsoorya.myresearch.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.arunsoorya.myresearch.R;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RxSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_sample);



        List<String> names = Arrays.asList("Didiet", "Doni", "Asep", "Reza",
                "Sari", "Rendi", "Akbar");



//        Observable<MyObject> objectObservable = Observable.

        Observable<String> helloObservable = Observable.from(names);

        helloObservable.subscribe( new Action1<String>() {
            @Override
            public void call( String s ) {
                String greet = "Sub 1 on " +
                        ": Hello " + s + "!";
                System.out.println(greet);
            }
        });
helloObservable.subscribe(goTO());

        Subscription subscription = Observable.empty()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(10, TimeUnit.SECONDS)
                .subscribe(launchSecondActivity());


    }

    private Action1<? super Object> launchSecondActivity() {
        return null;
    }

    private Action1<? super String> goTO() {
        return null;
    }

    class MyObject {
        String name, addr;
    }
}
