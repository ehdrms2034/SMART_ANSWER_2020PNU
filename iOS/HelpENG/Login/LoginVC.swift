//
//  LoginVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/03.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class LoginVC: UIViewController {
    
    let loginAPI = LoginAPI()
    
    @IBOutlet weak var idTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
   
    @IBAction func touchLoginBtn(_ sender: Any) {
        guard let id = idTextField.text, let password = passwordTextField.text else {
            return
        }
        let num = loginAPI.login(userId: id, userPassword: password)
        print(num)
    }
    
    @IBAction func touchRegisterBtn(_ sender: Any) {
        
    }
    
    override func viewDidLoad() {
        setDelegate()
    }
    
    func handleLoginAPIResult() {
        
    }
    
    func setDelegate() {
        self.idTextField.delegate = self
        self.passwordTextField.delegate = self
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
}

extension LoginVC: UITextFieldDelegate {
    
//    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
//
//    }
}
