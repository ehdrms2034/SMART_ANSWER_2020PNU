//
//  MemberAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/07/01.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

struct MemverAPI {
    
    func getMemberInfo(id: String, completion: @escaping ()->()) {
        print(id)
        let param: Parameters = ["username":id]
        let url = ipAddress + ipData
        Alamofire.request(url, method: .get, parameters: param).responseJSON { response in
            switch response.result {
            case .success:
                // 통신 성공 여기서 디테일 구분
                
                let data = (JSON(response.result.value))["data"]
                print(data)
                print(data["name"].stringValue)
                UserDefaults.standard.set(data["name"].stringValue, forKey: "userName")
                UserDefaults.standard.set(data["level"].stringValue, forKey: "userLevel")
                UserDefaults.standard.set(data["point"].stringValue, forKey: "userPoint")
                completion()
                
            case .failure:
                // 통신 에러
                print("failure")
            }
        }
    }
}

extension MemverAPI: NetWorkProtocol {
    var ipData: String {
        return "/api/member/"
    }
}
