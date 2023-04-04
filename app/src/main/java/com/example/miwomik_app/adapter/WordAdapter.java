package com.example.miwomik_app.adapter;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.miwomik_app.Model_class;
import com.example.miwomik_app.R;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Model_class> {



    int mcolorresourceID;
    public WordAdapter(Activity context, ArrayList<Model_class> words,int mcolorresourceID ) {
        super(context, 0,words);
        this.mcolorresourceID=mcolorresourceID;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listview=convertView;
        if(listview == null){
            listview= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        }

        Model_class current_word=getItem(position);
        ImageView imageView=listview.findViewById(R.id.image);
        TextView my_word,translate_word;
        my_word=listview.findViewById(R.id.myword);
        translate_word=listview.findViewById(R.id.Translateword);

        if(current_word.getmImageResource() != Model_class.IMAGE_RESOURCE_ID){
            imageView.setImageResource(current_word.getmImageResource());
            imageView.setVisibility(View.VISIBLE);
        }else{
            imageView.setVisibility(View.GONE);
        }

       RelativeLayout relativeLayout= listview.findViewById(R.id.relativelayout);


        int color = ContextCompat.getColor(getContext() , mcolorresourceID);

        relativeLayout.setBackgroundColor(color);


        my_word.setText(current_word.getmGivenWord());
        translate_word.setText(current_word.getmTranstWord());

        return listview;
    }
}
