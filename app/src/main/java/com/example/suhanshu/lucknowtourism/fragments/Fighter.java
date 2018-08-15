package com.example.suhanshu.lucknowtourism.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suhanshu.lucknowtourism.adapters.AdapterClass;
import com.example.suhanshu.lucknowtourism.R;
import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fighter extends Fragment {
    private RecyclerView recyclerView;
    private AdapterClass adapterClass;
    private int drawsid[]={R.drawable.gandhiji,R.drawable.balgana,R.drawable.bhagat,R.drawable.dadabhai,R.drawable.rajendra,R.drawable.subhash,R.drawable.lala,R.drawable.sarojini,R.drawable.sardar,R.drawable.lal};

    String name[]={"Gandhiji","Bal Gangadhar Tilak","Bhagat Singh","Dadabhai Naoroji","Rajendra Prasad","Subhash Chandra Bose",
        "Lala Lajpati Rai","Sarojini Naidu","Sardar Vallabhbhai","Lal Bahadur Shastri"};

    public Fighter() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fighter, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        adapterClass = new AdapterClass(drawsid,name);
        recyclerView.setLayoutManager(new CardSliderLayoutManager(50,900,12));
        new CardSnapHelper().attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapterClass);
        return view;
    }

}
