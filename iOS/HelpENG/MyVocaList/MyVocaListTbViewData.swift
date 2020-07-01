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
        
        wrongVocaDatas = [
            // level1
            MyVocaListData(category: .wrongVoca, level: 1, date: "2020-06-26", vocaData: [VocaData(voca: "expertise", meaning: "전문지식"),VocaData(voca: "campaign", meaning: "캠페인"),VocaData(voca: "care", meaning: "걱정"),VocaData(voca: "remainder", meaning: "나머지")]),
            MyVocaListData(category: .wrongVoca, level: 1, date: "2020-06-27", vocaData: [VocaData(voca: "inovate", meaning: "혁신하다"),VocaData(voca: "composion", meaning: "구성")]),
            MyVocaListData(category: .wrongVoca, level: 1, date: "2020-06-28", vocaData: [VocaData(voca: "congressional", meaning: "의회의"),VocaData(voca: "portray", meaning: "묘사하다"),VocaData(voca: "granny", meaning: "할머니"),VocaData(voca: "autonomously", meaning: "반복되는"),VocaData(voca: "portuguese", meaning: "포르투갈인")]),
            MyVocaListData(category: .wrongVoca, level: 1, date: "2020-06-29", vocaData: [VocaData(voca: "valuation", meaning: "평가")]),
            MyVocaListData(category: .wrongVoca, level: 1, date: "2020-06-30", vocaData: [VocaData(voca: "atrophy", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "insecticide", meaning: "살충제")]),
            
            // level2
            MyVocaListData(category: .wrongVoca, level: 2, date: "2020-06-25", vocaData: [VocaData(voca: "exotic", meaning: "이국적인"),VocaData(voca: "texture", meaning: "질감"),VocaData(voca: "scheme", meaning: "외과의"),VocaData(voca: "disappointed", meaning: "인종의")]),
            MyVocaListData(category: .wrongVoca, level: 2, date: "2020-06-24", vocaData: [VocaData(voca: "reasonably", meaning: "비밀스러운"),VocaData(voca: "ironically", meaning: "도입하다")]),
            
            
            // level3
            MyVocaListData(category: .wrongVoca, level: 3, date: "2020-06-23", vocaData: [VocaData(voca: "congressional", meaning: "의회의"),VocaData(voca: "portray", meaning: "묘사하다"),VocaData(voca: "granny", meaning: "실존주의적인"),VocaData(voca: "autonomously", meaning: "규제받지않는"),VocaData(voca: "portuguese", meaning: "포르투갈인")]),
            MyVocaListData(category: .wrongVoca, level: 3, date: "2020-06-22", vocaData: [VocaData(voca: "valuation", meaning: "평가")]),
            MyVocaListData(category: .wrongVoca, level: 3, date: "2020-06-21", vocaData: [VocaData(voca: "atrophy", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "insecticide", meaning: "살충제")]),
            
            // level4
            MyVocaListData(category: .wrongVoca, level: 4, date: "2020-06-20", vocaData: [VocaData(voca: "inovate", meaning: "혁신하다"),VocaData(voca: "composion", meaning: "구성")]),
            
            
            //level 5
            MyVocaListData(category: .wrongVoca, level: 5, date: "2020-06-19", vocaData: [VocaData(voca: "plaque", meaning: "기업가"),VocaData(voca: "botanical", meaning: "묘사하다"),VocaData(voca: "granny", meaning: "마이크로바이옴"),VocaData(voca: "autonomously", meaning: "걱정스러운"),VocaData(voca: "extraterrestrial", meaning: "포르투갈인")]),
            MyVocaListData(category: .wrongVoca, level: 5, date: "2020-06-18", vocaData: [VocaData(voca: "illiteracy", meaning: "중대한")]),
            MyVocaListData(category: .wrongVoca, level: 5, date: "2020-06-17", vocaData: [VocaData(voca: "atrophy", meaning: "의회의"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "dedication", meaning: "다국적의")]),
            
            MyVocaListData(category: .wrongVoca, level: 5, date: "2020-06-16", vocaData: [VocaData(voca: "dedication", meaning: "사기꾼")]),
            MyVocaListData(category: .wrongVoca, level: 5, date: "2020-06-15", vocaData: [VocaData(voca: "botanical", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "decoration", meaning: "의회의")])
        ]
        
        recommendVocaDatas = [
            
        // level2
        MyVocaListData(category: .recommendVoca, level: 1, date: "2020-06-26", vocaData: [VocaData(voca: "decent", meaning: "필수적인"),VocaData(voca: "fishery", meaning: "질감"),VocaData(voca: "illustrator", meaning: "외과의"),VocaData(voca: "tattoo", meaning: "인종의")]),
        MyVocaListData(category: .recommendVoca, level: 1, date: "2020-06-27", vocaData: [VocaData(voca: "impose", meaning: "반응하는"),VocaData(voca: "slogan", meaning: "걱정스러운")]),
            
        MyVocaListData(category: .recommendVoca, level: 1, date: "2020-06-28", vocaData: [VocaData(voca: "nifty", meaning: "상기된"),VocaData(voca: "disappointed", meaning: "망치다"),VocaData(voca: "care", meaning: "불충분한"),VocaData(voca: "offshore", meaning: "솜씨좋은")]),
        MyVocaListData(category: .recommendVoca, level: 1, date: "2020-06-29", vocaData: [VocaData(voca: "inovate", meaning: "측지의"),VocaData(voca: "composion", meaning: "구성")]),
        MyVocaListData(category: .recommendVoca, level: 1, date: "2020-06-30", vocaData: [VocaData(voca: "extension", meaning: "필수적인"),VocaData(voca: "portray", meaning: "묘사하다"),VocaData(voca: "granny", meaning: "할머니"),VocaData(voca: "unregulated", meaning: "반복되는"),VocaData(voca: "cerebellum", meaning: "수탉")]),
        
        MyVocaListData(category: .recommendVoca, level: 2, date: "2020-06-25", vocaData: [VocaData(voca: "valuation", meaning: "침습성의")]),
        MyVocaListData(category: .recommendVoca, level: 2, date: "2020-06-24", vocaData: [VocaData(voca: "atrophy", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "anomaly", meaning: "비밀스러운")]),
       
            
        // level4
        MyVocaListData(category: .recommendVoca, level: 3, date: "2020-06-23", vocaData: [VocaData(voca: "alarming", meaning: "다국적의"),VocaData(voca: "animator", meaning: "마이크로바이옴")]),
        MyVocaListData(category: .recommendVoca, level: 3, date: "2020-06-22", vocaData: [VocaData(voca: "immediate", meaning: "의회의"),VocaData(voca: "portray", meaning: "묘사하다"),VocaData(voca: "cottage", meaning: "할머니"),VocaData(voca: "existential", meaning: "반복되는"),VocaData(voca: "portuguese", meaning: "마이크로바이옴")]),
        MyVocaListData(category: .recommendVoca, level: 3, date: "2020-06-21", vocaData: [VocaData(voca: "illustration", meaning: "협력하는")]),
        
    

        MyVocaListData(category: .recommendVoca, level: 4, date: "2020-06-20", vocaData: [VocaData(voca: "rooster", meaning: "대피시키다"),VocaData(voca: "tournament", meaning: "차이"),VocaData(voca: "granny", meaning: "환경운동가"),VocaData(voca: "cerebellum", meaning: "동기"),VocaData(voca: "oratory", meaning: "걱정스러운")]),
        
        MyVocaListData(category: .recommendVoca, level: 5, date: "2020-06-19", vocaData: [VocaData(voca: "exclusive", meaning: "강조하여")]),
        MyVocaListData(category: .recommendVoca, level: 5, date: "2020-06-18", vocaData: [VocaData(voca: "integral", meaning: "칼로리"),VocaData(voca: "extension", meaning: "끊임없이"),VocaData(voca: "epiphany", meaning: "따분함")]),
        MyVocaListData(category: .recommendVoca, level: 5, date: "2020-06-17", vocaData: [VocaData(voca: "dedication", meaning: "사기꾼")]),
        MyVocaListData(category: .recommendVoca, level: 5, date: "2020-06-16", vocaData: [VocaData(voca: "botanical", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "decoration", meaning: "의회의")]),
        MyVocaListData(category: .recommendVoca, level: 5, date: "2020-06-15", vocaData: [VocaData(voca: "botanical", meaning: "평가"),VocaData(voca: "notably", meaning: "특히"),VocaData(voca: "epiphany", meaning: "의회의")])
            
        ]
    }
    
}

/*
 expertise collect raise comply indicator campaign exclusive care variety inform forster extend attraction coverage porfession attire remainder less
 
 전문지식 모으다 높이다 (조짐 따르다 구매하다) 지표 캠페인 독점적인 걱정 다양성 알리다 촉진하다 연장하다 매력 보도 직업 복장 나머지 덜한
 */
/*
 innovate decent composition exotic texture scheme disappointed surgical stimulation racial impulse reasonably visceral ironically slogan lapse tattoo malnutrition liberation impose
 
 혁신하다 괜찮은 구성 이국적인 질감 계획 실망한 외과의 자극 인종의 충동 합리적으로 본능적인 반어적으로 구호 실수 문신 영양실조 해방 도입하다
 */

/* congressional portray granny autonomously portuguese unleashed decoration momentous defect plaque botanical savage extraterrestrial conceivable recurrent potassium forensic dedication illiteracy dissonance
 
 의회의 묘사하다 할머니 자체적으로 포르투갈인 촉발시키다 장식품 중대한 결함 명판 식물의 야만적인 외계인 가능한 반복되는 포타슘 법의학적인 헌신 문맹 불협화음
 */

/*
 valuation notably insecticide thorny supersonic mediocrity archaeological canine emancipation asymmetry eloquent suction nostalgic hangover voracious humongous fermentation forgery appliance oceanography
 평가 특히 살충제 곤란한 초음속의 보통 고고학의 송곳니 해방 불균형 유창한 흡입 향수의 숙취 게걸스러운 거대한 발효 위조죄 가전제품 해양학
 */

/* atrophy plethora melanin introvert malfunction congregate overpopulation evacuate banality antiviral obsessional haphazard habitual refinement discrepancy outpatient slippage emphatically oratory wonderment
 
 위축 과다 멜라닌 내성적인사람 고장 모이다 인구과잉 대피시키다 따분함 항바이러스성의 강박적인 무계획적인 습관적인 개선 차이 외래환자 불이행 강조하여 웅변술 경탄
 */
