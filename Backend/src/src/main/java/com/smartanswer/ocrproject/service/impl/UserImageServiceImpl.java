package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.UserImageURL;
import com.smartanswer.ocrproject.repository.UserImageRepository;
import com.smartanswer.ocrproject.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    UserImageRepository userImageRepository;

    @Override
    public boolean inputURL(String owner, String date, String imageURL) {
        try{
            UserImageURL userImageURL = new UserImageURL(owner,date,imageURL);
            userImageRepository.save(userImageURL);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getURL(String owner, String date) {
        UserImageURL userImageURL = userImageRepository.findByOwnerAndDate(owner,date);
        return userImageURL.getImageUrl();
//        return userImageRepository.findByOwnerAndDate(owner,date);
    }
}
