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
    case commuicationError = ""
}


/* result : ["response": "error", "message": "로그인 중 오류가 발생했습니다.", "data": "MemberServiceImpl : 유저의 비밀번호가 틀렸습니다."] */

/* ["response": "error", "message": "로그인 중 오류가 발생했습니다.", "data": "MemberServiceImpl : 선택한 유저를 찾을 수가 없습니다."] */


/* SUCCESS: {
    data = "<null>";
    message = "\Ub85c\Uadf8\Uc778\Uc744 \Uc131\Uacf5\Uc801\Uc73c\Ub85c \Uc218\Ud589\Ud588\Uc2b5\Ub2c8\Ub2e4.";
    response = success;
} */
