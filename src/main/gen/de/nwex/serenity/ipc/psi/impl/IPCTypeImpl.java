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

public class IPCTypeImpl extends ASTWrapperPsiElement implements IPCType {

  public IPCTypeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IPCVisitor visitor) {
    visitor.visitType(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IPCVisitor) accept((IPCVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public IPCList getList() {
    return findChildByClass(IPCList.class);
  }

  @Override
  @NotNull
  public List<IPCType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, IPCType.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
