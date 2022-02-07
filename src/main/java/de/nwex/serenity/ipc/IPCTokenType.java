package de.nwex.serenity.ipc;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IPCTokenType extends IElementType {

    public IPCTokenType(@NotNull @NonNls String debugName) {
        super(debugName, IPCLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "IPCTokenType." + super.toString();
    }
}
