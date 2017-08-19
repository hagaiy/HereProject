package com.hagai.hereproject.presenter;





import com.hagai.hereproject.clock.IOnClockTick;
import com.hagai.hereproject.view.IOnViewChanges;
import com.hagai.hereproject.view.ITaxiRecyclerView;
import com.hagai.hereproject.clock.ClockInteractor;
import com.hagai.hereproject.taxiList.Taxi;
import com.hagai.hereproject.taxiList.TaxiListInteractor;

import java.util.List;


/**
 * Created by hagay on 8/15/2017.
 */
public class Presenter implements ITaxiPresenter,IOnTaxiInteractorLoaderFinished,IOnClockTick,IOnViewChanges {


    private ITaxiRecyclerView mView;
    private TaxiListInteractor mTaxiListInteractor;
    private ClockInteractor mClockInteractor;

    @Override
    public void loadTaxiList()
    {
        mTaxiListInteractor.fetchTaxiList();
    }

    public Presenter(ITaxiRecyclerView view)
    {
        this.mView = view;
        this.mTaxiListInteractor = new TaxiListInteractor(this);
        this.mClockInteractor = new ClockInteractor(this);

    }
    @Override
    public void onLoadkSuccess(final List<Taxi> list, String response)
    {
        mView.onLoadSuccess(list,response);
    }

    @Override
    public void onLoadFailure(String error)
    {
        mView.onLoadFailure(error);
    }


    @Override
    public void tick(long TickTimeInMillis)
    {
        List<Taxi> list = mTaxiListInteractor.applyChange(TickTimeInMillis);
        mView.onListDataChanged(list);
    }

    @Override
    public void onDestroy() {
        mClockInteractor.stop();
    }
}

