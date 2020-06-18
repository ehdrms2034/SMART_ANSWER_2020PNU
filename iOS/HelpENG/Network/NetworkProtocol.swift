//
//  NetworkProtocol.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/03.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation

protocol NetWorkProtocol {
    
    var ipData: String { get }
}

extension NetWorkProtocol {
    
    var ipAddress: String {
        return "http://54.180.175.238:8080"
        
    }
}
