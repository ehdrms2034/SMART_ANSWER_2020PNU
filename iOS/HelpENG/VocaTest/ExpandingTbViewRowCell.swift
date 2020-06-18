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
    let titleLabelView = UILabel()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        self.selectionStyle = .none
        
        initContainerView()
        initTitleLabelView()
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

extension ExpandingTbViewRowCell {
    
    func initContainerView() {
        self.contentView.addSubview(containerView)
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
        
        // If you want to customize the height of the cell, edit it here.
        // Just change the value of equalToConstant.
        containerView.heightAnchor.constraint(equalToConstant: 50).isActive = true
    }
    
    func initTitleLabelView() {
        self.containerView.addSubview(titleLabelView)
        titleLabelView.translatesAutoresizingMaskIntoConstraints = false
        titleLabelView.leftAnchor.constraint(equalTo: containerView.leftAnchor,
                                             constant: 10).isActive = true
        titleLabelView.rightAnchor.constraint(equalTo: containerView.rightAnchor,
                                              constant: -200).isActive = true
        titleLabelView.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
        titleLabelView.heightAnchor.constraint(equalTo: titleLabelView.widthAnchor, multiplier: 1.0/3.0).isActive = true
    }
}

//MARK: - TableViewCell TitltLabelView text

extension ExpandingTbViewRowCell {
    
    func takeTextAndPutItOnLabel(text: String) {
        titleLabelView.text = text
    }
}

