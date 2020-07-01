//
//  MyVocaList.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class MyVocaListVC:UIViewController {
    
    @IBOutlet weak var levelBtn: UIButton!
    
    @IBOutlet weak var categoryBtnOutsideView: UIView!
    @IBOutlet weak var wrongVocaBtn: UIView!
    @IBOutlet weak var recommendVocaBtn: UIView!
    @IBOutlet weak var wrongVocaLabel: UILabel!
    @IBOutlet weak var recommendVocaLabel: UILabel!
    @IBOutlet weak var myVocaListTbOutsideView: UIView!
    
    let vocaListTableView: MyVocaListTableView = {
        let tableView = MyVocaListTableView()
        tableView.initUI()
        return tableView
    }()
    
    var vocaCategory:VocaCategory = .wrongVoca {
        willSet(newValue) {
            changeCategoryBtnUI(category: newValue)
            vocaListTableView.category = newValue
        }
    }
    
    @IBAction func touchWrongVocaBtn(_ sender: Any) {
        
        if vocaCategory == .recommendVoca {
            vocaCategory = .wrongVoca
        }
    }
    
    @IBAction func touchRecommendVocaBtn(_ sender: Any) {
        if vocaCategory == .wrongVoca {
            vocaCategory = .recommendVoca
        }
    }
    
    @IBAction func touchLevelBtn(_ sender: Any) {
        if vocaListTableView.level == 5 {
            vocaListTableView.level = 1
            levelBtn.setTitle("level\(vocaListTableView.level)", for: .normal)
        } else {
            vocaListTableView.level += 1
            levelBtn.setTitle("level\(vocaListTableView.level)", for: .normal)
        }
    }
    
    override func viewDidLoad() {
        initTableView()
        initCategoryBtnStackView()
        initLevelBtn()
        initDelegate()
    }
    
    func initDelegate() {
        vocaListTableView.dataSource = self
        vocaListTableView.delegate = self
    }
    
}

//MARK: - MyVocaListVC setup View, setup categoryBtn
extension MyVocaListVC: MyColor {
    
    func initTableView() {
        myVocaListTbOutsideView.addSubview(vocaListTableView)
        vocaListTableView.translatesAutoresizingMaskIntoConstraints = false
        vocaListTableView.separatorStyle = .none
        vocaListTableView.allowsSelection = false
        vocaListTableView.topAnchor.constraint(equalTo: myVocaListTbOutsideView.topAnchor).isActive = true
        vocaListTableView.bottomAnchor.constraint(equalTo: myVocaListTbOutsideView.bottomAnchor).isActive = true
        vocaListTableView.rightAnchor.constraint(equalTo: myVocaListTbOutsideView.rightAnchor).isActive = true
        vocaListTableView.leftAnchor.constraint(equalTo: myVocaListTbOutsideView.leftAnchor).isActive = true
    }
    
    func initCategoryBtnStackView() {
        categoryBtnOutsideView.layer.borderWidth = 1
        categoryBtnOutsideView.layer.borderColor = #colorLiteral(red: 0.2030145526, green: 0.2030202448, blue: 0.203017205, alpha: 1)
    }
    
    func initLevelBtn() {
        levelBtn.layer.cornerRadius = 5
        levelBtn.layer.borderWidth = 1
        levelBtn.layer.borderColor = #colorLiteral(red: 0.2030145526, green: 0.2030202448, blue: 0.203017205, alpha: 1)
    }
    
}

extension MyVocaListVC {
    
    func changeCategoryBtnUI(category: VocaCategory) {
        switch category {
        case .wrongVoca:
            UIView.animate(withDuration: 0.5, animations: {
                self.wrongVocaBtn.backgroundColor = self.mainColor
            })
            self.wrongVocaLabel.textColor = .white
            self.recommendVocaLabel.textColor = self.mainColor
            self.recommendVocaBtn.backgroundColor = .white

            
            
        case .recommendVoca:
            UIView.animate(withDuration: 0.5, animations: {
                self.recommendVocaBtn.backgroundColor = self.mainColor
            })
            self.wrongVocaLabel.textColor = self.mainColor
            self.wrongVocaBtn.backgroundColor = .white
            self.recommendVocaLabel.textColor = .white

            


        }
    }
}

extension MyVocaListVC: UITableViewDataSource, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        guard let data = vocaListTableView.nowTbData else {
            return 0
        }
        
        return data[section].vocaData.count + 1
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        guard let sectionNum = vocaListTableView.sectionNum else {
            return 0
        }
        return sectionNum
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        guard let data = vocaListTableView.nowTbData else {
            let cell = UITableViewCell()
            return cell
        }
        
        switch indexPath.row {
        case 0:
            let cell = MyVocaListTbViewSectionCell()
            cell.setDateLabelText(text: data[indexPath.section].date)
            return cell
        default:
            let cell = TbViewVocaCell()
            let (voca, meaning) = (data[indexPath.section].vocaData[indexPath.row-1].voca, data[indexPath.section].vocaData[indexPath.row-1].meaning)
            cell.setVocaAndMeaningText(voca: voca, meaning: meaning)
            return cell
            
        }
    }
    
    
}
