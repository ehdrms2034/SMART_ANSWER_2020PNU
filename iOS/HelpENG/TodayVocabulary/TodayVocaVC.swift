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
    @IBOutlet weak var categoryOutsideView: UIView!
    
    @IBAction func selectHideAllEngBtn(_ sender: Any) {
        todayVocaTb.controlAllLabel(isHidden: hideAllEngBtn.isSelected, language: .eng)
        hideAllEngBtn.isSelected == true ? (hideAllEngBtn.isSelected = false) : (hideAllEngBtn.isSelected = true)
        changeEngBtnColor(isSelected: hideAllEngBtn.isSelected)
        todayVocaTb.reloadData()
    }
    
    @IBAction func selectHideAllKorBtn(_ sender: Any) {
        todayVocaTb.controlAllLabel(isHidden: hideAllKorBtn.isSelected, language: .kor)
        hideAllKorBtn.isSelected == true ? (hideAllKorBtn.isSelected = false) : (hideAllKorBtn.isSelected = true)
        changeKorBtnColor(isSelected: hideAllKorBtn.isSelected)
        
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
extension TodayVocaVC:MyColor {
    
    func initView() {
        hideAllEngBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllKorBtn.layer.setBorderColorAndWidth(color: #colorLiteral(red: 0.2549019754, green: 0.2745098174, blue: 0.3019607961, alpha: 1), borderWidth: 1)
        hideAllEngBtn.layer.cornerRadius = 4
        hideAllKorBtn.layer.cornerRadius = 4
        hideAllKorBtn.tintColor = clearColor
        hideAllEngBtn.tintColor = clearColor
        categoryOutsideView.layer.addBorder([.bottom], color: mainColor, width: 1.0)
    }
    
    func changeKorBtnColor(isSelected: Bool) {
        isSelected ? (hideAllKorBtn.backgroundColor = mainColor) : (hideAllKorBtn.backgroundColor = clearColor)
    }
    
    func changeEngBtnColor(isSelected: Bool) {
        isSelected ? (hideAllEngBtn.backgroundColor = mainColor) : (hideAllEngBtn.backgroundColor = clearColor)
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


