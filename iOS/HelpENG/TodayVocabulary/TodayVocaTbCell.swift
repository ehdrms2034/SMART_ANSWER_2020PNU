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
    
    // TodayVocaTb <---> TodayVocaTbCell간의 연결고리(Data 수정할때)
    var delegate: TodayVocaTbDataControll?

    var indexPath:IndexPath?
    
    var engBtnIsHidden: Bool = false {
        willSet(newValue) {
            engVocaLabel.isHidden = newValue
            hideEngBtn.backgroundColor = newValue ? #colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1) : #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        }
    }
    
    var korBtnIsHidden: Bool = false {
        willSet(newValue) {
            korVocaLabel.isHidden = newValue
            hideKorBtn.backgroundColor = newValue ? #colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1) : #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        }
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    func initCellView(korIsHidden: Bool, engIsHidden: Bool, indexPath: IndexPath) {
        hideEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
                
        self.korBtnIsHidden = korIsHidden
        self.engBtnIsHidden = engIsHidden
        self.indexPath = indexPath
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


//MARK: - control hide Function
extension TodayVocaTbCell {
    
    func hideKorVocaLabel() { korBtnIsHidden = true }
    
    func displayKorVocaLabel() { korBtnIsHidden = false }
    
    func hideEngVocaLabel() { engBtnIsHidden = true }
    
    func displayEngVocaLabel() { engBtnIsHidden = false }
}


