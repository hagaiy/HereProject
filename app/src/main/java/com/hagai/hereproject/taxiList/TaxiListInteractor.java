package com.hagai.hereproject.taxiList;

import com.hagai.hereproject.presenter.IOnTaxiInteractorLoaderFinished;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hagay on 8/15/2017.
 */
public class TaxiListInteractor implements ITaxiList {

    private IOnTaxiInteractorLoaderFinished mIonTaxiInteractorLoaderFinished;
    List<Taxi> taxiList;
    private final long MINUTE = 60000;

    public TaxiListInteractor(IOnTaxiInteractorLoaderFinished iOnTaxiInteractorLoaderFinished)
    {
        this.mIonTaxiInteractorLoaderFinished = iOnTaxiInteractorLoaderFinished;
    }
    @Override
    public void success(List<Taxi> list, String response)
    {
        Collections.sort(list);
        mIonTaxiInteractorLoaderFinished.onLoadkSuccess(list,response);
    }

    @Override
    public void failure(String error)
    {
        mIonTaxiInteractorLoaderFinished.onLoadFailure(error);
    }

    @Override
    public List<Taxi> applyChange(Long tickTime) {
        updatetime(tickTime);
        return taxiList;
    }

    public void fetchTaxiList()
    {
        taxiList = new ArrayList<>();
        taxiList.add(new Taxi("Castle",5*MINUTE));
        taxiList.add(new Taxi("Shekem",10*MINUTE));
        taxiList.add(new Taxi("Habima",8*MINUTE));
        taxiList.add(new Taxi("Gordon",6*MINUTE));
        taxiList.add(new Taxi("Azrieli",4*MINUTE));
        taxiList.add(new Taxi("Rotshild",12*MINUTE));
        taxiList.add(new Taxi("Dan",20*MINUTE));
        taxiList.add(new Taxi("Ibn gavirol",20*MINUTE));
        taxiList.add(new Taxi("Alenbi",15*MINUTE));
        taxiList.add(new Taxi("Hadera",40*MINUTE));
        taxiList.add(new Taxi("Unversity",55*MINUTE));
        taxiList.add(new Taxi("Shenkar",30*MINUTE));
        taxiList.add(new Taxi("Yafo",28*MINUTE));
        taxiList.add(new Taxi("Flea Market",18*MINUTE));
        taxiList.add(new Taxi("ramat hachayal",42*MINUTE));
        taxiList.add(new Taxi("ramat Gan",36*MINUTE));
        success(taxiList,"found taxi nearby");
    }
    private void updatetime( long timeToTick)
    {
        for (Taxi t:taxiList )
        {
            t.setmETA(t.getTaxiLongETA()-timeToTick);
        }
    }

}
