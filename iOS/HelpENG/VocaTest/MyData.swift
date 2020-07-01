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
    var meanWords: [String] { get }
    var correctWords: [String] { get }
    var myCorrectWordS: [String] { get }
    var isOpened:Bool { get set }
    var testResult:Bool { get }
    var point:Int { get }
    
    
}
extension MyDataProtocol {
    var rowsNumber: Int {
        return 1
    }
}

struct MyData: MyDataProtocol {

    // Section Data
    var date: String
    
    var wrongScore: Int
    
    var rightScore: Int
    
    var level: Int

    var isOpened: Bool = false
    
    // Row Data
    var meanWords: [String]
    var correctWords: [String]
    var myCorrectWordS: [String]
    
    var testResult: Bool {
        
        if self.wrongScore >= 5 {
            return false
        } else {
            return true
        }
    }
    
    var imageData: String
    var point: Int = 1

}

