//
//  SettingVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/25.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class SettingVC: UIViewController {
    
    @IBOutlet weak var userProfileView: UIView!
    @IBOutlet weak var userNameLabel: UILabel!
    @IBOutlet weak var userIdLabel: UILabel!
    @IBOutlet weak var userTodayWordLabel: UILabel!
    @IBOutlet weak var userLevelLabel: UILabel!
    @IBOutlet weak var userImageView: UIImageView!
    @IBOutlet weak var settingTbOutsideView: UIView!
    
    let settingTableView: SettingTableView = {
        let tableView = SettingTableView()
        tableView.initUI()
        return tableView
    }()
    
    override func viewDidLoad() {
        initUserProfileView()
        initTableView()
        initDelegate()
    }
    
    func initDelegate() {
        settingTableView.dataSource = self
        settingTableView.delegate = self
    }
}

extension SettingVC: MyColor {
    
    func initUserProfileView() {
        userProfileView.layer.addBorder([.bottom], color: #colorLiteral(red: 0.921431005, green: 0.9214526415, blue: 0.9214410186, alpha: 1), width: 3)
    }
    
    func initTableView() {
        settingTbOutsideView.addSubview(settingTableView)
        settingTableView.translatesAutoresizingMaskIntoConstraints = false
        settingTableView.leftAnchor.constraint(equalTo: settingTbOutsideView.leftAnchor).isActive = true
        settingTableView.rightAnchor.constraint(equalTo: settingTbOutsideView.rightAnchor).isActive = true
        settingTableView.topAnchor.constraint(equalTo: settingTbOutsideView.topAnchor).isActive = true
        settingTableView.bottomAnchor.constraint(equalTo: settingTbOutsideView.bottomAnchor).isActive = true
        
        
    }
}

extension SettingVC: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return settingTableView.data.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = SettingTableViewCell()
        let (image, title) = (settingTableView.data[indexPath.row].imageName, settingTableView.data[indexPath.row].title)
        cell.titleLabel.text = title
        cell.titleImageView.image = UIImage(systemName: image)?.withTintColor(mainColor, renderingMode: .alwaysOriginal)
        return cell
    }
    
    
}
