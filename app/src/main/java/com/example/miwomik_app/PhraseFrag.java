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


public class PhraseFrag extends Fragment {

   private ListView listView;
   private WordAdapter wordAdapter;
   private MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_phrase,container);


        final ArrayList<Model_class> words = new ArrayList<Model_class>();


        words.add(new Model_class("where are you going ?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Model_class("what is your name","tinna oyaasina",R.raw.phrase_what_is_your_name));
        words.add(new Model_class("my name is","oyyasit",R.raw.phrase_my_name_is));
        words.add(new Model_class("how are you feeling","michaksas",R.raw.phrase_how_are_you_feeling));
        words.add(new Model_class("i'm feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Model_class("Are you coming ","aanas'aa",R.raw.phrase_are_you_coming));
        words.add(new Model_class("yes , i'm coming","haa'aanam",R.raw.phrase_yes_im_coming));
        words.add(new Model_class("i'm coming","aanam",R.raw.phrase_im_coming));

        listView=view.findViewById(R.id.listview_pharse);
        wordAdapter=new WordAdapter(getActivity(),words,R.color.category_phrases);

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
                        releasemedaiplayer();
                    }
                });
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void releasemedaiplayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }
}