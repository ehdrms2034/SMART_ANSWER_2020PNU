//
//  ExpandingTableViewCell.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/14.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class ExpandingTbViewSectionCell: UITableViewCell {
    
    let containerView = UIView()
    let dateLabel = UILabel()
    let stackView = ExpandingTbViewSectionStackView()
    
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        self.selectionStyle = .none
        self.backgroundColor = clearColor
        initContainerView()
        initTitleLabelView()
        initStackView()
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
}

//MARK: - TableViewCell InitUI

// If you want to customize the cell's UI, edit it here.

extension ExpandingTbViewSectionCell: MyColor {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.backgroundColor = mainColor
        containerView.layer.cornerRadius = 10
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor, constant:  10).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor, constant:  -10).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor, constant:  10).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant:  -10).isActive = true
        
        // If you want to customize the height of the cell, edit it here.
        // Just change the value of equalToConstant.
        containerView.heightAnchor.constraint(equalToConstant: 70).isActive = true
    }
    
    func initTitleLabelView() {
        self.containerView.addSubview(dateLabel)
        dateLabel.backgroundColor = clearColor
        dateLabel.textColor = textColor
        dateLabel.translatesAutoresizingMaskIntoConstraints = false
        dateLabel.leftAnchor.constraint(equalTo: containerView.leftAnchor,
                                             constant: 10).isActive = true
        dateLabel.rightAnchor.constraint(equalTo: containerView.rightAnchor,
                                              constant: -200).isActive = true
        dateLabel.topAnchor.constraint(equalTo: containerView.topAnchor, constant: 10).isActive = true
        dateLabel.widthAnchor.constraint(equalTo: dateLabel.heightAnchor, multiplier: 10.0/1.0).isActive = true
    }
    
    func initStackView() {
        self.containerView.addSubview(stackView)
        stackView.backgroundColor = clearColor
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.leftAnchor.constraint(equalTo: containerView.leftAnchor,constant: 10).isActive = true
        stackView.rightAnchor.constraint(equalTo: containerView.rightAnchor, constant: -100).isActive = true
        stackView.topAnchor.constraint(equalTo: dateLabel.bottomAnchor, constant: 5).isActive = true
        stackView.bottomAnchor.constraint(equalTo: containerView.bottomAnchor, constant: -10).isActive = true
        stackView.setupStackView()
        
    }
}

//MARK: - TableViewCell TitltLabelView text 

extension ExpandingTbViewSectionCell {
    
    func takeTextAndPutItOnLabel(date: String) {
        dateLabel.text = date
    }
    
    func takeTextAndPutItInStackView(level: Int, correct: Int, wrong: Int) {
        stackView.levelLabel.text = "level : \(level)"
        stackView.correctAnswerLabel.text = "correct : \(correct)"
        stackView.wrongAnswerLabel.text = "wrong : \(wrong)"
    }
}
