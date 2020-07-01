//
//  SettingTableView.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/26.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class SettingTableView: UITableView {
    
    let data: [SettingItem] = [SettingItem(title: "공지사항", imageName: "gift"), SettingItem(title: "환경설정", imageName: "gear"), SettingItem(title: "친구", imageName: "person.2.fill"),SettingItem(title: "앱 정보", imageName: "info.circle.fill")]
    
}

extension SettingTableView: MyColor {
    
    func initUI() {
        self.separatorStyle = .none
        self.tableFooterView = UIView()
        self.estimatedRowHeight = 50
        self.rowHeight = UITableView.automaticDimension
        self.tintColor = #colorLiteral(red: 0.8156862745, green: 0.8156862745, blue: 0.8156862745, alpha: 1)
    }
}
