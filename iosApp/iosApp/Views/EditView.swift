import SwiftUI
import shared

struct EditView: View {
    
    @Environment(\.presentationMode) var presentationMode
    
    @ObservedObject var helper = Helper()
    
    var serverID: Int64 = 0

    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""
    
    private var validated: Bool {
        !title.isEmpty && !url.isEmpty && !token.isEmpty
    }
    
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
                        //Update server
                        updateServer(title: title, url: url, token: token, id: serverID)
                    } else {
                        //Save server
                        saveServer(title: title, url: url, token: token)
                    }
                    })
                    { Text("save") }
                }
            }
        }
    }
    
    private func updateServer(title: String, url: String, token: String, id: Int64) {
        helper.updateServer(title: title, url: url, token: token, id: serverID)
        self.presentationMode.wrappedValue.dismiss()
    }
    
    private func saveServer(title: String, url: String, token: String) {
        helper.saveServer(title: title, url: url, token: token)
        self.presentationMode.wrappedValue.dismiss()
    }
}
