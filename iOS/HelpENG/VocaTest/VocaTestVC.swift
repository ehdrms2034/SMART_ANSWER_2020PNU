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

//MARK: - VocatTestVC Camera, Album Function

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
            imageApi.imageUpload(image: image, completion: {
            })

        }

        dismiss(animated: true, completion: nil)
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
        
        
        switch indexPath.row {
        case 0:
            let cell = ExpandingTbViewSectionCell()
            let cellData = testResultTbView.getSectionData(indexPath: indexPath)
            cell.delegate = testResultTbView
            cell.indexPath = indexPath
            cell.takeTextAndPutItOnLabel(date: cellData.date)
            cell.takeTextAndPutItInStackView(level: cellData.level, correct: cellData.rightScore, wrong: cellData.wrongScore)
            cell.sectionIsOpened = cellData.isOpened
            
            
            return cell
        default:
            let cell = ExpandingTbViewRowCell()
            cell.takeTextAndPutItOnLabel(text: testResultTbView.getRowTitle(indexPath: indexPath))
            return cell

        }
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    
//        testResultTbView.expanding(selectedIndexPath: indexPath)
    }
    
}
