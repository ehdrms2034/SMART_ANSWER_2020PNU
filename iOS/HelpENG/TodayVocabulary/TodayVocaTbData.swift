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
        vocasData = [("choi","최"),("you","유"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완"),("wan","완")]
        
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
