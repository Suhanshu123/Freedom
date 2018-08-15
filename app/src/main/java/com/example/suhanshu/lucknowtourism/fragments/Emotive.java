package com.example.suhanshu.lucknowtourism.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suhanshu.lucknowtourism.R;
import com.example.suhanshu.lucknowtourism.adapters.EmotiveAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Emotive extends Fragment {
    RecyclerView recyclerView;
    EmotiveAdapter emotiveAdapter;


    public Emotive() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emotive, container, false);
        recyclerView = view.findViewById(R.id.emo_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        emotiveAdapter = new EmotiveAdapter();
        recyclerView.setAdapter(emotiveAdapter);
        return view;
    }

}
