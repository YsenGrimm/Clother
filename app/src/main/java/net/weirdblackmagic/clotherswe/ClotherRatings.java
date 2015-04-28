package net.weirdblackmagic.clotherswe;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClotherRatings extends Fragment {

    public static ClotherRatings newInstance() {
        ClotherRatings fragment = new ClotherRatings();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public ClotherRatings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_clother_ratings, container, false);

        GridView ratingsView = (GridView) view.findViewById(R.id.ratingsView);
        ratingsView.setAdapter(new ImageAdapter());

        ratingsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return view;//inflater.inflate(R.layout.fragment_clother_ratings, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        private Integer[] mThumbIds = {
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
                R.drawable.cat,R.drawable.cat,
        };

        public ImageAdapter() {
            //mContext = c;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(getActivity());
                imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }


}
