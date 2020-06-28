//
//  MyVocaListTbViewData.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/24.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit


protocol MyVocaListTbViewDataProtocol{
    var wrongVocaDatas:[MyVocaListData] { get set }
    var recommendVocaDatas:[MyVocaListData] { get set }
    

}

/*
 
 MyVocaListTbViewData : TableView 전체 데이터를 관리하는 Struct
 
 wrongVocaDatas : 틀린 단어를 담는 배열
 recommendVocaDatas : 추천 단어를 담는 배열
 
*/
struct MyVocaListTbViewData: MyVocaListTbViewDataProtocol {
    
    //api를 사용해서 각각 집어넣는다.
    var wrongVocaDatas: [MyVocaListData]
    var recommendVocaDatas: [MyVocaListData]
    
    init() {
        
        wrongVocaDatas = [MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.20", vocaData: [VocaData(voca: "hello", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")]), MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.14", vocaData: [VocaData(voca: "goodbye", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")]),MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.13", vocaData: [VocaData(voca: "pi", meaning: "원주율"),VocaData(voca: "bye", meaning: "잘가")]),MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.16", vocaData: [VocaData(voca: "hello", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")]),MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.28", vocaData: [VocaData(voca: "hello", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")]),MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.28", vocaData: [VocaData(voca: "hello", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")]),MyVocaListData(category: .wrongVoca, level: 1, date: "2020.06.28", vocaData: [VocaData(voca: "hello", meaning: "안녕"),VocaData(voca: "bye", meaning: "잘가")])]
        
        recommendVocaDatas = [MyVocaListData(category: .recommendVoca, level: 1, date: "2020.06.21", vocaData: [VocaData(voca: "push", meaning: "밀다"),VocaData(voca: "pull", meaning: "당기다")])]
    }
    
}
