// This is a generated file. Not intended for manual editing.
package de.nwex.serenity.ipc.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.nwex.serenity.ipc.IPCTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.nwex.serenity.ipc.psi.*;

public class IPCParameterImpl extends ASTWrapperPsiElement implements IPCParameter {

  public IPCParameterImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IPCVisitor visitor) {
    visitor.visitParameter(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IPCVisitor) accept((IPCVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public IPCAttribute getAttribute() {
    return findNotNullChildByClass(IPCAttribute.class);
  }

  @Override
  @NotNull
  public IPCType getType() {
    return findNotNullChildByClass(IPCType.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
