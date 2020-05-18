package com.example.smart_answer.ui.friends;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FriendViewModel {

    private MutableLiveData<String> mText;

    public FriendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is friends fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
