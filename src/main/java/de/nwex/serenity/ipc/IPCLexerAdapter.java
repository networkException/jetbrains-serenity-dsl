package de.nwex.serenity.ipc;

import com.intellij.lexer.FlexAdapter;

public class IPCLexerAdapter extends FlexAdapter {

    public IPCLexerAdapter() {
        super(new _IPCLexer(null));
    }
}
