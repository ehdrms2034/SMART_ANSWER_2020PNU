//
//  VocaTestVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/13.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class VocaTestVC: UIViewController {
    
    @IBOutlet weak var testResultUIView: UIView!
    @IBOutlet weak var scoringBtn: UIView!
    
    
    let testResultTbView: ExpandingTableView = {
        let tableView = ExpandingTableView()
        tableView.initUI()
        return tableView
    }()
    
    @IBAction func touchScoringBtn(_ sender: Any) {
        
    }

    override func viewDidLoad() {
        initUIView()
        initTbView()
        initDelegateAndDataSource()
    }
    
    func initUIView() {
        scoringBtn.backgroundColor = #colorLiteral(red: 1, green: 0.3186968267, blue: 0.3049468994, alpha: 1)
        scoringBtn.layer.cornerRadius = 10
    
    }
    
    func initTbView() {
        testResultUIView.addSubview(testResultTbView)
        
        testResultTbView.translatesAutoresizingMaskIntoConstraints = false
        testResultTbView.leftAnchor.constraint(equalTo: testResultUIView.leftAnchor).isActive = true
        testResultTbView.rightAnchor.constraint(equalTo: testResultUIView.rightAnchor).isActive = true
        testResultTbView.topAnchor.constraint(equalTo: testResultUIView.topAnchor).isActive = true
        testResultTbView.bottomAnchor.constraint(equalTo: testResultUIView.bottomAnchor).isActive = true
    }
    
    func initDelegateAndDataSource() {
        testResultTbView.delegate = self
        testResultTbView.dataSource = self
    }
}

extension VocaTestVC: UITableViewDelegate, UITableViewDataSource {
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return testResultTbView.myData.sectionNumber
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return testResultTbView.numberOfRowsInSection(section: section)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        
        switch indexPath.row {
        case 0:
            let cell = ExpandingTbViewSectionCell()
            cell.takeTextAndPutItOnLabel(text: testResultTbView.getSectionTitle(indexPath: indexPath))
            return cell
        default:
            let cell = ExpandingTbViewRowCell()
            cell.takeTextAndPutItOnLabel(text: testResultTbView.getRowTitle(indexPath: indexPath))
            return cell

        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    
        testResultTbView.expanding(selectedIndexPath: indexPath)
    }
    
    
}
