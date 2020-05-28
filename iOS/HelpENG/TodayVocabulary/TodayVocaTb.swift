//
//  TodayVocaTb.swift
//  HelpENG
//
//  Created by Wanni on 2020/05/27.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit



class TodayVocaTb: UITableView {
    
    var todayVocaTbData = TodayVocaTbData()

    func controlAllLabel(isHidden: Bool, language: language) {
        
        if isHidden {
            switch language {
            case .kor:
                todayVocaTbData.korVocasHidden = todayVocaTbData.korVocasHidden.map{ _ in false }
            case .eng:
                todayVocaTbData.engVocasHidden = todayVocaTbData.engVocasHidden.map{ _ in false }
            }
        } else {
            switch language {
            case .kor:
                todayVocaTbData.korVocasHidden = todayVocaTbData.korVocasHidden.map{ _ in true }
            case .eng:
                todayVocaTbData.engVocasHidden = todayVocaTbData.engVocasHidden.map{ _ in true }
            }
        }
    }
}

extension TodayVocaTb: TodayVocaTbDataControll {
    func controlKorHidden(indexPath: IndexPath, isHidden: Bool) {
        self.todayVocaTbData.korVocasHidden[indexPath.row] = isHidden
    }
    
    func controlEngHidden(indexPath: IndexPath, isHidden: Bool) {
        self.todayVocaTbData.engVocasHidden[indexPath.row] = isHidden
    }
}


