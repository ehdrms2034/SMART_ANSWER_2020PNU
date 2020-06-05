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
        return "http://15.164.212.98:8080"
        
    }
}
