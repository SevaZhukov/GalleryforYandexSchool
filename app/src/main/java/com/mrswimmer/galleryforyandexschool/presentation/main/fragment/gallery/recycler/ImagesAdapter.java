package com.mrswimmer.galleryforyandexschool.presentation.main.fragment.gallery.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.mrswimmer.galleryforyandexschool.App;
import com.mrswimmer.galleryforyandexschool.R;
import com.mrswimmer.galleryforyandexschool.data.model.ImageItem;

import java.util.ArrayList;

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    ArrayList<ImageItem> images = new ArrayList<>();
    Context context;
    public ImagesAdapter(ArrayList<ImageItem> images, Context context) {
        this.images = images;
        this.context = context;
        App.getComponent().inject(this);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_gallery, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageItem imageItem = images.get(position);
        Glide.with(context)
                .load(imageItem.getUrl())
                .centerCrop()
                .placeholder(R.color.black)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
