package com.hagai.hereproject.taxiList;


import java.util.List;

/**
 * Created by hagay on 8/15/2017.
 */

public interface ITaxiList {
    void success(List<Taxi> list, String response);

    void failure(String error);

    List<Taxi> applyChange(Long tickTime);
}
