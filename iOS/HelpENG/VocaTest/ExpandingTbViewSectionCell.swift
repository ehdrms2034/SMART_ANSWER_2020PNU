//
//  ExpandingTableViewCell.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/14.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

protocol ExpandingTbViewSectionCellProtocol {
    func expanding(selectedIndexPath indexPath :IndexPath, completion: (_ isOpend:Bool)->())
}

class ExpandingTbViewSectionCell: UITableViewCell {
    
    let containerView = UIView()
    let dateLabel = UILabel()
    let stackView = ExpandingTbViewSectionStackView()
    let expandingBtn = UIButton()
    
    var indexPath: IndexPath?
    var delegate: ExpandingTbViewSectionCellProtocol?
    
    var sectionIsOpened: Bool = false {
        willSet(newValue) {
            expandingBtnImageSetup(isOpened: newValue, duration: 0.0)
        }
    }
    
    override init(style: UITableViewCell.CellStyle, reuseIdentifier: String?) {
        super.init(style: style, reuseIdentifier: reuseIdentifier)
        
        self.selectionStyle = .none
        self.backgroundColor = clearColor
        initContainerView()
        initTitleLabelView()
        initStackView()
        initExpandingBtn()
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
        containerView.backgroundColor = cellBackground
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
        dateLabel.textColor = .black
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
    
    func initExpandingBtn() {
        containerView.addSubview(expandingBtn)
        expandingBtn.translatesAutoresizingMaskIntoConstraints = false
        let image = UIImage(systemName: "arrowtriangle.down.fill")
        expandingBtn.setImage(image?.withTintColor(mainColor, renderingMode: .alwaysOriginal)
, for: .normal)
        expandingBtn.heightAnchor.constraint(equalTo: containerView.heightAnchor, multiplier: 1.0/4.0).isActive = true
        expandingBtn.widthAnchor.constraint(equalTo: expandingBtn.heightAnchor, multiplier: 1.0).isActive = true
        expandingBtn.rightAnchor.constraint(equalTo: containerView.rightAnchor, constant: -10).isActive = true
        expandingBtn.centerYAnchor.constraint(equalTo: containerView.centerYAnchor).isActive = true
        expandingBtn.addTarget(self, action: #selector(touchExpandingBtn), for: .touchUpInside)
        
    }
    
    func expandingBtnImageSetup(isOpened: Bool, duration: CGFloat = 0.4) {
        switch isOpened {
        case true:
            UIView.animate(withDuration: TimeInterval(duration), animations: {
                self.expandingBtn.transform = CGAffineTransform(rotationAngle: (180.0 * CGFloat(Double.pi)) / 180.0)
            })
        default:
            UIView.animate(withDuration: TimeInterval(duration), animations: {
                self.expandingBtn.transform = CGAffineTransform(rotationAngle: (0.0 * CGFloat(Double.pi)) / 180.0)
            })
        }
//        isOpened ? expandingBtn.setImage(UIImage(systemName: "arrowtriangle.up.fill"), for: .normal) : expandingBtn.setImage(UIImage(systemName: "arrowtriangle.down.fill"), for: .normal)
    }
}

extension ExpandingTbViewSectionCell {
    
    @objc func touchExpandingBtn() {
        guard let indexPath = self.indexPath else {
            return
        }
        self.delegate?.expanding(selectedIndexPath: indexPath,completion: {(isOpened) in
            expandingBtnImageSetup(isOpened: isOpened)
        })
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
