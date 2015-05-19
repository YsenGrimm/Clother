package net.weirdblackmagic.clotherswe;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectedCloth#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectedCloth extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SelectedCloth.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectedCloth newInstance() {
        SelectedCloth fragment = new SelectedCloth();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public SelectedCloth() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_cloth, container, false);
    }


}
