package com.example.miwomik_app;

public class Model_class {


    private  String mGivenWord;
    private String mTranstWord;

    private int mImageResource=IMAGE_RESOURCE_ID;

    private int mAudioResourceid;


    public static final int IMAGE_RESOURCE_ID=0;


    public Model_class(String mGivenWord, String mTranstWord, int mImageResource, int mAudioResourceid) {
        this.mGivenWord = mGivenWord;
        this.mTranstWord = mTranstWord;
        this.mImageResource = mImageResource;
        this.mAudioResourceid = mAudioResourceid;
    }

    public Model_class(String mGivenWord, String mTranstWord,int mAudioResourceid) {
        this.mGivenWord = mGivenWord;
        this.mTranstWord = mTranstWord;
        this.mAudioResourceid=mAudioResourceid;
    }

    public String getmGivenWord() {
        return mGivenWord;
    }

    public void setmGivenWord(String mGivenWord) {
        this.mGivenWord = mGivenWord;
    }

    public String getmTranstWord() {
        return mTranstWord;
    }

    public void setmTranstWord(String mTranstWord) {
        this.mTranstWord = mTranstWord;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public int getmAudioResourceid() {
        return mAudioResourceid;
    }

    public void setmAudioResourceid(int mAudioResourceid) {
        this.mAudioResourceid = mAudioResourceid;
    }
}
