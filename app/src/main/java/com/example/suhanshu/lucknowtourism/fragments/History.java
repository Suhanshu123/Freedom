package com.example.suhanshu.lucknowtourism.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.suhanshu.lucknowtourism.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class History extends Fragment {

    TextView textView1;
    TextView textView2;
    public History() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);
        textView1=view.findViewById(R.id.historyTextView1);
        textView2=view.findViewById(R.id.historyTextView2);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textView1.setText(Html.fromHtml(getString(R.string.history1),Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView1.setText(Html.fromHtml(getString(R.string.history1)));
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            textView2.setText(Html.fromHtml(getString(R.string.history2),Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView2.setText(Html.fromHtml(getString(R.string.history2)));
        }
        return view;
    }

}
