package com.tutorial.ibrahimestanga.jpcapp.view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorial.ibrahimestanga.jpcapp.R;
import com.tutorial.ibrahimestanga.jpcapp.model.ModelRespose;
import com.tutorial.ibrahimestanga.jpcapp.retrofit.ApiServices;
import com.tutorial.ibrahimestanga.jpcapp.retrofit.ApiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_main_act_response_mod)
    TextView tvResponse;

    @BindView(R.id.tv_main_act_reverse_mod)
    TextView tvReverse;

    @BindView(R.id.pb_main_act)
    ProgressBar progressBar;

    ApiServices apiServices;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiServices= ApiUtils.getAPIService();
    }

    @OnClick({R.id.bt_main_act_call_services,R.id.bt_main_act_call_next_act})
    void onClick(View view){

        switch (view.getId()){

            case R.id.bt_main_act_call_services:{
                progressBar.setVisibility(View.VISIBLE);
                apiServices.getResponse().enqueue(new Callback<ModelRespose>() {
                    @Override
                    public void onResponse(Call<ModelRespose> call, Response<ModelRespose> response) {
                        if(response.isSuccessful()){
                            String respon = response.body().getOrigin();
                            StringBuilder reverse = new StringBuilder();

                            for (int i=respon.length()-1;i>=0;i--)
                                reverse.append(respon.charAt(i));

                            tvResponse.setText(respon);
                            tvReverse.setText(reverse.toString());


                        }else
                            Toast.makeText(MainActivity.this,"consulta fallo",Toast.LENGTH_SHORT).show();


                        progressBar.setVisibility(View.GONE);
                    }
                    @Override
                    public void onFailure(Call<ModelRespose> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
                break;
            }

            case R.id.bt_main_act_call_next_act:{
                Intent intent = new Intent(this,ListActivity.class);
                startActivity(intent);
                break;
            }




        }



    }




}
