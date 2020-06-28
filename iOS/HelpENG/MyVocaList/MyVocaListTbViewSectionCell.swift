//
//  MyVocaListTbViewSectionCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class MyVocaListTbViewSectionCell: UITableViewCell {
    
    let containerView = UIView()
    let dateLabel: UILabel = {
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

extension MyVocaListTbViewSectionCell {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        containerView.heightAnchor.constraint(equalToConstant: 25).isActive = true
    }
    
    func initDateLabel() {
        self.containerView.addSubview(dateLabel)
        dateLabel.translatesAutoresizingMaskIntoConstraints = false
        dateLabel.leftAnchor.constraint(equalTo: containerView.leftAnchor, constant: 15).isActive = true
        dateLabel.heightAnchor.constraint(equalTo: containerView.heightAnchor, multiplier: 1.0/1.5).isActive = true
        dateLabel.heightAnchor.constraint(equalTo: dateLabel.widthAnchor, multiplier: 1.0/10.0).isActive = true
        dateLabel.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
    }
}

extension MyVocaListTbViewSectionCell {
    
    func setDateLabelText(text: String) {
        dateLabel.text = text
    }
}
