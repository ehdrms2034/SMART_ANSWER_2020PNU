//
//  MyTableViewData.swift
//  ExpandingTableView
//
//  Created by Wanni on 2020/05/12.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit


protocol ExpandingTbViewDataProtocol {
    func reloadTableView()
    
}

class ExpandingTbViewData {
    let dataApi = VocaTestDataAPI()
    let imageApi = VocaTestImageAPI()
    var stop:Bool = false
    var delegate: ExpandingTbViewDataProtocol?
    
    var sectionsData: [MyData] = [] {
        willSet(newValue) {
            
        }
    }
    
//    var urlData: [String] = [] {
//        willSet(newValue) {
//            print(sectionsData.count)
//            for (index, item) in newValue.enumerated() {
//                sectionsData[index].imageData = item
//            }
//            delegate?.reloadTableView()
//        }
//    }
    
//    var testDates: [String] = [] {
//        willSet(newValue) {
//            print("testDates")
//            print(newValue)
//
//            self.imageApi.imageDownLoad(dates: newValue) { urls in
//                print("imageApi urls")
//                print("dfdfdf : \(urls)")
//                self.urlData = urls
//            }
//        }
//    }
    
    init() {
    }
    
    func getData() {
        
        let wrong_word_26 = ["expertise", "campaign", "care", "remainder"]
        let wrong_my_word_26 = ["expertse", "campan", "ca", "remader"]
        let mean_word_26 = ["전문지식", "캠페인", "걱정", "나머지"]
        
        let wrong_word_27 = ["innovate", "composition"]
        let wrong_my_word_27 = ["inovate", "composion"]
        let mean_word_27 = ["혁신하다", "구성"]
        
        let wrong_word_28 = ["congressional", "portray" , "granny" ,"autonomously" , "portuguese"]
        let wrong_my_word_28 = ["congressial", "portay" , "gran" ,"autonomsly" , "portuese"]
        let mean_word_28 = ["의회의", "묘사하다","할머니","자체적으로","포르투갈인"]
        
        let wrong_word_29 = ["valuation"]
        let wrong_my_word_29 = ["valution"]
        let mean_word_29 = ["평가"]
        
        let wrong_word_30 = ["atrophy", "notably" ,"insecticide" ]
        let wrong_my_word_30 = ["atrphy", "ntably" ,"insectcide" ]
        let mean_word_30 = ["평가","특히","살충제"]

        
        
        sectionsData = [
            MyData(date: "2020-06-26", wrongScore: 4, rightScore: 16, level: 1, meanWords: mean_word_26, correctWords: wrong_word_26, myCorrectWordS: wrong_my_word_26, imageData: "2020-06-26"),
            MyData(date: "2020-06-27", wrongScore: 2, rightScore: 18, level: 1, meanWords: mean_word_27, correctWords: wrong_word_27, myCorrectWordS: wrong_my_word_27,imageData: "2020-06-27"),
            MyData(date: "2020-06-28", wrongScore: 5, rightScore: 15, level: 1, meanWords: mean_word_28, correctWords: wrong_word_28, myCorrectWordS: wrong_my_word_28,imageData: "2020-06-28"),
            MyData(date: "2020-06-29", wrongScore: 1, rightScore: 19, level: 1, meanWords: mean_word_29, correctWords: wrong_word_29, myCorrectWordS: wrong_my_word_29,imageData: "2020-06-29"),
            MyData(date: "2020-06-30", wrongScore: 3, rightScore: 17, level: 1, meanWords: mean_word_30, correctWords: wrong_word_30, myCorrectWordS: wrong_my_word_30,imageData: "2020-06-30")
        
        ]
        sectionsData.sort { $0.date > $1.date }
//        self.stop = false
//        dataApi.getVocaTestData(completion: { mydata in
//            print("end")
//            self.sectionsData = mydata
//            self.initTestDates(datas: mydata) // testDates에들어감.
//
//        })
    }
    
    var sectionNumber: Int {
        return sectionsData.count
    }
    
    func initTestDates(datas:[MyData]) {
//        var dates:[String] = []
//        for item in datas {
//            dates.append(item.date)
//        }
//        testDates = dates
    }

}



