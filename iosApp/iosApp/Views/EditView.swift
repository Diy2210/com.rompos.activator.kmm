import SwiftUI
import shared

struct EditView: View {
    
//    @ObservedObject private(set) var viewModel: ViewModel
    
    var serverID: Int = 0

//    @State private var serverId: Int = 0
    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""
    
//    private var serverFormViewModel = ServerFormViewModel
    
    private var validated: Bool {
        !title.isEmpty && !url.isEmpty && !token.isEmpty
    }
    
    @Environment(\.presentationMode) var presentationMode

    var body: some View {
        VStack(alignment: .leading) {
            TextField(" Title", text: $title)
                .border(Color.black)
                .padding(Edge.Set.vertical, 3)
                .padding(Edge.Set.horizontal, 20)
            TextField(" URL", text: $url)
                .border(Color.black)
                .padding(Edge.Set.vertical, 3)
                .padding(Edge.Set.horizontal, 20)
            TextField(" Token", text: $token)
                .border(Color.black)
                .padding(Edge.Set.vertical, 3)
                .padding(Edge.Set.horizontal, 20)
        .toolbar {
            if validated {
                Button(action: {
                    print(title, url, token, serverID)
                    saveRecord(title: title, url: url, token: token)
//                    self.presentationMode.wrappedValue.dismiss()
                    })
                    { Text("save") }
                }
            }
        }
    }
    
//    init(sdk: ActivatorSDK) {
//        self.sdk = sdk
//    }
    
    private func saveRecord(title: String, url: String, token: String) {
//        sdk.save(title: title, url: url, token: token, completionHandler: (KotlinUnit?, Error?) -> Void)
        self.presentationMode.wrappedValue.dismiss()
    }
}

//extension EditView {
//
//    class ViewModel: ObservableObject {
//        let sdk: ActivatorSDK
//
//        init(sdk: ActivatorSDK) {
//            self.sdk = sdk
//        }
//    }
//}

//struct EditView_Previews: PreviewProvider {
//    static var previews: some View {
//        EditView()
//    }
//}

//extension ServerFormViewModel: Identifiable { }
//extension ActivatorSDK: Identifiable { }
