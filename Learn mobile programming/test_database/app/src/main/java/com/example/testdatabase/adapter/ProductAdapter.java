package com.example.testdatabase.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testdatabase.Products;
import com.example.testdatabase.R;

import java.util.ArrayList;
public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<Products> ds;
    public ProductAdapter(Context context, ArrayList<Products> ds){
        this.context = context;
        this.ds = ds;
    }

    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return ds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.layout_item, null);


            holder.name = convertView.findViewById(R.id.txtName);
            holder.price = convertView.findViewById(R.id.txtPrice);
            holder.img = convertView.findViewById(R.id.ivImage);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Products p = ds.get(position);
        holder.name.setText(p.getName());
        holder.price.setText(String.valueOf(p.getPrice()));
        String imgName = p.getImgageName();
        int resId = ((Activity) context).getResources()
                .getIdentifier(imgName, "drawable", ((Activity) context).getPackageName());
        holder.img.setImageResource(resId);

        return convertView;
    }

    class ViewHolder{
        TextView name;
        TextView price;
        ImageView img;
    }
}
