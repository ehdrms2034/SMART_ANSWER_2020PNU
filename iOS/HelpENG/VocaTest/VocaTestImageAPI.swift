//
//  VocaTestImageAPI.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/16.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation
import Alamofire

struct VocaTestImageAPI {
    func imageUpload(image: UIImage, completion: () -> Void) {
        guard let data = image.jpegData(compressionQuality: 0.9) else {
            return
        }

        Alamofire.upload(multipartFormData: { (form) in
            form.append(data, withName: "file")}, to: self.ipAddress + ipData, encodingCompletion: { result in

            switch result {
            case .success(let upload, _, _):
                upload.responseString { response in
                    print(response.value)
                }
            case .failure(let encodingError):
                print(encodingError)

            }
        })
    }
    
     
}

extension VocaTestImageAPI: NetWorkProtocol {
    var ipData: String {
        return "/api/upload/"
    }
}
