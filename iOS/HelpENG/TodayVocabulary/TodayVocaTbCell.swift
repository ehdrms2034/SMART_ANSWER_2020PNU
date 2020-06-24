//
//  TodayVocaTbCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

protocol TodayVocaTbDataControll {
    
    func controlKorHidden(indexPath: IndexPath, isHidden: Bool)
    func controlEngHidden(indexPath: IndexPath, isHidden: Bool)
}

class TodayVocaTbCell: UITableViewCell {
    
    @IBOutlet weak var hideEngBtn: UIButton!
    @IBOutlet weak var engVocaLabel: UILabel!
    
    @IBOutlet weak var hideKorBtn: UIButton!
    @IBOutlet weak var korVocaLabel: UILabel!
    
    @IBOutlet weak var engVocaView: UIView!
    @IBOutlet weak var korVocaView: UIView!
    // TodayVocaTb <---> TodayVocaTbCell간의 연결고리(Data 수정할때)
    var delegate: TodayVocaTbDataControll?

    var indexPath:IndexPath?
    
    var engBtnIsHidden: Bool = false {
        willSet(newValue) {
            engVocaLabel.isHidden = newValue
            hideEngBtn.backgroundColor = newValue ? #colorLiteral(red: 1, green: 0.3186968267, blue: 0.3049468994, alpha: 1) : #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        }
    }
    
    var korBtnIsHidden: Bool = false {
        willSet(newValue) {
            korVocaLabel.isHidden = newValue
            hideKorBtn.backgroundColor = newValue ? #colorLiteral(red: 1, green: 0.3186968267, blue: 0.3049468994, alpha: 1) : #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        }
    }
    
    var korVocaLabelText: String = "" {
        willSet(newValue) {
            korVocaLabel.text = newValue
        }
    }
    
    var engVocaLabelText:String = "" {
        willSet(newValue) {
            engVocaLabel.text = newValue
        }
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    

    @IBAction func selectEngHiddenBtn(_ sender: Any) {
        engBtnIsHidden ? displayEngVocaLabel() : hideEngVocaLabel()
        delegate?.controlEngHidden(indexPath: indexPath!, isHidden: engBtnIsHidden)
    }
    
    @IBAction func selectKorHiddenBtn(_ sender: Any) {
        korBtnIsHidden ? displayKorVocaLabel() : hideKorVocaLabel()
        delegate?.controlKorHidden(indexPath: indexPath!, isHidden: korBtnIsHidden)
    }
}

extension TodayVocaTbCell: MyColor {
    
    func initCellView(korIsHidden: Bool, engIsHidden: Bool, korText: String, engText: String, indexPath: IndexPath) {
        hideEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.3725490196, green: 0.3764705882, blue: 0.3803921569, alpha: 1), borderWidth: 1)
        hideKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.3725490196, green: 0.3764705882, blue: 0.3803921569, alpha: 1), borderWidth: 1)
        hideEngBtn.layer.cornerRadius = 4
        hideKorBtn.layer.cornerRadius = 4
//        engVocaView.layer.setBorderColorAndWidth(color: mainColor, borderWidth: 2.0)
//        korVocaView.layer.setBorderColorAndWidth(color: mainColor, borderWidth: 2.0)
        
//        engVocaView.layer.addBorder([.bottom], color: mainColor, width: 2.0)
//        korVocaView.layer.addBorder([.bottom], color: mainColor, width: 2.0)

        self.korBtnIsHidden = korIsHidden
        self.engBtnIsHidden = engIsHidden
        self.korVocaLabelText = korText
        self.engVocaLabelText = engText
        self.indexPath = indexPath
    }
}


//MARK: - control hide Function
extension TodayVocaTbCell {
    
    func hideKorVocaLabel() { korBtnIsHidden = true }
    
    func displayKorVocaLabel() { korBtnIsHidden = false }
    
    func hideEngVocaLabel() { engBtnIsHidden = true }
    
    func displayEngVocaLabel() { engBtnIsHidden = false }
}


