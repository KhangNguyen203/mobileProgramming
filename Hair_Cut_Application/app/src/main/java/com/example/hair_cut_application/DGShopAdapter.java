package com.example.hair_cut_application;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hair_cut_application.DAO.UsersDAO;
import com.example.hair_cut_application.DTO.DanhGiaDTO;
import com.example.hair_cut_application.DTO.UserDTO;

import java.util.ArrayList;

public class DGShopAdapter extends BaseAdapter {
    Context context;
    ArrayList<DanhGiaDTO> ds;

    public DGShopAdapter(Context context,ArrayList<DanhGiaDTO> ds){
        this.context = context;
        this.ds = ds;
    }

    @Override
    public int getCount() {
        return ds.size();
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
        ViewHolder holder;
        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_danhgia, null);

            holder.txtUserNameDG = convertView.findViewById(R.id.txtUserNameDG);
            holder.txtTGDG = convertView.findViewById(R.id.txtTGDG);
            holder.ratingBarDG = convertView.findViewById(R.id.ratingBarDG);
            holder.etxtReviewDG = convertView.findViewById(R.id.etxtReviewDG);
            holder.layoutDG = convertView.findViewById(R.id.layoutDG);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        DanhGiaDTO danhGiaDTO = ds.get(position);
//        UsersDAO usersDAO = home.uDao;
//        UserDTO userDTO = usersDAO.layDuLieu(danhGiaDTO.getLichSuDTO().getSdt());
//        String name = userDTO.getUsername();
//        holder.txtUserNameDG.setText(name);
        holder.txtUserNameDG.setText(danhGiaDTO.getLichSuDTO().getSdt());
        holder.txtTGDG.setText(danhGiaDTO.getTgDG());
        holder.ratingBarDG.setRating(danhGiaDTO.getShopRating());
        holder.etxtReviewDG.setText(danhGiaDTO.getShopReview());
        holder.layoutDG.setBackgroundResource(R.drawable.border);

        return convertView;
    }

    class ViewHolder{
        TextView txtUserNameDG, txtTGDG;
        RatingBar ratingBarDG;
        TextView etxtReviewDG;
        LinearLayout layoutDG;
    }
}
