//
//  ExpandingTbViewRowStackView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/25.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class ExpandingTbViewRowStackView: UIView {
    
    
    let testResultView = UIView()
    let testResultLabel = UILabel()
    let reTestBtn = UIButton()
    
    let objectionBtn = UIView()
    let objectionLabel = UILabel()
    
    let levelStepLabel = UILabel()
    
}

extension ExpandingTbViewRowStackView: MyColor {
    
    func initSubView() {
        initTestResultView()
        initObjectBtn()
        initLevelStepLabel()
    }
    
    func initTestResultView() {
        self.addSubview(testResultView)
        testResultView.translatesAutoresizingMaskIntoConstraints = false
        testResultView.leftAnchor.constraint(equalTo: self.leftAnchor).isActive = true
        testResultView.rightAnchor.constraint(equalTo: self.rightAnchor).isActive = true
        testResultView.heightAnchor.constraint(equalTo: self.heightAnchor, multiplier: 1.0/4.0).isActive = true
        testResultView.topAnchor.constraint(equalTo: self.topAnchor).isActive = true
//        testResultView.backgroundColor = mainColor
        
        initTestResultLabel()
        initReTestBtn()
    }
    
    func initTestResultLabel() {
        testResultView.addSubview(testResultLabel)
        testResultLabel.translatesAutoresizingMaskIntoConstraints = false
        testResultLabel.backgroundColor = clearColor
        testResultLabel.text = "단어시험 결과 : PASS"
        testResultLabel.leftAnchor.constraint(equalTo: testResultView.leftAnchor, constant: 3).isActive = true
        testResultLabel.widthAnchor.constraint(equalTo: testResultView.widthAnchor, multiplier: 2.4/4.0).isActive = true
        testResultLabel.topAnchor.constraint(equalTo: testResultView.topAnchor).isActive = true
        testResultLabel.bottomAnchor.constraint(equalTo: testResultView.bottomAnchor).isActive = true
    }
    
    func initReTestBtn() {
        testResultView.addSubview(reTestBtn)
        reTestBtn.setTitle("재시험", for: .normal)
        reTestBtn.setTitleColor(mainColor, for: .normal)
        reTestBtn.layer.cornerRadius = 3
        reTestBtn.layer.borderWidth = 1
        reTestBtn.layer.borderColor = mainColor.cgColor
        reTestBtn.translatesAutoresizingMaskIntoConstraints = false
        reTestBtn.leftAnchor.constraint(equalTo: testResultLabel.rightAnchor, constant: 5).isActive = true
        reTestBtn.rightAnchor.constraint(equalTo: testResultView.rightAnchor, constant: -5).isActive = true
        reTestBtn.topAnchor.constraint(equalTo: testResultView.topAnchor).isActive = true
        reTestBtn.bottomAnchor.constraint(equalTo: testResultView.bottomAnchor).isActive = true
    }
    
    func initObjectBtn() {
        self.addSubview(objectionBtn)
        objectionBtn.backgroundColor = mainColor
        objectionBtn.translatesAutoresizingMaskIntoConstraints = false
        objectionBtn.leftAnchor.constraint(equalTo: self.leftAnchor).isActive = true
        objectionBtn.rightAnchor.constraint(equalTo: self.rightAnchor).isActive = true
        objectionBtn.heightAnchor.constraint(equalTo: self.heightAnchor, multiplier: 1.0/4.0).isActive = true
        objectionBtn.topAnchor.constraint(equalTo: testResultView.bottomAnchor, constant: 3).isActive = true
        objectionBtn.layer.cornerRadius = 10
        initObjectLabel()
    }
    
    func initObjectLabel() {
        objectionBtn.addSubview(objectionLabel)
        objectionLabel.text = "이의 신청"
        objectionLabel.textAlignment = .center
        objectionLabel.backgroundColor = clearColor
        objectionLabel.textColor = .white
        objectionLabel.translatesAutoresizingMaskIntoConstraints = false
        objectionLabel.leftAnchor.constraint(equalTo: objectionBtn.leftAnchor).isActive = true
        objectionLabel.rightAnchor.constraint(equalTo: objectionBtn.rightAnchor).isActive = true
        objectionLabel.topAnchor.constraint(equalTo: objectionBtn.topAnchor).isActive = true
        objectionLabel.bottomAnchor.constraint(equalTo: objectionBtn.bottomAnchor).isActive = true
        objectionLabel.sizeToFit()
        
    }
    
    func initLevelStepLabel() {
        self.addSubview(levelStepLabel)
        levelStepLabel.numberOfLines = 2
        levelStepLabel.textAlignment = .center
        levelStepLabel.backgroundColor = cellBackground
        levelStepLabel.textColor = mainColor
        levelStepLabel.layer.cornerRadius = 8
        levelStepLabel.layer.masksToBounds = true
        levelStepLabel.translatesAutoresizingMaskIntoConstraints = false
        levelStepLabel.leftAnchor.constraint(equalTo: self.leftAnchor).isActive = true
        levelStepLabel.rightAnchor.constraint(equalTo: self.rightAnchor).isActive = true
        levelStepLabel.topAnchor.constraint(equalTo: objectionBtn.bottomAnchor, constant: 3).isActive = true
        levelStepLabel.bottomAnchor.constraint(equalTo: self.bottomAnchor, constant: -3).isActive = true
        levelStepLabel.text = "다음 Level까지 \n 5번 더 합격해야해.."
    }
}
