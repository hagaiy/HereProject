package com.hagai.hereproject.clock;

/**
 * Created by hagay on 8/15/2017.
 */

public interface IClock {
   void onTick(long time);

   void stop();
}
