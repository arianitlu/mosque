package com.rrokullia.pluscomputers.mosque.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rrokullia.pluscomputers.mosque.R;
import com.rrokullia.pluscomputers.mosque.SinglenewsActivity;
import com.rrokullia.pluscomputers.mosque.SinglenewsActivity2;
import com.rrokullia.pluscomputers.mosque.model.Lajmi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LajmiAdapter extends RecyclerView.Adapter<LajmiAdapter.MyViewHolder>{

    private List<Lajmi> mLajmiList = new ArrayList<>();
    private Context ctx;

    public LajmiAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTitle, mCategory;
        ImageView mImage,mColor;

        public MyViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mTitle = itemView.findViewById(R.id.news_text_view_titulli);
            mCategory = itemView.findViewById(R.id.news_text_view_kategoria);

            mImage = itemView.findViewById(R.id.news_image_main);
            mColor = itemView.findViewById(R.id.news_image_small);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();

            Lajmi lajmi = mLajmiList.get(position);

            Intent intent = new Intent(ctx, SinglenewsActivity2.class);

            intent.putExtra("title", lajmi.getTitle());
            intent.putExtra("category", lajmi.getCategory());
            intent.putExtra("image", lajmi.getImage());
            intent.putExtra("color",lajmi.getColor());
            intent.putExtra("description",lajmi.getDescription());
            intent.putExtra("link",lajmi.getLink());

            ctx.startActivity(intent);
        }
    }

    @Override
    public LajmiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item, parent, false);
            return new LajmiAdapter.MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(LajmiAdapter.MyViewHolder holder, int position) {

        Lajmi lajmi = mLajmiList.get(position);

        holder.mTitle.setText(lajmi.getTitle());

        Picasso.get()
                .load(lajmi.getImage())
                .resize(400, 300)
                .onlyScaleDown()
                .into(holder.mImage);

    }

    public void setLajmi(List<Lajmi> lajmiList) {
        mLajmiList = lajmiList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mLajmiList == null)
            return 0;
        else {
        return mLajmiList.size();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
