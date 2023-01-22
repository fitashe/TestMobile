package com.fita.myapplication;

import static com.fita.myapplication.RetrofitClient.getRetrofitCLient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fita.myapplication.databinding.ActivityThirdScreenBinding;
import com.fita.myapplication.model.DataItem;
import com.fita.myapplication.model.ListAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdScreen extends AppCompatActivity{
    private ActivityThirdScreenBinding binding;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ItemAdapter adapter;
    List<DataItem> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        recyclerView = binding.rvList;
        fetchPosts();

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdScreen.this, FirstScreen.class);
                startActivity(intent);
            }
        });
    }

    private void fetchPosts(){
        getRetrofitCLient().getList().enqueue(new Callback<ListAPI>() {
            @Override
            public void onResponse(Call<ListAPI> call, Response<ListAPI> response) {
                if(response.isSuccessful() && response.body() != null){
                    listItem = response.body().getData();
                    adapter = new ItemAdapter(listItem, ThirdScreen.this);

                    layoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ListAPI> call, Throwable t) {
                Toast.makeText(ThirdScreen.this, "Error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}