//
//  TodayVocaTbCell.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TodayVocaTbCell: UITableViewCell {
    
    @IBOutlet weak var hideEngBtn: UIButton!
    @IBOutlet weak var engVocaLabel: UILabel!
    
    @IBOutlet weak var hideKorBtn: UIButton!
    @IBOutlet weak var korVocaLabel: UILabel!
    
    
    override func awakeFromNib() {
        super.awakeFromNib()
    }
    
    func initCellView() {

        hideEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func hideKorVocaLabel() {
        korVocaLabel.isHidden = true
        hideKorBtn.backgroundColor = #colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1)
    }
    
    func displayKorVocaLabel() {
        korVocaLabel.isHidden = false
        hideKorBtn.backgroundColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
    }
    
    func hideEngVocaLabel() {
        engVocaLabel.isHidden = true
        hideEngBtn.backgroundColor = #colorLiteral(red: 0.2196078449, green: 0.007843137719, blue: 0.8549019694, alpha: 1)
    }
    
    func displayEngVocaLabel() {
        engVocaLabel.isHidden = false
        hideEngBtn.backgroundColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
    }
    
    @IBAction func selectEngHiddenBtn(_ sender: Any) {
        engVocaLabel.isHidden ? displayEngVocaLabel() : hideEngVocaLabel()
    }
    
    @IBAction func selectKorHiddenBtn(_ sender: Any) {
        korVocaLabel.isHidden ? displayKorVocaLabel() : hideKorVocaLabel()
    }
}


