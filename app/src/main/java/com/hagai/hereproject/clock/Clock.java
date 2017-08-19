package com.hagai.hereproject.clock;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hagay on 8/15/2017.
 */

public class Clock
{
    private final long TICK_TIME_IN_MILLIS = 5000;
    private IClock mIClock;
    private Disposable disposable;

    public Clock(IClock iClock)
    {
        this.mIClock = iClock;
        activateRxClock();
    }
    public void stopClock()
    {
        deactivateRxClock();
    }
    private  void activateRxClock()
    {
        disposable = getObservable().subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(getObserver());
    }
    private void deactivateRxClock()
    {
        if(disposable!= null && !disposable.isDisposed())
      disposable.dispose();
    }
    private DisposableObserver<Long> getObserver()
    {
       return new DisposableObserver<Long>() {

           @Override
            public void onNext(Long aLong) {
               mIClock.onTick(TICK_TIME_IN_MILLIS);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("clock", " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
    }
    private Observable<Long> getObservable()
    {
        return Observable.interval(0,5,TimeUnit.SECONDS);
    }
//    private Timer timer;
//    private void activateTimerClock()
//    {
//        final Handler handler= new Handler();
//        timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        mClockInteractor.onTick(TICK_TIME_IN_MILLIS);
//                    }
//                });
//            }
//        }, TICK_TIME_IN_MILLIS, TICK_TIME_IN_MILLIS);
//    }
//    private void deactivateTimerClock()
//    {
//        if(timer!= null)
//            timer.cancel();
//    }
}
