//
//  LoginVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/03.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit
import SwiftyJSON
import Alamofire


class LoginVC: UIViewController {
    
    let loginAPI = LoginAPI()
    let memberAPI = MemverAPI()
    
    @IBOutlet weak var idTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var loginBtn: UIView!
    @IBOutlet weak var joinBtn: UIView!
    @IBOutlet var mainOutsideView: UIView!
    
   
    @IBAction func touchLoginBtn(_ sender: Any) {
        
        
        guard let id = idTextField.text, !id.isEmpty else {
            return
        }
        guard let password = passwordTextField.text, !password.isEmpty else {
            return
        }
        self.showSpinner(onView: self.view)
        loginAPI.login(userId: id, userPassword: password, completion: { result, param in
            print("call handleLoginAPIResult func")
            self.handleLoginAPIResult(loginResult: result, param: param)
            
        })
        
    }
    
    @IBAction func touchRegisterBtn(_ sender: Any) {
        let vc = UIStoryboard(name: "Login", bundle: nil).instantiateViewController(withIdentifier: "JoinVC")
        vc.modalPresentationStyle = .formSheet
        present(vc, animated: true, completion: nil)
    }
    
    
    
    override func viewDidLoad() {
        setDelegate()
        initView()
        
    }
    
    func handleLoginAPIResult(loginResult result: LoginMessage, param: Parameters) {
        switch result {
        case .success:
            UserDefaults.standard.setValue(param["username"], forKey: "userID")
            self.presentMainVC()
//            print("sucess in handleLoginAPIResult")
        case .noValid:
            print("noValid in handleLoginAPIResult")
        case .commuicationError:
            print("error in handleLoginAPIResult")
        }
    }
    
    func setDelegate() {
        self.idTextField.delegate = self
        self.passwordTextField.delegate = self
    }
    
    
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
}

extension LoginVC: MyColor {
    func initView() {
        loginBtn.backgroundColor = mainColor
        joinBtn.backgroundColor = mainColor
        joinBtn.layer.cornerRadius = 10
        loginBtn.layer.cornerRadius = 10
        mainOutsideView.backgroundColor = backgroundColor
    }
}

//MARK: - Present MainVC
extension LoginVC {
    
    func presentMainVC() {
        let storyboard = UIStoryboard(name: "Main", bundle: nil)
        let vc = storyboard.instantiateViewController(withIdentifier: "MainTabBar")
            //vc.modalTransitionStyle = UIModalTransitionStyle.coverVertical
//            if let tbItems = vc.tabBar.items {
//
//                tbItems[0].image = UIImage(named: "chase")
//                tbItems[1].image = UIImage(named: "ticket")
//                tbItems[2].image = UIImage(named: "planetIcon")
//                tbItems[3].image = UIImage(named: "showmore")
//
//                tbItems[0].image?.accessibilityFrame.size = CGSize(width: 20, height: 20)
//
//                tbItems[0].setTitleTextAttributes([NSAttributedString.Key.font : UIFont.init(name: "NotoSansCJKkr-Bold", size: 10)!], for: .normal)
//                tbItems[1].setTitleTextAttributes([NSAttributedString.Key.font : UIFont.init(name: "NotoSansCJKkr-Bold", size: 10)!], for: .normal)
//                tbItems[2].setTitleTextAttributes([NSAttributedString.Key.font : UIFont.init(name: "NotoSansCJKkr-Bold", size: 10)!], for: .normal)
//                tbItems[3].setTitleTextAttributes([NSAttributedString.Key.font : UIFont.init(name: "NotoSansCJKkr-Bold", size: 10)!], for: .normal)
//            }
             
//        vc.selectedIndex = 1
//        vc.tabBar.barStyle = UIBarStyle.black
//        vc.tabBar.barTintColor = #colorLiteral(red: 0.1018124148, green: 0.1057564691, blue: 0.114060916, alpha: 1)
//        vc.tabBar.isTranslucent = false
//        vc.tabBar.tintColor = #colorLiteral(red: 1, green: 0.3254901961, blue: 0.3254901961, alpha: 1)
        vc.modalPresentationStyle = .fullScreen
        
        self.present(vc, animated: true,completion: {
            let id = UserDefaults.standard.string(forKey: "userID")
            self.memberAPI.getMemberInfo(id: id!, completion: {
                self.removeSpinner()
            })
            
        })
    }
}

extension LoginVC: UITextFieldDelegate {
    
//    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
//
//    }
}

var vSpinner : UIView?
extension UIViewController {
    func showSpinner(onView : UIView) {
        
        //화면을 터치할수없게 기존뷰에 덮어쓸 뷰
        let spinnerView = UIView.init(frame: onView.bounds)
        spinnerView.backgroundColor = #colorLiteral(red: 0, green: 0, blue: 0, alpha: 0.38)
        
        //spinner
        let ai = UIActivityIndicatorView.init(style: .whiteLarge)
        ai.color = #colorLiteral(red: 1, green: 0.3186968267, blue: 0.3049468994, alpha: 1)
        
        ai.startAnimating()
        ai.center = spinnerView.center
        
        DispatchQueue.main.async {
            spinnerView.addSubview(ai)
            onView.addSubview(spinnerView)
        }
        
        vSpinner = spinnerView
    }
    
    func removeSpinner(){
        DispatchQueue.main.async {
            NSLog("\(self)")
            vSpinner?.removeFromSuperview()
            vSpinner = nil
        }
    }
}


