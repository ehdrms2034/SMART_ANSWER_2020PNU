//
//  TestResultVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/07/01.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class TestResultVC: UIViewController {
    
    @IBOutlet weak var tbOutsideView: UIView!
    
    let testResultTableView: TestResultTableView = {
        let tableView = TestResultTableView()
        tableView.initUI()
        return tableView
    }()
    
    override func viewDidLoad() {
        initDelegate()
        initTableView()
    }
    
    func initDelegate() {
        testResultTableView.delegate = self
        testResultTableView.dataSource = self
    }
    
    
}

extension TestResultVC: MyColor {
    func initTableView() {
        tbOutsideView.addSubview(testResultTableView)
        testResultTableView.translatesAutoresizingMaskIntoConstraints = false
        testResultTableView.separatorStyle = .none
        testResultTableView.allowsSelection = false
        testResultTableView.topAnchor.constraint(equalTo: tbOutsideView.topAnchor).isActive = true
        testResultTableView.bottomAnchor.constraint(equalTo: tbOutsideView.bottomAnchor).isActive = true
        testResultTableView.rightAnchor.constraint(equalTo: tbOutsideView.rightAnchor).isActive = true
        testResultTableView.leftAnchor.constraint(equalTo: tbOutsideView.leftAnchor).isActive = true
    }
}

extension TestResultVC: UITableViewDataSource, UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 2
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        let data = testResultTableView.totalTbData.testResultDatas
        return data!.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let data = testResultTableView.totalTbData.testResultDatas
        
        switch indexPath.row {
        case 0:
            let cell = TbViewVocaCell()
            let (voca, meaning) = (data![indexPath.section].correctAnswer, data![indexPath.section].mean)
            cell.setVocaAndMeaningText(voca: voca, meaning: meaning)
            return cell
        default:
            let cell = TestResultTbSectionCell()
            cell.setDateLabelText(text: data![indexPath.section].wrongAnswer)
            return cell
            
        }
    }
}
