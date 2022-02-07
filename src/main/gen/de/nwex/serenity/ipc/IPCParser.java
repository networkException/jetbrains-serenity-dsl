// This is a generated file. Not intended for manual editing.
package de.nwex.serenity.ipc;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.nwex.serenity.ipc.IPCTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class IPCParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // [ "[" IDENTIFIER "]" ]
  public static boolean attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attribute")) return false;
    Marker m = enter_section_(b, l, _NONE_, ATTRIBUTE, "<attribute>");
    parseTokens(b, 0, BRACKET_OPEN, IDENTIFIER, BRACKET_CLOSE);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ENDPOINT IDENTIFIER "{" [ function-statement * ] "}"
  public static boolean endpoint_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endpoint_statement")) return false;
    if (!nextTokenIs(b, ENDPOINT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ENDPOINT, IDENTIFIER, CURLY_OPEN);
    r = r && endpoint_statement_3(b, l + 1);
    r = r && consumeToken(b, CURLY_CLOSE);
    exit_section_(b, m, ENDPOINT_STATEMENT, r);
    return r;
  }

  // [ function-statement * ]
  private static boolean endpoint_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endpoint_statement_3")) return false;
    endpoint_statement_3_0(b, l + 1);
    return true;
  }

  // function-statement *
  private static boolean endpoint_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endpoint_statement_3_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!function_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "endpoint_statement_3_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER "(" parameter-list ")" { SYNC "(" [ parameter-list ] ")" | ASYNC }
  public static boolean function_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_statement")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, PAREN_OPEN);
    r = r && parameter_list(b, l + 1);
    r = r && consumeToken(b, PAREN_CLOSE);
    r = r && function_statement_4(b, l + 1);
    exit_section_(b, m, FUNCTION_STATEMENT, r);
    return r;
  }

  // SYNC "(" [ parameter-list ] ")" | ASYNC
  private static boolean function_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_statement_4_0(b, l + 1);
    if (!r) r = consumeToken(b, ASYNC);
    exit_section_(b, m, null, r);
    return r;
  }

  // SYNC "(" [ parameter-list ] ")"
  private static boolean function_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SYNC, PAREN_OPEN);
    r = r && function_statement_4_0_2(b, l + 1);
    r = r && consumeToken(b, PAREN_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ parameter-list ]
  private static boolean function_statement_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_statement_4_0_2")) return false;
    parameter_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // { "<" | '"' } PATH { ">" | '"' }
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = header_0(b, l + 1);
    r = r && consumeToken(b, PATH);
    r = r && header_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "<" | '"'
  private static boolean header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_0")) return false;
    boolean r;
    r = consumeToken(b, ANGLE_OPEN);
    if (!r) r = consumeToken(b, "\"");
    return r;
  }

  // ">" | '"'
  private static boolean header_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_2")) return false;
    boolean r;
    r = consumeToken(b, ANGLE_CLOSE);
    if (!r) r = consumeToken(b, "\"");
    return r;
  }

  /* ********************************************************** */
  // INCLUDE header
  public static boolean include_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement")) return false;
    if (!nextTokenIs(b, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUDE);
    r = r && header(b, l + 1);
    exit_section_(b, m, INCLUDE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // <<p>> (',' <<p>>) *
  public static boolean list(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "list")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = _p.parse(b, l);
    r = r && list_1(b, l + 1, _p);
    exit_section_(b, m, LIST, r);
    return r;
  }

  // (',' <<p>>) *
  private static boolean list_1(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_1_0(b, l + 1, _p)) break;
      if (!empty_element_parsed_guard_(b, "list_1", c)) break;
    }
    return true;
  }

  // ',' <<p>>
  private static boolean list_1_0(PsiBuilder b, int l, Parser _p) {
    if (!recursion_guard_(b, l, "list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && _p.parse(b, l);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // attribute type IDENTIFIER
  public static boolean parameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER, "<parameter>");
    r = attribute(b, l + 1);
    r = r && type(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [ <<list parameter>> ]
  public static boolean parameter_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_list")) return false;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_LIST, "<parameter list>");
    list(b, l + 1, IPCParser::parameter);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // [ include-statement * ] endpoint-statement
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    if (!nextTokenIs(b, "", ENDPOINT, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = root_0(b, l + 1);
    r = r && endpoint_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ include-statement * ]
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    root_0_0(b, l + 1);
    return true;
  }

  // include-statement *
  private static boolean root_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!include_statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER "<" <<list type>> ">" | <<type>> ('::' <<type>>) | IDENTIFIER
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = type_0(b, l + 1);
    if (!r) r = type_1(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER "<" <<list type>> ">"
  private static boolean type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ANGLE_OPEN);
    r = r && list(b, l + 1, IPCParser::type);
    r = r && consumeToken(b, ANGLE_CLOSE);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<type>> ('::' <<type>>)
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type(b, l + 1);
    r = r && type_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '::' <<type>>
  private static boolean type_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCOPE_RESOLUTION);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
