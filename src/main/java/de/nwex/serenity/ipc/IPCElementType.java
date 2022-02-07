package de.nwex.serenity.ipc;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IPCElementType extends IElementType {

    public IPCElementType(@NotNull @NonNls String debugName) {
        super(debugName, IPCLanguage.INSTANCE);
    }
}
