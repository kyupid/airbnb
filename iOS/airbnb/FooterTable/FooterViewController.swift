//
//  FooterViewController.swift
//  airbnb
//
//  Created by 박혜원 on 2021/05/25.
//

import UIKit

struct FooterTableConstant {
    static let heightForCell : CGFloat = 43
    static let numberOfRows : Int = 4
}

class FooterViewController: UIViewController {

    @IBOutlet weak var footerTable: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        registerNib()
        
        footerTable.delegate = self
        footerTable.dataSource = self
        footerTable.isScrollEnabled = false
    }
    
    func registerNib() {
        let nib = UINib(nibName: FooterTableViewCell.nibName, bundle: nil)
        footerTable.register(nib, forCellReuseIdentifier: FooterTableViewCell.reuseIdentifier)
    }
}

extension FooterViewController : UITableViewDelegate {
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return FooterTableConstant.heightForCell
    }
}

extension FooterViewController : UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return FooterTableConstant.numberOfRows
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: FooterTableViewCell.reuseIdentifier, for: indexPath) as! FooterTableViewCell
        return cell
    }

}