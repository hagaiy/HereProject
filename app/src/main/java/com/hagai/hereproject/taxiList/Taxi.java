package com.hagai.hereproject.taxiList;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hagay on 8/15/2017.
 */

public class Taxi implements Comparable<Taxi>
{
    private String mTtextTaxiLocation;
    private String mTaxiETA;
    private long mETA;

    public Taxi(String taxiLocation, long taxiETA)
    {
        this.mTtextTaxiLocation =taxiLocation;
        setmETA(taxiETA);
    }
    public String getTaxiLocation() {
        return mTtextTaxiLocation;
    }

    public void setTaxiLocation(String mTtextTaxiLocation) {
        this.mTtextTaxiLocation = mTtextTaxiLocation;
    }

    public String getTaxiETA() {
        return mTaxiETA;
    }
    public long getTaxiLongETA() {
        return mETA;
    }

    public void setmETA(long mETA)
    {
        this.mETA = mETA;
        if(mETA >0) {
            mTaxiETA = new StringBuilder((new SimpleDateFormat("mm:ss")).format(new Date(mETA))).toString();
        }
        else
        {
            this.mETA = 0;
            mTaxiETA = new StringBuilder("").toString();
        }
    }



    @Override
    public int compareTo(@NonNull Taxi taxi)
    {
        if(mETA > taxi.mETA) {
            return 1;
        }
        else if(mETA < taxi.getTaxiLongETA())
        {
            return -1;
        }
        return 0;
    }
}
