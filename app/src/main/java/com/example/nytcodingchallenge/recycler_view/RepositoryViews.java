package com.example.nytcodingchallenge.recycler_view;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytcodingchallenge.MainActivity;
import com.example.nytcodingchallenge.R;
import com.example.nytcodingchallenge.model.Organization;

import java.util.ArrayList;

public class RepositoryViews {

    private Context mContext;
    private MainActivity activity;
    private RepositoryViewsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<Organization> orgList;

    public RepositoryViews(Context context){
        this.mContext = context;
        this.activity = (MainActivity) context;
    }

    public void setTopRepos(){
        recyclerView = activity.findViewById(R.id.repoRecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
        orgList = activity.getSortedRepos();
        adapter = new RepositoryViewsAdapter(orgList);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);
        recyclerView.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        adapter.setOnClickListener(new RepositoryViewsAdapter.OnClickListener() {
            @Override
            public void onRepoClick(int position, Organization organization, View v) {
                Log.d("GithubChallengeApp", organization.getHtml_url());
                activity.starWebView(organization.getHtml_url());
            }
        });
    }

}
