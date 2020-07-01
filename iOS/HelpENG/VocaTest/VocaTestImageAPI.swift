//
//  VocaTestImageAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/16.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire
import SwiftyJSON



class VocaTestImageAPI {
    
    func imageUpload(image: UIImage, completion: () -> Void) {
        guard let imageData = image.jpegData(compressionQuality: 0.4) else {
            return
        }
    
        
        let parameters = ["date":"2020_06_20", "userID": "new"] //Optional for extra parameter
        //"ProfilePic_\(UserDefaults.standard.string(forKey: "user_id") ?? ""
        Alamofire.upload(multipartFormData: { multipartFormData in
            multipartFormData.append(imageData, withName: "imgFile", fileName: "ProfilePic_youwan.jpg", mimeType: "image/jpg")
            for (key, value) in parameters {
                multipartFormData.append((value as AnyObject).data(using: String.Encoding.utf8.rawValue)!, withName: key)
            } //Optional for extra parameters
        },
                         to:self.ipAddress + ipData)
        { (result) in
            switch result {
            case .success(let upload, _, _):

                upload.uploadProgress(closure: { (progress) in
                    print("Upload Progress: \(progress.fractionCompleted)")
                })

                upload.responseJSON { response in
                    print(response.result.value)
                }

            case .failure(let encodingError):
                print(encodingError)
            }
        }
    }
    
    func imageDownLoad(dates:[String], completion: @escaping ([String])->()) {
        var result:[String] = []
        DispatchQueue.global(qos: .userInitiated).async {
            let downloadGroup = DispatchGroup()

            for date in dates {
                downloadGroup.enter()

                let param = ["date":date, "id":"new"]
                Alamofire.request(self.ipAddress + self.secIpData, method: .post, parameters: param, encoding: JSONEncoding.default).responseJSON() { response in
                    switch response.result {
                    case .success:
                        
                        let data = (JSON(response.result.value))["data"].stringValue
                        result.append(data)
                        downloadGroup.leave()
                      
                    case .failure:
                        print("error")
                        downloadGroup.leave()
                        
                    }
                }
            }
            downloadGroup.wait()
            DispatchQueue.main.async {
                completion(result)
            }
        }
        
        
        
        
        
    }
    
    /*.responseData { response in
    print(response)
    if let data = response.result.value {
        let image = UIImage(data: data)
        print(image)
        
    }*/
     
}

extension VocaTestImageAPI: NetWorkProtocol {
    var secIpData: String {
        return "/api/upload/getImageOfUser"
    }
    
    var ipData: String {
        return "/api/upload/"
    }
}
