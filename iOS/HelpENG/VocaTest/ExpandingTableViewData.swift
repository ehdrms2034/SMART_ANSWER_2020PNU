//
//  MyTableViewData.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/12.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit


protocol ExpandingTableViewDataProtocol {
    
    var sectionNumber: Int { get }
    var sectionsData: [MyData] { get set }
    
}

struct ExpandingTableViewData: ExpandingTableViewDataProtocol {
    
    var sectionsData = [MyData(sectionTitle: "section1", rowsTitles: ["item1"]),
                        MyData(sectionTitle: "section2", rowsTitles: ["item2", "item2"]),
                        MyData(sectionTitle: "section3", rowsTitles: ["item3", "item3", "item3"])]
    
    var sectionNumber: Int {
        return sectionsData.count
    }

}
