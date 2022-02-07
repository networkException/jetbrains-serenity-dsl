package de.nwex.serenity.ipc;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import de.nwex.serenity.Icons;
import java.util.Map;
import javax.swing.Icon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IPCColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("Keyword", IPCSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("Directive", IPCSyntaxHighlighter.DIRECTIVE),
        new AttributesDescriptor("String", IPCSyntaxHighlighter.STRING),
        new AttributesDescriptor("Comment", IPCSyntaxHighlighter.COMMENT),
        new AttributesDescriptor("Comma", IPCSyntaxHighlighter.COMMA),
        new AttributesDescriptor("Brace", IPCSyntaxHighlighter.BRACE),
        new AttributesDescriptor("Scope Resolution", IPCSyntaxHighlighter.SCOPE_RESOLUTION),
        new AttributesDescriptor("Operator", IPCSyntaxHighlighter.OPERATOR),
        new AttributesDescriptor("Bad Character", IPCSyntaxHighlighter.BAD_CHARACTER)
    };

    @Nullable @Override public Icon getIcon() {
        return Icons.IPC;
    }

    @NotNull @Override public SyntaxHighlighter getHighlighter() {
        return new IPCSyntaxHighlighter();
    }

    @NotNull @Override public String getDemoText() {
        return "#include <AK/URL.h>\n"
            + "\n"
            + "// FIXME: Remove this comment\n"
            + "\n"
            + "endpoint ImaginaryEndpoint\n"
            + "{\n"
            + "    request_a_value(String with, AK::Vector<bool> some, i32 parameters) => (URL value)\n"
            + "    just_send_something() =|\n"
            + "    \n"
            + "    look_an([UTF8] String attribute_exclamation_mark) =|\n"
            + "}";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Serenity IPC";
    }
}
