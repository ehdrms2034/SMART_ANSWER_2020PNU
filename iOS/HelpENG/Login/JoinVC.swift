//
//  JoinVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/05.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class JoinVC: UIViewController {
    
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var idTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    @IBOutlet weak var joinBtnView: UIView!
    
    let joinAPI = JoinAPI()
    
    func initdelegate() {
        nameTextField.delegate = self
        idTextField.delegate = self
        passwordTextField.delegate = self
    }
    
    override func viewDidLoad() {
        initdelegate()
        initJoinBtnView()
    }
    
    @IBAction func touchJoinBtn(_ sender: Any) {
        print("touchJoinBtn")
        guard let userName = nameTextField.text, !userName.isEmpty else {
            return
        }
        
        guard let userId = idTextField.text, !userId.isEmpty else {
            return
        }
        
        guard let userPassword = passwordTextField.text, !userPassword.isEmpty else {
            return
        }
        print(userName, userId, userPassword)
        joinAPI.join(userName: userName, userId: userId, userPassword: userPassword, completion: { result in
            self.handleJoinApiResult(joingResult: result)
        })
        
    }
    
    func handleJoinApiResult(joingResult result: JoinMessage) {
        switch result {
        case .joinSuccess:
            let alert = UIAlertController(title: "회원가입 성공", message: "회원가입에 성공했습니다.", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "확인", style: .cancel, handler: { alert in
                self.dismiss(animated: true, completion: nil)
            }))
            self.present(alert, animated: true, completion: nil)
            
        case .joinFail:
            let alert = UIAlertController(title: "회원가입 실패", message: "중복 확인해주세요.", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "확인", style: .cancel, handler: nil))
            self.present(alert, animated: true, completion: nil)
                
        case .communicationError:
            let alert = UIAlertController(title: nil, message: "통신 오류", preferredStyle: .alert)
            alert.addAction(UIAlertAction(title: "확인", style: .cancel, handler: nil))
            self.present(alert, animated: true, completion: nil)
        }
    }
    
    func joinSuccess() {
        
    }
}

extension JoinVC: MyColor {
    
    func initJoinBtnView() {
        joinBtnView.backgroundColor = mainColor
        joinBtnView.layer.cornerRadius = 10
    }
    
}

extension JoinVC: UITextFieldDelegate {
    
}


