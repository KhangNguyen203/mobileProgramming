package com.example.insertdata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> myList;

    public MyArrayAdapter(Activity context1, int idLayout, ArrayList<Phone> myList) {
        super(context1, idLayout, myList);
        this.context = context1;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    //Gọi hàm getView để tiến hành sắp xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Tạo để chứa layout
        LayoutInflater myFlater = context.getLayoutInflater();
        //Đặt layout lên để tạo thành dữ liệu
        convertView = myFlater.inflate(idLayout, null);
        //Lấy một phần tử trong mảng
        Phone myPhone = myList.get(position);
        //Khai báo, tham chiếu Id và hiển thị hình ành lên ImageView
        ImageView img_phone = convertView.findViewById(R.id.imgPhone);
        img_phone.setImageResource(myPhone.getImage());
        //Khai báo, tham chiếu Id và hiển thị tên lên textView
        TextView txt_phone = convertView.findViewById(R.id.txtPhone);
        txt_phone.setText(myPhone.getName());
        return convertView;

    }
}
