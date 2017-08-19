package com.hagai.hereproject.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hagai.hereproject.R;
import com.hagai.hereproject.presenter.Presenter;
import com.hagai.hereproject.taxiList.Taxi;

import java.util.List;
/**
 * Created by hagay on 8/15/2017.
 */
public class MainActivity extends AppCompatActivity implements ITaxiRecyclerView {

    private Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private TaxiAdapter taxiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mPresenter = new Presenter(this);
        mPresenter.loadTaxiList();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onLoadSuccess(final List<Taxi> list, String response) {
        taxiAdapter = new TaxiAdapter(list);
        mRecyclerView.setAdapter(taxiAdapter);

        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadFailure(String error)
    {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListDataChanged(List<Taxi> list)
    {
        taxiAdapter.updateList(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
