package com.tutorial.ibrahimestanga.jpcapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.tutorial.ibrahimestanga.jpcapp.R;
import com.tutorial.ibrahimestanga.jpcapp.adapter.AdapterList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListActivity extends AppCompatActivity implements AdapterList.ListenerAdapter {
    @BindView(R.id.et_list_act_add)
    EditText etListadd;

    @BindView(R.id.tv_list_act_empty_list)
    TextView tvEmptyList;

    @BindView(R.id.rv_list_act)
    RecyclerView recyclerView;

   private List<Integer> numeros= new ArrayList<>();


    private RecyclerView.Adapter mAdapter;
    private String TAG = getClass().getSimpleName();
    private LinearLayoutManager layoutManager;
    private static final int MAXNUMBER = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);
        configAdapter();
        listEmpty();
    }


    public void configAdapter() {

        mAdapter = new AdapterList(numeros, this, this);
        mAdapter.notifyDataSetChanged();
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }




    public void listEmpty() {
        if (numeros.isEmpty()) {
            tvEmptyList.setVisibility(View.VISIBLE);
        } else
            tvEmptyList.setVisibility(View.GONE);
    }


    @OnClick(R.id.bt_list_act_add)
    public void add() {

        if (etListadd.getText().length() != 0) {
            Log.i(TAG, "cadena no vacia" + etListadd.getText().toString());
            int ciclo = Integer.valueOf(etListadd.getText().toString());

            for(int i = 0; i<ciclo;i++){
                Integer num = (int) (Math.random() * MAXNUMBER) + 1;
                numeros.add(mAdapter.getItemCount(),num);
                mAdapter.notifyItemInserted(mAdapter.getItemCount());
            }
            mAdapter.notifyDataSetChanged();



        } else {
            Log.i(TAG, "cadena vacia" + etListadd.getText().toString());
            etListadd.setError("campó obligatorio");
        }

        listEmpty();
    }

    @OnClick(R.id.bt_list_act_remove_item)
    public void removeAll() {
        numeros.clear();
        mAdapter.notifyDataSetChanged();
        listEmpty();
    }

    @OnClick(R.id.bt_list_act_short_ascendig)
    public void shortAscendig() {
        Collections.sort(numeros);
        mAdapter.notifyDataSetChanged();
        listEmpty();
    }



    @Override
    public void delete(int position) {
        numeros.remove(position);
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyDataSetChanged();

        listEmpty();

    }
}
