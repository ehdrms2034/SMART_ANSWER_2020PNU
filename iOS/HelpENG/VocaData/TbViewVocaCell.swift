//
//  TbViewVocaCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TbViewVocaCell: UITableViewCell {
    
    let containerView: UIView = UIView()
    let stackView = TbViewVocaCellStackView()
    
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        initContainerView()
        initStackView()
       
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
}

extension TbViewVocaCell: MyColor {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor, constant: 5).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor, constant: -5).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor, constant: 5).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -5).isActive = true
        containerView.heightAnchor.constraint(equalToConstant: 30).isActive = true
        containerView.backgroundColor = clearColor
        containerView.layer.cornerRadius = 5

    }
    
    func initStackView() {
        self.containerView.addSubview(stackView)
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.leftAnchor.constraint(equalTo: containerView.leftAnchor).isActive = true
        stackView.rightAnchor.constraint(equalTo: containerView.rightAnchor).isActive = true
        stackView.topAnchor.constraint(equalTo: containerView.topAnchor).isActive = true
        stackView.bottomAnchor.constraint(equalTo: containerView.bottomAnchor).isActive = true
        stackView.initStackView()
    }
    
    func setVocaAndMeaningText(voca: String, meaning: String) {
        stackView.vocaLabel.text = "단어 : \(voca)"
        stackView.meaningLabel.text = "뜻 : \(meaning)"
    }
    
    
    
    
}


