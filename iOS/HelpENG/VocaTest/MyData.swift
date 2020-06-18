//
//  MyData.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/14.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

protocol MyDataProtocol {
    
    var date: String { get }
    var wrongScore: Int { get }
    var rightScore : Int { get }
    var level: Int { get }
    var rowsTitles: [String] { get }
    var rowsNumber: Int { get }
    var isOpened:Bool { get set }
    
}

struct MyData: MyDataProtocol {

    // Section Data
    var date: String
    
    var wrongScore: Int
    
    var rightScore: Int
    
    var level: Int

    var isOpened: Bool = false
    
    // Row Data
    var rowsTitles: [String]
    
    var rowsNumber: Int {
        return rowsTitles.count
    }
    
}
