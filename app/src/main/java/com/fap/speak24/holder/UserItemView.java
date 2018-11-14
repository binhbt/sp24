package com.fap.speak24.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fap.speak24.R;
import com.fap.speak24.model.User;
import com.squareup.picasso.Picasso;
import com.vn.fa.adapter.multipleviewtype.BinderViewHolder;
import com.vn.fa.adapter.multipleviewtype.FaDataBinder;

public class UserItemView extends FaDataBinder<User> {
    public UserItemView(User data){
        super(data);
    }
    @Override
    public void bindViewHolder(BinderViewHolder holder, int position) {
        PhotoViewHolder holder1 = (PhotoViewHolder)holder;
        Picasso.with(holder.itemView.getContext())
                .load(data.getAvatar())
                .into(holder1.mImageView);
        holder1.txtTitle.setText("Photo "+ position);
    }

    @Override
    public BinderViewHolder newHolder(View parent) {
        return new PhotoViewHolder(parent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_user;
    }

    static class PhotoViewHolder extends BinderViewHolder {
        ImageView mImageView;
        TextView txtTitle;
        public PhotoViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.photo);
            txtTitle = view.findViewById(R.id.txt_title);
        }
    }
}