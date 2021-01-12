import SwiftUI
import shared

struct EditView: View {

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
                    print(title, url, token)
                    self.presentationMode.wrappedValue.dismiss()
                    })
                    { Text("save") }
                }
            }
        }
    }
}

struct EditView_Previews: PreviewProvider {
    static var previews: some View {
        EditView()
    }
}
