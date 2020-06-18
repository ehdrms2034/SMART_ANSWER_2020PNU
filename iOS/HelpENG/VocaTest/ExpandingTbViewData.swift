//
//  MyTableViewData.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/12.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit


protocol ExpandingTbViewDataProtocol {
    
    var sectionNumber: Int { get }
    var sectionsData: [MyData] { get set }
    
}

struct ExpandingTbViewData: ExpandingTbViewDataProtocol {
    
    var sectionsData = [MyData(date: "2020.06.18", wrongScore: 0 , rightScore: 10, level: 1, rowsTitles: ["item1"]),
                        MyData(date: "2020.06.18", wrongScore: 5 , rightScore: 5, level: 3,rowsTitles: ["item2"]),
                        MyData(date: "2020.06.18", wrongScore: 8 , rightScore: 2, level: 2,rowsTitles: ["item3"])]
    
    var sectionNumber: Int {
        return sectionsData.count
    }

}
