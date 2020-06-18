//
//  MyColor.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/18.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

protocol MyColor {
    
}

extension MyColor {
    
    var mainColor: UIColor {
        return #colorLiteral(red: 1, green: 0.3186968267, blue: 0.3049468994, alpha: 1)
    }
    
    var subColor: UIColor {
        return #colorLiteral(red: 0.4156862745, green: 0.3764705882, blue: 0.662745098, alpha: 1)
    }
    
    var backgroundColor: UIColor {
        return #colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)
    }
    
    var clearColor: UIColor {
        return #colorLiteral(red: 1, green: 1, blue: 1, alpha: 0)
    }
    
    var textColor: UIColor {
        return #colorLiteral(red: 1, green: 1, blue: 1, alpha: 1)
    }
}
