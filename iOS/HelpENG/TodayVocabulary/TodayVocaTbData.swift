//
//  TodayVocaTbData.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import Foundation


struct TodayVocaTbData {
    
    var allEngVocaHidden: Bool = false
    var allKorVocaHidden: Bool = false
    
    var engVocasHidden: [Bool]
    var korVocasHidden: [Bool]
    
    var vocasData: [(eng: String, kor: String)]
    
    init() {
        vocasData = [("transparency","투명도"), ("governance","통치"), ("hospital","병원"), ("agriculture","농업"), ("production","생산"), ("ecosystem","생태계"), ("camp","야영지"), ("airport","공항"), ("incontinence","실금"), ("church","교회"), ("communicate","의사소통하다"), ("predict","예측하다"), ("capital","수도"), ("develop","개발하다"), ("currency","통화"), ("prison","교도소"), ("deliver","배달하다"), ("treat","대하다"), ("scarce","부족한"), ("resource","자원")]
        
        self.engVocasHidden = Array(repeating: false, count: vocasData.count)
        self.korVocasHidden = Array(repeating: false, count: vocasData.count)
    }
}

//MARK: - Data Controll

extension TodayVocaTbData {
    func getTbDataForCellInt(indexPath: IndexPath) -> (Bool, Bool, String, String) {
        
        return (korVocasHidden[indexPath.row], engVocasHidden[indexPath.row],
        vocasData[indexPath.row].kor, vocasData[indexPath.row].eng)
    }

}

enum language {
    case kor
    case eng
}
