package com.rrokullia.pluscomputers.mosque.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.rrokullia.pluscomputers.mosque.R;
import com.rrokullia.pluscomputers.mosque.model.Anetaresia;

import java.util.List;

public class AnetaresiaAdapter extends RecyclerView.Adapter<AnetaresiaAdapter.MyViewHolder> {

    private static final int TYPE_ANETARESIA = 1;
    private static final int TYPE_LINE = 2;

    private List<Anetaresia> mAnetaresiaList;
    private Context ctx;

    public AnetaresiaAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mEmri, mPozita;
        ImageView mImage, imgAntLine;

        public MyViewHolder(View itemView) {
            super(itemView);

            mEmri = itemView.findViewById(R.id.ant_text_view_emri);
            mPozita = itemView.findViewById(R.id.ant_text_view_pozita);

            mImage = itemView.findViewById(R.id.ant_image_view);
            imgAntLine = itemView.findViewById(R.id.img_ant_linee);
        }
    }


    @Override
    public AnetaresiaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ant_item, parent, false);
        return new MyViewHolder(itemView);

//        switch (viewType) {
//            case TYPE_ANETARESIA:
//                itemView = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.ant_item, parent, false);
//                return new MyViewHolder(itemView);
//            case TYPE_LINE:
//                itemView = LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.ant_item2, parent, false);
//                return new MyViewHolder(itemView);
//            default:
//                return null;
//        }
    }

    @Override
    public void onBindViewHolder(AnetaresiaAdapter.MyViewHolder holder, int position) {
        Anetaresia anetaresia = mAnetaresiaList.get(position);

        if (position == 4) {
            holder.mEmri.setVisibility(View.GONE);
            holder.mPozita.setVisibility(View.GONE);
            holder.mImage.setVisibility(View.GONE);
            holder.imgAntLine.setVisibility(View.VISIBLE);
        }else{
            holder.mEmri.setText(anetaresia.getEmri());
            holder.mPozita.setText(anetaresia.getPozita());
            holder.mImage.setImageResource(anetaresia.getImage());
        }
//        Picasso.with(ctx)
//                .load(list.getImg())
//                .into(holder.mImageViewMain);
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (position == 5) {
//            return TYPE_ANETARESIA;
//        } else {
//            return TYPE_LINE;
//        }
//    }


    public void setAnetaresia(List<Anetaresia> anetaresiaList) {

        this.mAnetaresiaList = anetaresiaList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mAnetaresiaList.size();
    }
}

