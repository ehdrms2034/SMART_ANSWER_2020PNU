//
//  VocaTestDataAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/30.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON

struct VocaTestDataAPI {
    
    func getVocaTestData(completion: @escaping ([MyData]) -> ()) {
        let param = ["id":"new"]
//        var data: [String:String] = []
        Alamofire.request(ipAddress + ipData, method: .post, parameters: param, encoding: JSONEncoding.default).responseJSON() { response in
            switch response.result {
            case .success:
                // 통신 성공 여기서 디테일 구분
//                print((JSON(response.result.value)["data"]).type)
//                print(JSON(response.result.value)["data"])
                let data = (JSON(response.result.value))["data"]
//                print(data)
                completion(self.convertMyData(data: data))
                
                
            case .failure:
                // 통신 에러
                print("failure")
            }
            
        }
    }
    
    func convertMyData(data: JSON) -> [MyData] {
        var myData:[MyData] = []
        for item in data {
            
            let date = item.1["date"].stringValue
            let wrongScore = item.1["wrong_count"].intValue
            let rightScore = item.1["answer_count"].intValue
            let level = item.1["level"].intValue
            guard let meanWords = item.1["mean_word"].arrayObject as? [String] else {
                return []
            }
            guard let correctWords = item.1["correct_word"].arrayObject as? [String] else {
                return []
            }
            guard let myCorrectWordS = item.1["my_word"].arrayObject as? [String] else {
                return []
            }
            
            
            let data = MyData(date: date, wrongScore: wrongScore, rightScore: rightScore, level: level, meanWords: meanWords, correctWords: correctWords, myCorrectWordS: myCorrectWordS,imageData: "")
            myData.append(data)
            

            
        }
        return myData
    }
}

extension VocaTestDataAPI: NetWorkProtocol {
    var ipData: String {
        return "/api/wrong/getAllInfo"
    }
}
