package com.fap.speak24.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fap.speak24.R;
import com.fap.speak24.model.User;
import com.github.ivbaranov.mli.MaterialLetterIcon;
import com.squareup.picasso.Picasso;
import com.vn.fa.adapter.multipleviewtype.BinderViewHolder;
import com.vn.fa.adapter.multipleviewtype.FaDataBinder;
import com.vn.fa.base.holder.FaBinderView;
import com.vn.fa.base.holder.FaViewHolder;

import butterknife.BindView;

public class UserItemView extends FaBinderView<User> {
    public UserItemView(User data){
        super(data);
    }
    @Override
    public void bindViewHolder(BinderViewHolder holder, int position) {
        PhotoViewHolder holder1 = (PhotoViewHolder)holder;
        if (data.getAvatar() != null && data.getAvatar().length() >0) {
            Picasso.with(holder.itemView.getContext())
                    .load(data.getAvatar())
                    .into(holder1.mImageView);
            holder1.mImageView.setVisibility(View.VISIBLE);
            holder1.avatar.setVisibility(View.GONE);

        }else{
            holder1.mImageView.setVisibility(View.GONE);
            holder1.avatar.setVisibility(View.VISIBLE);
            holder1.avatar.setLetter(data.getNick());
        }
        holder1.txtStatus.setText(data.getStatus());
        holder1.txtNick.setText(data.getNick());
        holder1.txtAge.setText(data.getAge());


    }

    @Override
    public BinderViewHolder newHolder(View parent) {
        return new PhotoViewHolder(parent);
    }

    @Override
    public int getLayoutResource() {
        return R.layout.item_user;
    }

    static class PhotoViewHolder extends FaViewHolder {
        @BindView(R.id.photo)
        ImageView mImageView;
        @BindView(R.id.txt_status)
        TextView txtStatus;
        @BindView(R.id.avatar)
        MaterialLetterIcon avatar;

        @BindView(R.id.img_sex)
        ImageView imgSex;
        @BindView(R.id.txt_nick)
        TextView txtNick;
        @BindView(R.id.txt_age)
        TextView txtAge;
        @BindView(R.id.img_country)
        ImageView imgCountry;
        public PhotoViewHolder(View view) {
            super(view);
        }
    }
}