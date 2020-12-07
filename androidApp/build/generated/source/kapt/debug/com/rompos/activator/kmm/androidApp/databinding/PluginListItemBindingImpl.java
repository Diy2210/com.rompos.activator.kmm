package com.rompos.activator.kmm.androidApp.databinding;
import com.rompos.activator.kmm.androidApp.R;
import com.rompos.activator.kmm.androidApp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PluginListItemBindingImpl extends PluginListItemBinding implements com.rompos.activator.kmm.androidApp.generated.callback.OnCheckedChangeListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private final android.widget.CompoundButton.OnCheckedChangeListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PluginListItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private PluginListItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Switch) bindings[2]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.pluginState.setTag(null);
        this.pluginTitle.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.rompos.activator.kmm.androidApp.generated.callback.OnCheckedChangeListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.handler == variableId) {
            setHandler((com.rompos.activator.kmm.shared.model.PluginViewModel) variable);
        }
        else if (BR.item == variableId) {
            setItem((com.rompos.activator.kmm.shared.model.PluginModel) variable);
        }
        else if (BR.server == variableId) {
            setServer((com.rompos.activator.kmm.Server) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setHandler(@Nullable com.rompos.activator.kmm.shared.model.PluginViewModel Handler) {
        this.mHandler = Handler;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.handler);
        super.requestRebind();
    }
    public void setItem(@Nullable com.rompos.activator.kmm.shared.model.PluginModel Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public void setServer(@Nullable com.rompos.activator.kmm.Server Server) {
        this.mServer = Server;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.server);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String itemTitle = null;
        com.rompos.activator.kmm.shared.model.PluginViewModel handler = mHandler;
        com.rompos.activator.kmm.shared.model.PluginModel item = mItem;
        boolean itemStatus = false;
        com.rompos.activator.kmm.Server server = mServer;

        if ((dirtyFlags & 0xaL) != 0) {



                if (item != null) {
                    // read item.title
                    itemTitle = item.getTitle();
                    // read item.status
                    itemStatus = item.getStatus();
                }
        }
        // batch finished
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setChecked(this.pluginState, itemStatus);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.pluginTitle, itemTitle);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            androidx.databinding.adapters.CompoundButtonBindingAdapter.setListeners(this.pluginState, mCallback1, (androidx.databinding.InverseBindingListener)null);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnCheckedChanged(int sourceId , android.widget.CompoundButton callbackArg_0, boolean callbackArg_1) {
        // localize variables for thread safety
        // handler
        com.rompos.activator.kmm.shared.model.PluginViewModel handler = mHandler;
        // item
        com.rompos.activator.kmm.shared.model.PluginModel item = mItem;
        // handler != null
        boolean handlerJavaLangObjectNull = false;
        // server
        com.rompos.activator.kmm.Server server = mServer;



        handlerJavaLangObjectNull = (handler) != (null);
        if (handlerJavaLangObjectNull) {





            handler.setStatus(server, item, callbackArg_1);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): handler
        flag 1 (0x2L): item
        flag 2 (0x3L): server
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}