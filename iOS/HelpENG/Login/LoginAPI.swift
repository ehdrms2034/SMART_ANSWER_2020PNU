//
//  LoginAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/03.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire

struct LoginAPI {
    
    func login(userId id: String, userPassword: String) -> String {
        
        do {
            let num = try tryLogin()
            
        } catch LoginError.noValidId {
            return "no valid id"
        } catch LoginError.noValidPassword {
            return "no valid password"
        } catch {
            return "error"
        }
        
        return "sucess"
    }
    
    func tryLogin() throws -> Int {
        let num = 1
        switch num {
        case 0:
            return 0
        case 1:
            throw LoginError.noValidId
        default:
            throw LoginError.noValidPassword
            
        }
    }
}

enum LoginError: Error {
    
    case noValidId
    case noValidPassword
}
