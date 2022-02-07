package de.nwex.serenity.ipc;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class IPCFile extends PsiFileBase {

    public IPCFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, IPCLanguage.INSTANCE);
    }

    @NotNull @Override public FileType getFileType() {
        return IPCFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "IPC File";
    }
}
