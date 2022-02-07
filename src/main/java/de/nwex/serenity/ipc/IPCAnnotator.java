package de.nwex.serenity.ipc;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import de.nwex.serenity.ipc.psi.IPCFunctionStatement;
import de.nwex.serenity.ipc.psi.IPCIncludeStatement;
import org.jetbrains.annotations.NotNull;

public class IPCAnnotator implements Annotator {

    @Override public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof IPCFunctionStatement) holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(((IPCFunctionStatement) element).getIdentifier())
            .textAttributes(IPCSyntaxHighlighter.FUNCTION)
            .create();

        if (element instanceof IPCIncludeStatement) holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(((IPCIncludeStatement) element).getHeader())
            .textAttributes(IPCSyntaxHighlighter.STRING)
            .create();
    }
}
