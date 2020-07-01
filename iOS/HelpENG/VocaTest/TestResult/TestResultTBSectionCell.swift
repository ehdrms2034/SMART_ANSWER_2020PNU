//
//  TestResultTBSectionCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/07/01.
//  Copyright © 2020 Wanni. All rights reserved.
//


import UIKit

class TestResultTbSectionCell: UITableViewCell {
    
    let containerView = UIView()
    let myAnswerLabel: UILabel = {
        let label = UILabel()
        label.textColor = #colorLiteral(red: 0.3725490196, green: 0.3764705882, blue: 0.3803921569, alpha: 1)
        return label
    }()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
                
        initContainerView()
        initDateLabel()
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }
    
}

extension TestResultTbSectionCell: MyColor {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor, constant: -15).isActive = true
        containerView.heightAnchor.constraint(equalToConstant: 30).isActive = true
        containerView.backgroundColor = cellBackground
        containerView.layer.cornerRadius = 10
    }
    
    func initDateLabel() {
        self.containerView.addSubview(myAnswerLabel)
        myAnswerLabel.textColor = mainColor
        myAnswerLabel.textAlignment = .center
        myAnswerLabel.translatesAutoresizingMaskIntoConstraints = false
        myAnswerLabel.font = UIFont.boldSystemFont(ofSize: 15)
        myAnswerLabel.leftAnchor.constraint(equalTo: containerView.leftAnchor, constant: 0).isActive = true
        myAnswerLabel.rightAnchor.constraint(equalTo: containerView.rightAnchor, constant: 0).isActive = true
        myAnswerLabel.topAnchor.constraint(equalTo: containerView.topAnchor, constant: 0).isActive = true
        myAnswerLabel.bottomAnchor.constraint(equalTo: containerView.bottomAnchor, constant: 0).isActive = true
    }
}

extension TestResultTbSectionCell {
    
    func setDateLabelText(text: String) {
        myAnswerLabel.text = "오답 : \(text)"
    }
}

