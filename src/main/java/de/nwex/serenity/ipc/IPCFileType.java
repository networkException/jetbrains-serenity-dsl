package de.nwex.serenity.ipc;

import com.intellij.openapi.fileTypes.LanguageFileType;
import de.nwex.serenity.Icons;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;

public class IPCFileType extends LanguageFileType {

    public static final IPCFileType INSTANCE = new IPCFileType();

    private IPCFileType() {
        super(IPCLanguage.INSTANCE);
    }

    @NotNull @Override public String getName() {
        return "Serenity IPC Definition File";
    }

    @NotNull @Override public String getDescription() {
        return "SerenityOS Inter Process Communication Definition";
    }

    @NotNull @Override public String getDefaultExtension() {
        return "ipc";
    }

    @NotNull @Override public Icon getIcon() {
        return Icons.IPC;
    }
}
