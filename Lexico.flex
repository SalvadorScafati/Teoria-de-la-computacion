import java_cup.runtime.*;
import java.util.*;

%%


/*%cupsym Simbolo*/
%cup
%public
%class Lexico
%line
%column
%char


LETRA = [a-zA-Z]
DIGITO = [0-9]
PUNTO = [.]
ESPACIO = [ \t\f\n\r\f]+
ID = {LETRA}({LETRA}|{DIGITO})*
CONST_INT = {DIGITO}+
COM = [\"]
CONST_STRING = {COM}({LETRA}|{DIGITO}|{ESPACIO})*{COM}
CONST_FLOAT = {DIGITO}+{PUNTO}{DIGITO}+
CONST_CHAR = {COM}{LETRA}{COM}
COMENTARIO = [//*]({LETRA}|{DIGITO}|{ESPACIO})*[*//]


%%

<YYINITIAL> {



{COMENTARIO} {/*no imprime nada*/}

"::="	{System.out.println("Token ASIGN encontrado, Lexema "+ yytext());}

"+"	{System.out.println("Token OP_A_SUMA encontrado Lexema " + yytext()); }

"-"	{System.out.println("Token OP_A_RESTA encontrado Lexema " + yytext()); }

"*"	{System.out.println("Token OP_A_PROD encontrado Lexema " + yytext()); }

"/"	{System.out.println("Token OP_A_DIV encontrado Lexema " + yytext()); }

"div" {System.out.println("Token PR_OP_A_RSTO encontrado Lexema " + yytext()); }

"mod" {System.out.println("Token PR_OP_A_MOD encontrado Lexema " + yytext()); }

">="	{System.out.println("Token OP_CMP_MENI encontrado Lexema " + yytext()); }

"<="	{System.out.println("Token OP_CMP_L_MAYI encontrado Lexema " + yytext()); }

"<"	{System.out.println("Token OP_CMP_MEN encontrado Lexema " + yytext()); }

">"	{System.out.println("Token OP_CMP_MAY encontrado Lexema " + yytext()); }

"=="	{System.out.println("Token OP_CMP_L_IGUL encontrado Lexema " + yytext()); }

"or"	{System.out.println("Token PR_OP_L_OR encontrado Lexema " + yytext()); }

"and"	{System.out.println("Token PR_OP_L_AND encontrado Lexema " + yytext()); }

"xor"	{System.out.println("Token PR_OP_L_XOR encontrado Lexema " + yytext()); }

"true"	{System.out.println("Token CTE_TRUE encontrado Lexema " + yytext()); }

"false"	{System.out.println("Token CTE_FALSE encontrado Lexema " + yytext()); }

"DECLARE.SECTION"	{System.out.println("Token INI_DS encontrado Lexema " + yytext()); }

"ENDDECLARE.SECTION"	{System.out.println("Token FIN_DS encontrado Lexema " + yytext()); }

"PROGRAM.SECTION"	{System.out.println("Token INI_PS encontrado Lexema " + yytext()); }

"ENDPROGRAM.SECTION"	{System.out.println("Token FIN_PS encontrado Lexema " + yytext()); }

";"	{System.out.println("Token FIN_SNT encontrado Lexema " + yytext()); }

","	{System.out.println("Token SEP_D encontrado Lexema " + yytext()); }

"{"	{System.out.println("Token INI_BD encontrado Lexema " + yytext()); }

"}"	{System.out.println("Token FIN_BD encontrado Lexema " + yytext()); }

"("	{System.out.println("Token INI_PARAM encontrado Lexema " + yytext()); }

")"	{System.out.println("Token FIN_PARAM encontrado Lexema " + yytext()); }

"["	{System.out.println("Token INI_PARAM_VEC encontrado Lexema " + yytext()); }

"]"	{System.out.println("Token FIN_PARAM_VEC encontrado Lexema " + yytext()); }

"write" {System.out.println("Token PR_OP_WRITE encontrado Lexema " + yytext()); }

"int" {System.out.println("Token PR_TD_INT encontrado Lexema " + yytext());}

"float" {System.out.println("Token PR_TD_FLOAT encontrado Lexema " + yytext()); }

"char" {System.out.println("Token PR_TD_CHAR encontrado Lexema " + yytext()); }

"string" {System.out.println("Token PR_TD_STR encontrado Lexema " + yytext()); }

"boolean" {System.out.println("Token PR_TD_BOOL encontrado Lexema " + yytext()); }

"array" {System.out.println("Token PR_TD_ARRAY encontrado Lexema " + yytext()); }

"while" {System.out.println("Token PR_OP_LOOP encontrado Lexema " + yytext()); }

"cola" {System.out.println("Token PR_OP_COLA encontrado Lexema " + yytext());}

"if" {System.out.println("Token PR_OP_DSC encontrado Lexema " + yytext()); }

"else" {System.out.println("Token PR_OP_ELSE encontrado Lexema " + yytext()); }

"qadd" {System.out.println("Token PR_OP_Q_ADD encontrado Lexema " + yytext()); }

"qrmv" {System.out.println("Token PR_OP_Q_REMOV encontrado Lexema " + yytext()); }

"qmpty" {System.out.println("Token PR_OP_Q_EMPTY encontrado Lexema " + yytext()); }

"qrtn" {System.out.println("Token PR_OP_Q_RTN encontrado Lexema " + yytext()); }

"qlth" {System.out.println("Token PR_OP_Q_LNGTH encontrado Lexema " + yytext()); }

{CONST_INT}		{if (Integer.parseInt(yytext())>32768 || Integer.parseInt(yytext())<-32768){System.out.println("Token PR_TD_INT fuera de rango " + yytext());}else{System.out.println("Token CTE_INT, encontrado Lexema "+ yytext());}}

{CONST_FLOAT}	{System.out.println("Token CTE_FLOAT, encontrado Lexema "+ yytext());}

{CONST_CHAR}		{System.out.println("Token CTE_CHAR, encontrado Lexema "+ yytext());}

{CONST_STRING}		{System.out.println("Token CTE_STR, encontrado Lexema "+ yytext());}

{ID}		{System.out.println("Token ID encontrado, Lexema "+ yytext());}

{ESPACIO}	{/*ESPACIO*/}

}

[^]		{ throw new Error("Caracter no permitido: <" + yytext() + "> en la linea " + yyline); }
