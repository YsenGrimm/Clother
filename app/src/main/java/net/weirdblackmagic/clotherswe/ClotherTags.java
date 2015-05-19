package net.weirdblackmagic.clotherswe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClotherTags#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClotherTags extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ClotherTags.
     */
    public static ClotherTags newInstance() {
        ClotherTags fragment = new ClotherTags();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ClotherTags() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_clother_tags, container, false);

        // TODO get real tags

        // Inflate the layout for this fragment
        return view;
    }


}
