package com.hagai.hereproject.presenter;

import com.hagai.hereproject.taxiList.Taxi;

import java.util.List;

/**
 * Created by hagay on 8/15/2017.
 */

public interface IOnTaxiInteractorLoaderFinished
{
    void onLoadkSuccess(List<Taxi> list, String response);
    void onLoadFailure(String error);
}
