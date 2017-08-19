package com.hagai.hereproject.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hagai.hereproject.R;
import com.hagai.hereproject.taxiList.Taxi;

import java.util.List;


/**
 * Created by hagay on 8/15/2017.
 */

public class TaxiAdapter extends RecyclerView.Adapter<TaxiAdapter.MyViewHolder> {


   private List<Taxi> mTaxiList;


    public TaxiAdapter (List<Taxi> taxiList) {
        mTaxiList = taxiList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.taxi_list_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.setData(holder, mTaxiList.get(holder.getAdapterPosition()));
    }


    @Override
    public int getItemCount() {
        return mTaxiList.size();
    }

    public void clearData() {
        mTaxiList.clear();
        notifyDataSetChanged();
    }

    public void updateList(List<Taxi> list)
    {

        for (Taxi t:list )
        {
            Taxi tmp = mTaxiList.get(list.indexOf(t));
            tmp.setmETA(t.getTaxiLongETA());
        }
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView mTtextTaxiLocation;
        TextView mTextTaxiETA;
        Taxi mTaxi;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.mTtextTaxiLocation = itemView.findViewById(R.id.textTaxiLocation);
            this.mTextTaxiETA = itemView.findViewById(R.id.textTaxiETA);
        }


        public void setData(MyViewHolder holder, Taxi taxi) {
            this.mTaxi = taxi;
            holder.mTtextTaxiLocation.setText(taxi.getTaxiLocation());
            holder.mTextTaxiETA.setText(taxi.getTaxiETA());


        }

    }
}
