package com.joydas1902.newsapp.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joydas1902.newsapp.Adapter;
import com.joydas1902.newsapp.ApiUtilities;
import com.joydas1902.newsapp.model.Articles;
import com.joydas1902.newsapp.R;
import com.joydas1902.newsapp.model.NewsApiResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScienceFragment extends Fragment {

    ProgressDialog dialog;
    String apiKey = "446c9b3979e54d5c8a7d98248cce5d9d";
    ArrayList<Articles> articlesArrayList;
    Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        dialog = new ProgressDialog(getContext());
        dialog.setTitle("Loading...");
        dialog.show();

        View view = inflater.inflate(R.layout.science_fragment, null);

        articlesArrayList = new ArrayList<>();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViweOfScience);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), articlesArrayList);
        recyclerView.setAdapter(adapter);

        findNews();
        return view;
    }

    private void findNews() {

        ApiUtilities.getApiInterface().getNews("in", "science", null, apiKey, 100).enqueue(new Callback<NewsApiResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<NewsApiResponse> call, @NonNull Response<NewsApiResponse> response) {
                if(response.isSuccessful() && response.body() != null) {
                    articlesArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(@NonNull Call<NewsApiResponse> call, @NonNull Throwable t) {

            }
        });
    }
}

