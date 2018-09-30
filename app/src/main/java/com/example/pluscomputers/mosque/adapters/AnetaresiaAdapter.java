package com.example.pluscomputers.mosque.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pluscomputers.mosque.R;
import com.example.pluscomputers.mosque.model.Anetaresia;

import java.util.List;

public class AnetaresiaAdapter extends RecyclerView.Adapter<AnetaresiaAdapter.MyViewHolder> {

    private List<Anetaresia> mAnetaresiaList;
    private Context ctx;

    public AnetaresiaAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mEmri, mPozita;
        ImageView mImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            mEmri = itemView.findViewById(R.id.ant_text_view_emri);
            mPozita = itemView.findViewById(R.id.ant_text_view_pozita);

            mImage = itemView.findViewById(R.id.ant_image_view);
        }
    }

    @Override
    public AnetaresiaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ant_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AnetaresiaAdapter.MyViewHolder holder, int position) {
        Anetaresia anetaresia = mAnetaresiaList.get(position);

        holder.mEmri.setText(anetaresia.getEmri());
        holder.mPozita.setText(anetaresia.getPozita());
        holder.mImage.setImageResource(anetaresia.getImage());
//        Picasso.with(ctx)
//                .load(list.getImg())
//                .into(holder.mImageViewMain);
    }

    public void setAnetaresia(List<Anetaresia> anetaresiaList){
        this.mAnetaresiaList = anetaresiaList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAnetaresiaList.size();
    }
}