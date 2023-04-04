package com.example.miwomik_app;

import android.annotation.SuppressLint;
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

public class FamilyFrag extends Fragment {
private ListView listView;
private WordAdapter wordAdapter;
private MediaPlayer mediaPlayer;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_family,container);
        listView=view.findViewById(R.id.listview);

        // Inflate the layout for this fragment
        final ArrayList<Model_class> words = new ArrayList<Model_class>();
        words.add(new Model_class("father","apa", R.drawable.family_father, R.raw.family_father));
        words.add(new Model_class("mother","ata", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Model_class("son","angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Model_class("daughter","tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Model_class("older brother"," taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Model_class("younger brother","chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Model_class("older sister","tete", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Model_class("younger sister","kollete", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Model_class("grand mother","ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Model_class("grand father","apa", R.drawable.family_grandfather, R.raw.family_grandfather));

        wordAdapter=new WordAdapter(getActivity(),words,R.color.category_family);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Model_class word=words.get(position);

                mediaPlayer=MediaPlayer.create(getActivity(),word.getmAudioResourceid());
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

    public  void releasemediaplayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}