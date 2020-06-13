//
//  MyData.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/14.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

protocol MyDataProtocol {
    
    var sectionTitle: String { get }
    var rowsTitles: [String] { get }
    var rowsNumber: Int { get }
    var isOpened:Bool { get set }
    
}

struct MyData: MyDataProtocol {
    
    var isOpened: Bool = false
    
    var sectionTitle: String
    
    var rowsTitles: [String]
    
    var rowsNumber: Int {
        return rowsTitles.count
    }
    
}
