//
//  TodayVocaVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TodayVocaVC: UIViewController {
    
    @IBOutlet weak var todayVocaTableView: UITableView!
    let todayVocaTbData = TodayVocaTbData()
    @IBOutlet weak var hideAllEngBtn: UIButton!
    @IBOutlet weak var hideAllKorBtn: UIButton!
    
    @IBAction func selectHideAllEngBtn(_ sender: Any) {
        controlAllLabel(isHidden: hideAllEngBtn.isSelected, language: "eng")
    }
    
    @IBAction func selectHideAllKorBtn(_ sender: Any) {
        controlAllLabel(isHidden: hideAllKorBtn.isSelected, language: "kor")

    }
    
    
    override func viewDidLoad() {
        initView()
    }
    
    func initView() {
        hideAllEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllKorBtn.tintColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        hideAllEngBtn.tintColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)

    }
    
    func controlAllLabel(isHidden: Bool, language: String) {
        
        for num in 0..<todayVocaTbData.vocasData.count {
            let indexPath = IndexPath(row: num, section: 0)
            guard let cell = todayVocaTableView.cellForRow(at: indexPath) as? TodayVocaTbCell else {
                return
            }
            
            if isHidden {
                language == "kor" ? cell.displayKorVocaLabel() : cell.displayEngVocaLabel()
                language == "kor" ? (hideAllKorBtn.isSelected = false) : (hideAllEngBtn.isSelected = false)
            } else {
                language == "kor" ? cell.hideKorVocaLabel() : cell.hideEngVocaLabel()
                language == "kor" ? (hideAllKorBtn.isSelected = true) : (hideAllEngBtn.isSelected = true)

            }
        }
    }
}

extension TodayVocaVC: UITableViewDataSource, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.todayVocaTbData.vocasData.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "TodayVocaTbCell") as? TodayVocaTbCell else {
            return UITableViewCell()
        }
        
        cell.initCellView()
        
        return cell
    }
}


