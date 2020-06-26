//
//  SettingTableView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/26.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class SettingTableView: UITableView {
    
    let data: [SettingItem] = [SettingItem(title: "공지사항", imageName: "gift")]
    
}

extension SettingTableView: MyColor {
    
    func initUI() {
        self.separatorStyle = .none
        self.tableFooterView = UIView()
        self.estimatedRowHeight = 50
        self.rowHeight = UITableView.automaticDimension
    }
}
