package net.weirdblackmagic.clotherswe;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ysengrimm on 15.05.15.
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {
    private Integer[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        public CardView mCardView;
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(CardView v) {
            super(v);
            v.setOnClickListener(this);
            mCardView = v;
            mTextView = (TextView) mCardView.findViewById(R.id.info_text);
            mImageView = (ImageView) mCardView.findViewById(R.id.card_image);
        }

        @Override
        public void onClick(View v) {
            Intent menuIntent = new Intent(v.getContext(), SelectedImage.class);
            menuIntent.putExtra("id", getPosition()+"");
            v.getContext().startActivity(menuIntent);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TimelineAdapter(Integer[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TimelineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.timeline_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(cv);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mImageView.setImageResource(mDataset[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
