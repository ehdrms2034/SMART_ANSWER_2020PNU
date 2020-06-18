//
//  JoinAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/05.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

struct JoinAPI {
    
    func join(userName name: String, userId id: String, userPassword password: String, completion: @escaping (JoinMessage)->(Void)) {
        
        let param: Parameters = ["name": name, "password": id, "username": password]
        tryJoin(param: param, url: self.ipAddress + self.ipData, completion: { result in
            completion(result)
        })
        
    }
    
    private func tryJoin(param:Parameters, url: String, completion: @escaping (JoinMessage)->(Void)) {
        var joinResult: JoinMessage = .joinFail
        Alamofire.request(url, method: .post, parameters: param, encoding: JSONEncoding.default).responseJSON() { response in
            
            switch response.result {
            case .success:
                // 통신 성공 여기서 디테일 구분
                let message = (JSON(response.result.value))["message"].stringValue
                switch message {
                case JoinMessage.joinSuccess.rawValue:
                    joinResult = .joinSuccess
                default:
                    joinResult = .joinFail
                }
            case .failure:
                // 통신 에러
                joinResult = .communicationError
            }
            completion(joinResult)
        }
        
    }
}

extension JoinAPI: NetWorkProtocol {
    
    var ipData: String {
        return "/api/member/createMember"
    }
}

enum JoinMessage: String {
    case joinSuccess = "회원가입이 성공적으로 완료됐습니다."
    case joinFail = "회원가입중 문제가 발생했습니다."
    case communicationError
}
