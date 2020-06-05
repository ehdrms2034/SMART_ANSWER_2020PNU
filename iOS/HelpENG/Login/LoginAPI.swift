//
//  LoginAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/03.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

struct LoginAPI {
    
    func login(userId id: String, userPassword password: String) -> LoginMessage {
        
        do {
            let param:Parameters = ["username": id, "password": password]
            let _ = try tryLogin(param: param, url: self.ipAddress + self.ipData)
            
        } catch LoginError.noValidId {
            return .noValidId
        } catch LoginError.noValidPassword {
            return .noValidPassword
        } catch {
            return .error
        }
        
        return .success
    }
    
    func tryLogin(param: Parameters, url: String) throws -> Int {
        var loginResult = ""
        print("tryLogin")
        Alamofire.request(url, method: .post, parameters: param, encoding: JSONEncoding.default).responseJSON() { response in
            print(response)
            guard let result = response.result.value as? Dictionary<String, String> else {
                return
            }
            print("result : \(result)")
//            loginResult = result["response"]
            
        }
        switch loginResult {
        case "success":
            return 0
        case "fail":
            throw LoginError.noValidId
        default:
            throw LoginError.noValidPassword
            
        }
    }
}

extension LoginAPI: NetWorkProtocol {
    var ipData: String {
        return "/api/member/loginMember"
    }
}

enum LoginError: Error {
    
    case noValidId
    case noValidPassword
}

enum LoginMessage {
    case success
    case noValidId
    case noValidPassword
    case error
}

struct Login: Decodable {
    let username: String
    let password: String
}
