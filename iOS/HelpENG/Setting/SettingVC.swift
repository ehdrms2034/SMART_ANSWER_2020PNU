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
        DispatchQueue.main.async {
            self.initUserProfileView()
            self.initTableView()
        }
        initDelegate()

    }
    
    func initDelegate() {
        settingTableView.dataSource = self
        settingTableView.delegate = self
    }
}

extension SettingVC: MyColor {
    
    func initUserProfileView() {
        userNameLabel.text = UserDefaults.standard.string(forKey: "userName")!
        let level = UserDefaults.standard.string(forKey: "userLevel")!
        userLevelLabel.text = "Level \(Int(level)! + 1)"
        userIdLabel.text = UserDefaults.standard.string(forKey: "userID")!
        let point = UserDefaults.standard.string(forKey: "userPoint")!
        userTodayWordLabel.text = "다음 level까지 \(30 - Int(point)!)번 PASS"
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
        DispatchQueue.main.async {
            let (image, title) = (self.settingTableView.data[indexPath.row].imageName, self.settingTableView.data[indexPath.row].title)
            cell.titleLabel.text = title
            cell.titleImageView.image = UIImage(systemName: image)?.withTintColor(self.mainColor, renderingMode: .alwaysOriginal)
        }
        
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    }
    
}
