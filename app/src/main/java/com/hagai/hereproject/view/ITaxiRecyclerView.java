package com.hagai.hereproject.view;


import com.hagai.hereproject.taxiList.Taxi;

import java.util.List;

/**
 * Created by hagay on 8/15/2017.
 */

public interface ITaxiRecyclerView
{
    void onLoadSuccess(List<Taxi> list, String response);
    void onLoadFailure(String error);
    void onListDataChanged(List<Taxi> list);
}
