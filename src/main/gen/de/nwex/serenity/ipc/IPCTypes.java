// This is a generated file. Not intended for manual editing.
package de.nwex.serenity.ipc;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.nwex.serenity.ipc.psi.impl.*;

public interface IPCTypes {

  IElementType ATTRIBUTE = new IPCElementType("ATTRIBUTE");
  IElementType ENDPOINT_STATEMENT = new IPCElementType("ENDPOINT_STATEMENT");
  IElementType FUNCTION_STATEMENT = new IPCElementType("FUNCTION_STATEMENT");
  IElementType HEADER = new IPCElementType("HEADER");
  IElementType INCLUDE_STATEMENT = new IPCElementType("INCLUDE_STATEMENT");
  IElementType LIST = new IPCElementType("LIST");
  IElementType PARAMETER = new IPCElementType("PARAMETER");
  IElementType PARAMETER_LIST = new IPCElementType("PARAMETER_LIST");
  IElementType TYPE = new IPCElementType("TYPE");

  IElementType ANGLE_CLOSE = new IPCTokenType(">");
  IElementType ANGLE_OPEN = new IPCTokenType("<");
  IElementType ASYNC = new IPCTokenType("=|");
  IElementType BRACKET_CLOSE = new IPCTokenType("]");
  IElementType BRACKET_OPEN = new IPCTokenType("[");
  IElementType COMMA = new IPCTokenType(",");
  IElementType COMMENT = new IPCTokenType("COMMENT");
  IElementType CURLY_CLOSE = new IPCTokenType("}");
  IElementType CURLY_OPEN = new IPCTokenType("{");
  IElementType ENDPOINT = new IPCTokenType("endpoint");
  IElementType IDENTIFIER = new IPCTokenType("IDENTIFIER");
  IElementType INCLUDE = new IPCTokenType("#include");
  IElementType PAREN_CLOSE = new IPCTokenType(")");
  IElementType PAREN_OPEN = new IPCTokenType("(");
  IElementType PATH = new IPCTokenType("PATH");
  IElementType SCOPE_RESOLUTION = new IPCTokenType("::");
  IElementType SYNC = new IPCTokenType("=>");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATTRIBUTE) {
        return new IPCAttributeImpl(node);
      }
      else if (type == ENDPOINT_STATEMENT) {
        return new IPCEndpointStatementImpl(node);
      }
      else if (type == FUNCTION_STATEMENT) {
        return new IPCFunctionStatementImpl(node);
      }
      else if (type == HEADER) {
        return new IPCHeaderImpl(node);
      }
      else if (type == INCLUDE_STATEMENT) {
        return new IPCIncludeStatementImpl(node);
      }
      else if (type == LIST) {
        return new IPCListImpl(node);
      }
      else if (type == PARAMETER) {
        return new IPCParameterImpl(node);
      }
      else if (type == PARAMETER_LIST) {
        return new IPCParameterListImpl(node);
      }
      else if (type == TYPE) {
        return new IPCTypeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
