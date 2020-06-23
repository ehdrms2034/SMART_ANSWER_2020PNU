package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.UserImageURL;

public interface UserImageService {
    boolean inputURL(String owner, String date, String imageURL);

    String getURL(String owner, String date);
}
