import SwiftUI

struct EditView: View {
    
    @State private var title: String = ""
    @State private var url: String = ""
    @State private var token: String = ""
    
    private var validated: Bool {
        !title.isEmpty && !url.isEmpty && !token.isEmpty
        }
    
//    @State private var showAlert = false
    
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
//            HStack(alignment: .center) {
//                if validated {
                
//                Button(action:{self.presentationMode.wrappedValue.dismiss() }){
//                    Text("cancel")
//                }
//                .padding(Edge.Set.vertical, 20)
//                .padding(Edge.Set.horizontal, 20)
//                Button(action:{self.presentationMode.wrappedValue.dismiss() }){
//                    Text("save")
//                }
//                .padding(Edge.Set.vertical, 20)
//                .padding(Edge.Set.horizontal, 20)
//                }
//            }
//            .padding(Edge.Set.horizontal, 100)
            
//            Text(title)
//            Text(url)
//            Text(token)
//        }
        .toolbar {
            if validated {
                Button(action:{self.presentationMode.wrappedValue.dismiss() }) {
                    Text("save")
                    }
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
