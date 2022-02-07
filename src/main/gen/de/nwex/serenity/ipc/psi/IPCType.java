// This is a generated file. Not intended for manual editing.
package de.nwex.serenity.ipc.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IPCType extends PsiElement {

  @Nullable
  IPCList getList();

  @NotNull
  List<IPCType> getTypeList();

  @Nullable
  PsiElement getIdentifier();

}
