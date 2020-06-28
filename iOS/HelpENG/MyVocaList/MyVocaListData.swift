//
//  MyVocaListData.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation


protocol MyVocaListDataProtocol {
    var level: Int { get }
    var date: String { get }
    var category: VocaCategory { get }
    var vocaData: [VocaData] { get }
}

// 이게 하나의 set가 됨.
struct MyVocaListData: MyVocaListDataProtocol {
    
    var category: VocaCategory
    var level: Int
    var date: String
    var vocaData: [VocaData]
    
}

enum VocaCategory {
    case wrongVoca
    case recommendVoca
}
