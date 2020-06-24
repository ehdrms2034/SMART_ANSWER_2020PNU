//
//  TbViewVocaCellStackView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TbViewVocaCellStackView: UIStackView {
    
    let vocaView: UIView = UIView()
    let vocaLabel = UILabel()
    
    let meaningView = UIView()
    let meaningLabel = UILabel()
}

extension TbViewVocaCellStackView: MyColor {
    
    func initStackView() {
        self.axis = .horizontal
        self.distribution = .fillEqually
        self.alignment = .fill
        self.spacing = 10
        self.backgroundColor = clearColor
        setupStackViewSubView()
    }
    
    func setupStackViewSubView() {
        
        self.addArrangedSubview(vocaView)
        vocaView.backgroundColor = mainColor
        vocaView.layer.cornerRadius = 10
        initVocaView()

        self.addArrangedSubview(meaningView)
        meaningView.backgroundColor = cellBackground
        meaningView.layer.cornerRadius = 10
        initMeaningView()
    }
    
    func initVocaView() {
        vocaView.addSubview(vocaLabel)
        vocaLabel.translatesAutoresizingMaskIntoConstraints = false
        vocaLabel.leftAnchor.constraint(equalTo: vocaView.leftAnchor).isActive = true
        vocaLabel.rightAnchor.constraint(equalTo: vocaView.rightAnchor).isActive = true
        vocaLabel.topAnchor.constraint(equalTo: vocaView.topAnchor).isActive = true
        vocaLabel.bottomAnchor.constraint(equalTo: vocaView.bottomAnchor).isActive = true
        vocaLabel.textAlignment = .center
        vocaLabel.backgroundColor = clearColor
        vocaLabel.textColor = .white
        vocaLabel.layer.cornerRadius = 10
    }
    
    func initMeaningView() {
        meaningView.addSubview(meaningLabel)
        meaningLabel.translatesAutoresizingMaskIntoConstraints = false
        meaningLabel.leftAnchor.constraint(equalTo: meaningView.leftAnchor).isActive = true
        meaningLabel.rightAnchor.constraint(equalTo: meaningView.rightAnchor).isActive = true
        meaningLabel.topAnchor.constraint(equalTo: meaningView.topAnchor).isActive = true
        meaningLabel.bottomAnchor.constraint(equalTo: meaningView.bottomAnchor).isActive = true
        meaningLabel.textAlignment = .center
        meaningLabel.backgroundColor = clearColor
        meaningLabel.layer.cornerRadius = 10
    }
}
