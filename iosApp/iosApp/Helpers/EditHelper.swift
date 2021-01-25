import Foundation
import SwiftUI
import Combine
import shared

class EditHelper: ObservableObject {
    
    let sdk = ActivatorSDK(databaseDriverFactory: DatabaseDriverFactory())
    
    //Save new server
    func saveServer(title: String, url: String, token: String) {
        sdk.saveServer(title: title, url: url, token: token, completionHandler: { title, error in
            if let title = title { print(title) }
        }) 
    }
    
    //Update server by id
    func updateServer(title: String, url: String, token: String, id: Int64) {
        sdk.updateServer(title: title, url: url, token: token, id: id, completionHandler: { title, error in
            if let title = title { print(title) }
        })
    }
    
    //Delete server by id
    func deleteServer(id: Int64) {
        sdk.deleteServer(id: id, completionHandler: { id, error in
            if let id = id { print(id) }
        })
    }
}
