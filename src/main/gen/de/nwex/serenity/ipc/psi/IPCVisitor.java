// This is a generated file. Not intended for manual editing.
package de.nwex.serenity.ipc.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IPCVisitor extends PsiElementVisitor {

  public void visitAttribute(@NotNull IPCAttribute o) {
    visitPsiElement(o);
  }

  public void visitEndpointStatement(@NotNull IPCEndpointStatement o) {
    visitPsiElement(o);
  }

  public void visitFunctionStatement(@NotNull IPCFunctionStatement o) {
    visitPsiElement(o);
  }

  public void visitHeader(@NotNull IPCHeader o) {
    visitPsiElement(o);
  }

  public void visitIncludeStatement(@NotNull IPCIncludeStatement o) {
    visitPsiElement(o);
  }

  public void visitList(@NotNull IPCList o) {
    visitPsiElement(o);
  }

  public void visitParameter(@NotNull IPCParameter o) {
    visitPsiElement(o);
  }

  public void visitParameterList(@NotNull IPCParameterList o) {
    visitPsiElement(o);
  }

  public void visitType(@NotNull IPCType o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
