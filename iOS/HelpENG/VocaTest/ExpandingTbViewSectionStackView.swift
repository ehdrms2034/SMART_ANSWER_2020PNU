//
//  ExpandingTbViewSectionStackView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/18.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class ExpandingTbViewSectionStackView: UIStackView {
    
    let levelLabel = UILabel()
    let wrongAnswerLabel = UILabel()
    let correctAnswerLabel = UILabel()

    
}

extension ExpandingTbViewSectionStackView: MyColor {
    
    func setupStackView() {
            self.axis = .horizontal
            self.alignment = .fill
            self.distribution = .equalSpacing
            self.spacing = 0
            self.backgroundColor = clearColor
            setupStackViewInside()
        }
        
        func setupStackViewInside() {
    //        self.addSubview(levelLabel)
    //        self.addSubview(wrongAnswerLabel)
    //        self.addSubview(correctAnswerLabel)
            levelLabel.backgroundColor = clearColor
            correctAnswerLabel.backgroundColor = clearColor
            wrongAnswerLabel.backgroundColor = clearColor
            
            levelLabel.textColor = textColor
            correctAnswerLabel.textColor = textColor
            wrongAnswerLabel.textColor = textColor
            
            self.addArrangedSubview(levelLabel)
            self.addArrangedSubview(correctAnswerLabel)
            self.addArrangedSubview(wrongAnswerLabel)
        }
}
