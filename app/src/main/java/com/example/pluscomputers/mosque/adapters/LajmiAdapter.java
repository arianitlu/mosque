package com.example.pluscomputers.mosque.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pluscomputers.mosque.R;
import com.example.pluscomputers.mosque.SinglenewsActivity;
import com.example.pluscomputers.mosque.model.Lajmi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LajmiAdapter extends RecyclerView.Adapter<LajmiAdapter.MyViewHolder>{

    private List<Lajmi> mLajmiList;
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

            Intent intent = new Intent(ctx, SinglenewsActivity.class);

            intent.putExtra("title", lajmi.getTitle());
            intent.putExtra("category", lajmi.getCategory());
            intent.putExtra("image", lajmi.getImage());
            intent.putExtra("color",lajmi.getColor());
            intent.putExtra("description",lajmi.getDescription());

            ctx.startActivity(intent);
        }
    }

    @Override
    public LajmiAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);

        return new LajmiAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LajmiAdapter.MyViewHolder holder, int position) {
        Lajmi lajmi = mLajmiList.get(position);

        holder.mTitle.setText(lajmi.getTitle());
        holder.mCategory.setText("Wil Mosque");

        //holder.mImage.setImageResource(lajmi.getDefaultImage());
        holder.mColor.setImageResource(lajmi.getColor());
        Picasso.get()
                .load(lajmi.getImage())
                //.placeholder(R.drawable.news_photo1)
                //.error(R.drawable.news_photo1)
                .into(holder.mImage);
    }

    public void setLajmi(List<Lajmi> lajmiList) {
        this.mLajmiList = lajmiList;
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
}
