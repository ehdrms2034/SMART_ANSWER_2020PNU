//
//  VocaTestVC.swift
//  HelpENG
//
//  Created by Wanni on 2020/06/13.
//  Copyright © 2020 Wanni. All rights reserved.
//

import UIKit

class VocaTestVC: UIViewController {
    
    @IBOutlet weak var testResultUIView: UIView!
    @IBOutlet weak var scoringBtn: UIView!
    @IBOutlet var mainOutsideView: UIView!
    @IBOutlet weak var scoringLabel: UILabel!
    
    let picker = UIImagePickerController()

    let testResultTbView: ExpandingTableView = {
        let tableView = ExpandingTableView()
        tableView.initUI()
        return tableView
    }()
    
    let imageApi = VocaTestImageAPI()
    
    @IBAction func touchScoringBtn(_ sender: Any) {
        showSelectionAlert()
    }

    override func viewDidLoad() {
        initUIView()
        initTbView()
        initDelegateAndDataSource()
    }
    
    
}

//MARK: - VocaTestVC Setup View And Delegate
extension VocaTestVC: MyColor {
    
    func initUIView() {
        scoringBtn.backgroundColor = mainColor
        scoringBtn.layer.cornerRadius = 10
        mainOutsideView.backgroundColor = backgroundColor
        testResultUIView.layer.setBorderColorAndWidth(color: subColor, borderWidth: 1.0)
        testResultUIView.backgroundColor = .white
    }
    
    func initTbView() {
        testResultUIView.addSubview(testResultTbView)
        testResultTbView.backgroundColor = clearColor
        testResultTbView.separatorStyle = .none
        
        testResultTbView.translatesAutoresizingMaskIntoConstraints = false
        testResultTbView.leftAnchor.constraint(equalTo: testResultUIView.leftAnchor).isActive = true
        testResultTbView.rightAnchor.constraint(equalTo: testResultUIView.rightAnchor).isActive = true
        testResultTbView.topAnchor.constraint(equalTo: testResultUIView.topAnchor).isActive = true
        testResultTbView.bottomAnchor.constraint(equalTo: testResultUIView.bottomAnchor).isActive = true
    }
    
    func initDelegateAndDataSource() {
        testResultTbView.delegate = self
        testResultTbView.dataSource = self
        picker.delegate = self
    }
}

extension VocaTestVC {
    
}

//MARK: - VocatTestVC Camera, Album Function, 이의신청 알림
extension VocaTestVC: UIImagePickerControllerDelegate, UINavigationControllerDelegate{
    
    func showCamera() {
        picker.sourceType = .camera
        present(picker, animated: false, completion: nil)
    }
    
    func showAlbum() {
        picker.sourceType = .photoLibrary
        present(picker, animated: false, completion: nil)
    }
    
    func showSelectionAlert() {
        let alert = UIAlertController(title: "채점 방식", message: "채점 방식을 선택해주세요.", preferredStyle: .actionSheet)
        alert.view.tintColor = mainColor
        let album = UIAlertAction(title: "앨범", style: .default, handler: { (action) in
            self.showAlbum()
        })
        let camera = UIAlertAction(title: "카메라", style: .default, handler: { (action) in
            self.showCamera()
        })
        let cancel = UIAlertAction(title: "취소", style: .cancel, handler: nil)
        
        alert.addAction(album)
        alert.addAction(camera)
        alert.addAction(cancel)
        present(alert, animated: true, completion: nil)
    }
    
    func imagePickerController(_ picker: UIImagePickerController, didFinishPickingMediaWithInfo info: [UIImagePickerController.InfoKey : Any]) {
        if let image = info[UIImagePickerController.InfoKey.originalImage] as? UIImage{
            // image를 이제 서버로 보내면 됨.
            
            print(info)
//            imageApi.imageUpload(image: image, completion: {
//            })
            //미리 넣어둔 url 받아와서 입력.
            let vocasData = [("transparency","투명도"), ("governance","통치"), ("hospital","병원"), ("agriculture","농업"), ("production","생산"), ("ecosystem","생태계"), ("camp","야영지"), ("airport","공항"), ("incontinence","실금"), ("church","교회"), ("communicate","의사소통하다"), ("predict","예측하다"), ("capital","수도"), ("develop","개발하다"), ("currency","통화"), ("prison","교도소"), ("deliver","배달하다"), ("treat","대하다"), ("scarce","부족한"), ("resource","자원")]
            
            let mean_word_01 = ["농업","실금","투명도"]
            let wrong_word_01 = ["agriculture","incontinence","transparency"]
            let wrong_my_word_01 = ["agrculture","incontinece","transparenecy"]
            let data = MyData(date: "2020-07-01", wrongScore: 3, rightScore: 17, level: 1, meanWords: mean_word_01, correctWords: wrong_word_01, myCorrectWordS: wrong_my_word_01,imageData:"2020-07-01")
            
            testResultTbView.myData.sectionsData.append(data)
            testResultTbView.myData.sectionsData.sort { $0.date > $1.date }
            testResultTbView.reloadData()
            
            

        }
        
        

        dismiss(animated: true, completion: nil)
    }
    
}

extension VocaTestVC: ExpandingTbViewRowStatckViewProtocol {
    func showObjectionAlert() {
        let alert = UIAlertController(title: "이의 신청 완료", message: "환경설정(이의 신청)에서 확인바랍니다.", preferredStyle: .alert)
        let cancel = UIAlertAction(title: "확인", style: .cancel, handler: nil)
        
        alert.addAction(cancel)
        present(alert, animated: true, completion: nil)
    }
}

//MARK: - VocaTestVC TableView Func
extension VocaTestVC: UITableViewDelegate, UITableViewDataSource {
    
    func numberOfSections(in tableView: UITableView) -> Int {

        return testResultTbView.myData.sectionNumber
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        
        return testResultTbView.numberOfRowsInSection(section: section)
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cellData = testResultTbView.getSectionData(indexPath: indexPath)

        switch indexPath.row {

        case 0:
            let cell = ExpandingTbViewSectionCell()
            cell.delegate = testResultTbView
            cell.indexPath = indexPath
            cell.takeTextAndPutItOnLabel(date: cellData.date)
            cell.takeTextAndPutItInStackView(level: cellData.level, correct: cellData.rightScore, wrong: cellData.wrongScore)
            cell.sectionIsOpened = cellData.isOpened
            
            
            return cell
        default:
            let cell = ExpandingTbViewRowCell()
            cell.stackView.delegate = self
            cell.stackView.testResult = cellData.testResult
            
            cell.testPaperImageView.image = UIImage(named: cellData.imageData)
//            let image = UIImage(systemName: "nosign")?.withTintColor(mainColor, renderingMode: .alwaysOriginal)
//            cell.testPaperImageView.image = image
            
//            if let url = cellData.imageData {
//                if let url = URL( string:url)
//                {
//                    DispatchQueue.global().async {
//                      if let data = try? Data( contentsOf:url)
//                      {
//                        DispatchQueue.main.async {
//                            cell.testPaperImageView.image = UIImage(data:data)
//                        }
//                      }
//                   }
//                }
//
//            } else {
//
//                let image = UIImage(systemName: "nosign")?.withTintColor(mainColor, renderingMode: .alwaysOriginal)
//                cell.testPaperImageView.image = image
//            }
            
            return cell

        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        guard let vc = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(withIdentifier: "TestResultVC") as? TestResultVC else {
            return
        }
        let cellData = testResultTbView.getSectionData(indexPath: indexPath)
        let num = cellData.correctWords.count
        var passData:[TestResultData] = []
        for index in 0..<num {
            
            let tempData = TestResultData(wrongAnswer: cellData.myCorrectWordS[index], correctAnswer: cellData.correctWords[index], mean: cellData.meanWords[index])
            passData.append(tempData)
        }
        
        vc.testResultTableView.totalTbData.testResultDatas = passData
        self.present(vc, animated: true, completion: nil)
        print("touch!!")
//        testResultTbView.expanding(selectedIndexPath: indexPath)
    }
    
    
    
}
