//
//  SettingTableViewCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/26.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class SettingTableViewCell: UITableViewCell {
    
    let containerView = UIView()
    let titleLabel = UILabel()
    let nextImageView = UIImageView()
    let titleImageView = UIImageView()
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        initContainerView()
        initTitleImageView()
        initNextImageView()
        initTitleLabel()
        
//        initStackView()
       
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
    }

}

extension SettingTableViewCell: MyColor {
    
    func initContainerView() {
        contentView.addSubview(containerView)
        containerView.backgroundColor = clearColor
        containerView.translatesAutoresizingMaskIntoConstraints = false
        containerView.heightAnchor.constraint(equalToConstant: 60).isActive = true
        containerView.leftAnchor.constraint(equalTo: contentView.leftAnchor).isActive = true
        containerView.rightAnchor.constraint(equalTo: contentView.rightAnchor).isActive = true
        containerView.topAnchor.constraint(equalTo: contentView.topAnchor).isActive = true
        containerView.bottomAnchor.constraint(equalTo: contentView.bottomAnchor).isActive = true
    }
    
    func initTitleLabel() {
        containerView.addSubview(titleLabel)
        titleLabel.textColor = mainColor
        titleLabel.font = UIFont.boldSystemFont(ofSize: 20)
        titleLabel.translatesAutoresizingMaskIntoConstraints = false
        titleLabel.leftAnchor.constraint(equalTo: titleImageView.rightAnchor, constant: 10).isActive = true
        titleLabel.rightAnchor.constraint(equalTo: nextImageView.leftAnchor, constant: -10).isActive = true
        titleLabel.heightAnchor.constraint(equalTo: containerView.widthAnchor, multiplier: 1.0/10.0).isActive = true
        titleLabel.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
    }
    
    func initNextImageView() {
        containerView.addSubview(nextImageView)
        nextImageView.translatesAutoresizingMaskIntoConstraints = false
        let image = UIImage(systemName: "chevron.right")
        nextImageView.image = image?.withTintColor(mainColor, renderingMode: .alwaysOriginal)
        nextImageView.rightAnchor.constraint(equalTo: containerView.rightAnchor, constant: -10).isActive = true
        nextImageView.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
        nextImageView.heightAnchor.constraint(equalTo: containerView.heightAnchor, multiplier: 1.0/3.0).isActive = true
        nextImageView.widthAnchor.constraint(equalTo: nextImageView.heightAnchor, multiplier: 1).isActive = true
    }
    
    func initTitleImageView() {
        containerView.addSubview(titleImageView)
        titleImageView.translatesAutoresizingMaskIntoConstraints = false
        titleImageView.leftAnchor.constraint(equalTo: containerView.leftAnchor, constant: 10).isActive = true
        titleImageView.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
        titleImageView.heightAnchor.constraint(equalTo: containerView.heightAnchor, multiplier: 1.0/3.0).isActive = true
        titleImageView.widthAnchor.constraint(equalTo: titleImageView.heightAnchor, multiplier: 1).isActive = true
    }
}
