package de.nwex.serenity.ipc;

import com.intellij.lang.Language;

public class IPCLanguage extends Language  {

    public static final IPCLanguage INSTANCE = new IPCLanguage();

    private IPCLanguage() {
        super("Serentiy IPC");
    }
}
