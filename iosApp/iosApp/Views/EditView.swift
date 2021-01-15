import SwiftUI
import shared

struct EditView: View {
    
//    @ObservedObject private(set) var viewModel: ViewModel

    @State private var serverId: Int = 0
    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""
    
//    var serverFormViewModel: ServerFormViewModel
    
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
                    print(title, url, token)
                    saveRecord()
//                    self.presentationMode.wrappedValue.dismiss()
                    })
                    { Text("save") }
                }
            }
        }
    }
    
    private func saveRecord() {
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

extension ServerFormViewModel: Identifiable { }
