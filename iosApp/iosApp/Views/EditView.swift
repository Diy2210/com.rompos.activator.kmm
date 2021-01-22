import SwiftUI
import shared

struct EditView: View {
    
    @ObservedObject var editHelper = EditHelper()
    
    var serverID: Int = 0

    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""
    

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
                    if (serverID > 0) {
                        //Update Server
                        updateServer(title: title, url: url, token: token, id: serverID)
                    } else {
                        //Save Server
                        saveServer(title: title, url: url, token: token)
                    }
                    print(title, url, token, serverID)
                    })
                    { Text("save") }
                }
            }
        }
    }
    
    private func saveServer(title: String, url: String, token: String) {
        editHelper.saveServer(title: title, url: url, token: token)
        self.presentationMode.wrappedValue.dismiss()
    }
    
    private func updateServer(title: String, url: String, token: String, id: Int) {
        editHelper.updateServer(title: title, url: url, token: token, id: serverID)
        self.presentationMode.wrappedValue.dismiss()
    }
}
