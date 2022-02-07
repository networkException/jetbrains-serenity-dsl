package de.nwex.serenity.ipc;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class IPCSyntaxHighlighter extends SyntaxHighlighterBase {

    // Lexer Based Highlighting
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("IPC_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey DIRECTIVE = createTextAttributesKey("IPC_DIRECTIVE", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey STRING = createTextAttributesKey("IPC_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("IPC_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("IPC_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BRACE = createTextAttributesKey("IPC_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey SCOPE_RESOLUTION = createTextAttributesKey("IPC_SCOPE_RESOLUTION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("IPC_OPERATOR", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("IPC_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] DIRECTIVES = new TextAttributesKey[]{DIRECTIVE};
    private static final TextAttributesKey[] STRINGS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] COMMENTS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] COMMAS = new TextAttributesKey[]{COMMA};
    private static final TextAttributesKey[] BRACES = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] SCOPE_RESOLTIONS = new TextAttributesKey[]{SCOPE_RESOLUTION};
    private static final TextAttributesKey[] OPERATORS = new TextAttributesKey[]{OPERATOR};
    private static final TextAttributesKey[] BAD_CHARACTERS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    // Parser Based Highlighting
    public static final TextAttributesKey FUNCTION = createTextAttributesKey("IPC_FUNCTION", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    @NotNull @Override public Lexer getHighlightingLexer() {
        return new IPCLexerAdapter();
    }

    @NotNull @Override public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(IPCTypes.ENDPOINT)) return KEYWORDS;
        if (tokenType.equals(IPCTypes.INCLUDE)) return DIRECTIVES;
        if (tokenType.equals(IPCTypes.PATH)) return STRINGS;
        if (tokenType.equals(IPCTypes.COMMENT)) return COMMENTS;
        if (tokenType.equals(IPCTypes.PAREN_OPEN) || tokenType.equals(IPCTypes.PAREN_CLOSE) || tokenType.equals(IPCTypes.CURLY_OPEN) || tokenType.equals(IPCTypes.CURLY_CLOSE) || tokenType.equals(IPCTypes.BRACKET_OPEN) || tokenType.equals(IPCTypes.BRACKET_CLOSE))
            return BRACES;
        if (tokenType.equals(IPCTypes.COMMA)) return COMMAS;
        if (tokenType.equals(IPCTypes.SYNC) || tokenType.equals(IPCTypes.ASYNC)) return OPERATORS;
        if (tokenType.equals(IPCTypes.SCOPE_RESOLUTION)) return SCOPE_RESOLTIONS;
        if (tokenType.equals(TokenType.BAD_CHARACTER)) return BAD_CHARACTERS;

        return EMPTY;
    }
}
