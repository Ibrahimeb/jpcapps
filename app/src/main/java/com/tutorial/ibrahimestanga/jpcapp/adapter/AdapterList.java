package com.tutorial.ibrahimestanga.jpcapp.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tutorial.ibrahimestanga.jpcapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ibrahim Estanga on 5/12/2017.
 */

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder> {

    private String TAG=getClass().getSimpleName();
    private List<Integer> numeros;
    private Context context;
    private ListenerAdapter mlistener;

    public AdapterList(List<Integer> numeros, Context context, ListenerAdapter mlistener) {
        this.numeros = numeros;
        this.context = context;
        this.mlistener = mlistener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("-->","onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(TAG,"bindViewHolder");
        holder.render(numeros.get(position),position,context,mlistener);
    }



    @Override
    public int getItemCount() {
        Log.i(TAG,"getItemCount" + numeros.size());
        if(numeros.isEmpty())
            return 0;
        else
            return numeros.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_numero)
        TextView numero;

        @BindView(R.id.rl_item)
        RelativeLayout rlItem;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }




        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        public void render(int num, final int position, Context context, final ListenerAdapter listener) {


            if(position%2==0)
                rlItem.setBackground(context.getResources().getDrawable(R.color.blue_200) );
            else
                rlItem.setBackground(context.getResources().getDrawable(R.color.blue_400) );


            this.numero.setText(String.valueOf(num));

            rlItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.delete(position);
                }
            });


        }

    }


    public interface ListenerAdapter{
        void delete(int position);
    }


}
