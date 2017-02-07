package com.test.rxjavademo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import rx.Observable;
import rx.Observer;

public class MainActivity extends Activity {

  public static final String   TAG="rxjava";
    private Observer<String> mObserver;
    private Observable<String> mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.
        createObserver();
//        2.
        createObservable();
    }

    private void createObservable() {
        mObservable = Observable.just("t1","t2","t3");
    }

    private void createObserver() {
        mObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: "+s);
            }
        };
    }

    public   void showobserver(View view) {

        mObservable.subscribe(mObserver);
    }
}
