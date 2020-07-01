//
//  ExpandingTbViewRowCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/13.
//  Copyright © 2020 Wanni. All rights reserved.
//

//
//  ExpandingTableViewCell.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/14.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class ExpandingTbViewRowCell: UITableViewCell {
    
    let containerView = UIView()
    let testPaperImageView = UIImageView()
    let stackView = ExpandingTbViewRowStackView()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        self.selectionStyle = .none
        
        initContainerView()
        initTestPaperImageView()
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

extension ExpandingTbViewRowCell: MyColor {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        
        // If you want to customize the height of the cell, edit it here.
        // Just change the value of equalToConstant.
        containerView.heightAnchor.constraint(equalToConstant: 150).isActive = true
    }
    
    func initTestPaperImageView() {
        self.containerView.addSubview(testPaperImageView)
        testPaperImageView.translatesAutoresizingMaskIntoConstraints = false
        testPaperImageView.leftAnchor.constraint(equalTo: containerView.leftAnchor, constant: 20).isActive = true
        testPaperImageView.topAnchor.constraint(equalTo: containerView.topAnchor, constant: 3).isActive = true
        testPaperImageView.bottomAnchor.constraint(equalTo: containerView.bottomAnchor, constant: -3).isActive = true
        testPaperImageView.widthAnchor.constraint(equalTo: testPaperImageView.heightAnchor, multiplier: 1.0/1.8).isActive = true
        testPaperImageView.backgroundColor = clearColor
        testPaperImageView.layer.borderWidth = 1
        testPaperImageView.layer.borderColor = mainColor.cgColor
        testPaperImageView.contentMode = .scaleToFill
        testPaperImageView.layer.cornerRadius = 10
    }
    
    func initStackView() {
        self.containerView.addSubview(stackView)
        stackView.translatesAutoresizingMaskIntoConstraints = false
        stackView.leftAnchor.constraint(equalTo: testPaperImageView.rightAnchor, constant: 5).isActive = true
        stackView.rightAnchor.constraint(equalTo: containerView.rightAnchor, constant: -20).isActive = true
        stackView.topAnchor.constraint(equalTo: containerView.topAnchor, constant: 3).isActive = true
        stackView.bottomAnchor.constraint(equalTo: containerView.bottomAnchor, constant: -3).isActive = true
        stackView.initSubView()
    }
}

//MARK: - TableViewCell TitltLabelView text

extension ExpandingTbViewRowCell {
    
    
}

