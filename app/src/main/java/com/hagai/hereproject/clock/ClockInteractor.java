package com.hagai.hereproject.clock;

/**
 * Created by hagay on 8/15/2017.
 */
public class ClockInteractor implements IClock
{
    private IOnClockTick mOnClockTick;
    private Clock mClock;
    
    public ClockInteractor(IOnClockTick onClockTick)
    {
        this.mOnClockTick = onClockTick;
        mClock = new Clock(this);
    }

    @Override
    public void onTick(long tickInMillis)
    {
        mOnClockTick.tick(tickInMillis);
    }

    @Override
    public void stop() {
        mClock.stopClock();
    }
}
