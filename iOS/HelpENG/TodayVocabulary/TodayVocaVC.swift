//
//  TodayVocaVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TodayVocaVC: UIViewController {
    
    @IBOutlet weak var todayVocaTb: TodayVocaTb!
    
    @IBOutlet weak var hideAllEngBtn: UIButton!
    @IBOutlet weak var hideAllKorBtn: UIButton!
    @IBOutlet weak var shuffleBtn: UIButton!
    
    @IBAction func selectHideAllEngBtn(_ sender: Any) {
        todayVocaTb.controlAllLabel(isHidden: hideAllEngBtn.isSelected, language: .eng)
        hideAllEngBtn.isSelected == true ? (hideAllEngBtn.isSelected = false) :(hideAllEngBtn.isSelected = true)
        todayVocaTb.reloadData()
    }
    
    @IBAction func selectHideAllKorBtn(_ sender: Any) {
        todayVocaTb.controlAllLabel(isHidden: hideAllKorBtn.isSelected, language: .kor)
        hideAllKorBtn.isSelected == true ? (hideAllKorBtn.isSelected = false) :(hideAllKorBtn.isSelected = true)
        todayVocaTb.reloadData()

    }
    
    @IBAction func touchShuffleBtn(_ sender: Any) {
        todayVocaTb.todayVocaTbData.vocasData.shuffle()
        todayVocaTb.reloadData()
    }
    
    override func viewDidLoad() {
        initView()
    }
}

//MARK: - init View
extension TodayVocaVC {
    
    func initView() {
        hideAllEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllKorBtn.tintColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
        hideAllEngBtn.tintColor = #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
    }
}

//MARK: - TableView extension
extension TodayVocaVC: UITableViewDataSource, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        guard let tableView = tableView as? TodayVocaTb else {
            return 0
        }
        return tableView.todayVocaTbData.vocasData.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let tableView = tableView as? TodayVocaTb else { return UITableViewCell() }
        
        guard let cell = tableView.dequeueReusableCell(withIdentifier: "TodayVocaTbCell") as? TodayVocaTbCell else {
            return UITableViewCell()
        }
        
        cell.delegate = tableView
        let (korIsHidden, engIsHidden, korText, engText) = tableView.todayVocaTbData.getTbDataForCellInt(indexPath: indexPath)
        
        cell.initCellView(korIsHidden: korIsHidden, engIsHidden: engIsHidden, korText: korText, engText: engText ,indexPath: indexPath)
        
        return cell
    }
}


