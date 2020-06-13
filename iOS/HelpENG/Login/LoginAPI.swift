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
    
    
    func login(userId id: String, userPassword password: String, completion : @escaping (LoginMessage)->(Void)){
        let param:Parameters = ["username": id, "password": password]
        tryLogin(param: param, url: self.ipAddress + self.ipData, completion: { message in
            completion(message)
        })
        
    }
    
    private func tryLogin(param: Parameters, url: String, completion: @escaping (LoginMessage)->(Void)) {
        var loginResult: LoginMessage = .commuicationError
        print("start tryLogin func")
        Alamofire.request(url, method: .post, parameters: param, encoding: JSONEncoding.default).responseJSON() { response in
            
            switch response.result {
            case .success:
                // 통신 성공 여기서 디테일 구분
                guard let result = response.result.value as? Dictionary<String, String> else {
                    loginResult = .commuicationError
                    return
                }
                switch result["message"]! {
                case LoginMessage.success.rawValue:
                    loginResult = .success
                default:
                    loginResult = .noValid
                }
                
            case .failure:
                // 통신 에러
                loginResult = .commuicationError
                print("failure")
            }
            
            completion(loginResult)
        }
        
        
    }
}

extension LoginAPI: NetWorkProtocol {
    var ipData: String {
        return "/api/member/loginMember"
    }
}

enum LoginMessage: String {
    case success = "로그인을 성공적으로 수행했습니다."
    case noValid = "로그인 중 오류가 발생했습니다."
    case commuicationError
}
