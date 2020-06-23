package com.smartanswer.ocrproject.service;

import com.smartanswer.ocrproject.model.TestWord;
import com.smartanswer.ocrproject.model.UserAndDate;

public interface TestWordService {
    boolean inputTestWord(TestWord testWord);

    TestWord getTestWord(UserAndDate userAndDate);
}
