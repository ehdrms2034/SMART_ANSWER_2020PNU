//
//  VocaData.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation

protocol VocaDataProtocol {
    var voca: String { get }
    var meaning: String { get }
    var isHide: Bool { get }
}

struct VocaData: VocaDataProtocol {
    var voca: String
    var meaning: String
    var isHide: Bool = false
}
