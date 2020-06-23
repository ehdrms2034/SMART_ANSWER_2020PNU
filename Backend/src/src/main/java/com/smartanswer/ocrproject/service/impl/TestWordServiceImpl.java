package com.smartanswer.ocrproject.service.impl;

import com.smartanswer.ocrproject.model.TestWord;
import com.smartanswer.ocrproject.model.UserAndDate;
import com.smartanswer.ocrproject.repository.TestWordRepository;
import com.smartanswer.ocrproject.service.TestWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestWordServiceImpl implements TestWordService {

    @Autowired
    TestWordRepository testWordRepository;

    @Override
    public boolean inputTestWord(TestWord testWord) {
        try {
            testWordRepository.save(testWord);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public TestWord getTestWord(UserAndDate userAndDate) {
        return testWordRepository.findByOwnerAndDate(userAndDate.getId(), userAndDate.getDate());
    }
}
