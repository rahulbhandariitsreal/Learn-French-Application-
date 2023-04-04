package com.example.miwomik_app;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.miwomik_app.adapter.WordAdapter;

import java.util.ArrayList;


public class ColorFrag extends Fragment {

    private ListView listView;
    private WordAdapter wordAdapter;
    private MediaPlayer mediaPlayer;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_family,container);
        listView=view.findViewById(R.id.listview);

        // Inflate the layout for this fragment
        // Create a list of words
        final ArrayList<Model_class> words = new ArrayList<Model_class>();
        words.add(new Model_class("red","wetetti" , R.drawable.color_red,R.raw.color_red));
        words.add(new Model_class("mustard yellow","chiwiita", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        words.add(new Model_class("dusty yellow","topiisa", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new Model_class("green","chokokki", R.drawable.color_green,R.raw.color_green));
        words.add(new Model_class("brown","takaakki", R.drawable.color_brown,R.raw.color_brown));
        words.add(new Model_class("gray","topoppi", R.drawable.color_gray,R.raw.color_gray));
        words.add(new Model_class("black","kululli", R.drawable.color_black,R.raw.color_black));
        words.add(new Model_class("white","kelilli", R.drawable.color_white,R.raw.color_white));

        wordAdapter=new WordAdapter(getActivity(),words,R.color.category_colors);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Model_class word=words.get(position);

                mediaPlayer= MediaPlayer.create(getActivity(),word.getmAudioResourceid());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasemediaplayer();
                    }
                });


            }
        });


        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
    releasemediaplayer();
    }

    private void releasemediaplayer() {
        if(mediaPlayer!= null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}