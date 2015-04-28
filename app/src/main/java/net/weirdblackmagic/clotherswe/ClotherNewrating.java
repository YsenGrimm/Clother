package net.weirdblackmagic.clotherswe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClotherNewrating extends Fragment {

    public static ClotherNewrating newInstance() {
        ClotherNewrating fragment = new ClotherNewrating();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ClotherNewrating() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clother_newrating, container, false);
    }

}
