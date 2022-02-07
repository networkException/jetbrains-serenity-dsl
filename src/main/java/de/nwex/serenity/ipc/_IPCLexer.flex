package de.nwex.serenity.ipc;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.nwex.serenity.ipc.IPCTypes.*;

%%

%{
  public _IPCLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _IPCLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
COMMENT="//".*
IDENTIFIER=[a-zA-Z_][a-zA-Z0-9_]*
PATH=[\w/.]*

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "endpoint"         { return ENDPOINT; }
  "#include"         { return INCLUDE; }
  "("                { return PAREN_OPEN; }
  ")"                { return PAREN_CLOSE; }
  "{"                { return CURLY_OPEN; }
  "}"                { return CURLY_CLOSE; }
  "<"                { return ANGLE_OPEN; }
  ">"                { return ANGLE_CLOSE; }
  "["                { return BRACKET_OPEN; }
  "]"                { return BRACKET_CLOSE; }
  ","                { return COMMA; }
  "=>"               { return SYNC; }
  "=|"               { return ASYNC; }
  "::"               { return SCOPE_RESOLUTION; }

  {SPACE}            { return SPACE; }
  {COMMENT}          { return COMMENT; }
  {IDENTIFIER}       { return IDENTIFIER; }
  {PATH}             { return PATH; }

}

[^] { return BAD_CHARACTER; }
