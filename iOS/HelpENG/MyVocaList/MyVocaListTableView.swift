//
//  MyVocaListTableView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class MyVocaListTableView: UITableView {
    
    let totalTbData: MyVocaListTbViewData = MyVocaListTbViewData()
    
    var category: VocaCategory = .wrongVoca {
        willSet(newValue) {
            switch newValue {
            case .wrongVoca:
                self.nowTbData = filterLevel(list: totalTbData.wrongVocaDatas, level: self.level)
                self.sectionNum = nowTbData?.count
                self.reloadData()
                
            case .recommendVoca:
                self.nowTbData = filterLevel(list: totalTbData.recommendVocaDatas, level: self.level)
                self.sectionNum = nowTbData?.count
                self.reloadData()

            }
        }
    }
    
    var level: Int = 1 {
        willSet(newValue) {
            switch category {
            case .wrongVoca:
                self.nowTbData = filterLevel(list: totalTbData.wrongVocaDatas, level: newValue)
                self.sectionNum = nowTbData?.count
                self.reloadData()
                
            case .recommendVoca:
                self.nowTbData = filterLevel(list: totalTbData.recommendVocaDatas, level: newValue)
                self.sectionNum = nowTbData?.count
                self.reloadData()

            }
        }
    }
    
    var sectionNum: Int?
    var nowTbData: [MyVocaListData]?
}

extension MyVocaListTableView {
    
    func filterLevel(list: [MyVocaListData], level: Int) -> [MyVocaListData] {
        var newList:[MyVocaListData] = []
        for item in list where item.level == level{
            newList.append(item)
        }
        newList.sort { $0.date < $1.date }
        return newList
    }
}

extension MyVocaListTableView {
    
    func initUI() {
        self.separatorStyle = .none
        self.tableFooterView = UIView()
        self.estimatedRowHeight = 50
        self.rowHeight = UITableView.automaticDimension
        self.category = .wrongVoca
    }
}
