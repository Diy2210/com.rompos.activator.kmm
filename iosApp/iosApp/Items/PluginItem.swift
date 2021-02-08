import SwiftUI
import shared

struct PluginItem: View {
    
    var pluginModel: PluginModel
    
    @State var isOn: Bool = false
    
    var body: some View {
        VStack {
            Toggle(pluginModel.title, isOn: $isOn).onChange(of: pluginModel.status) { value in
                //API code...
                print(value)
            }.padding()
        }
    }
}
