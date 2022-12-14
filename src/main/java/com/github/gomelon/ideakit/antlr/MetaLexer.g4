lexer grammar MetaLexer;

META_QUALIFY_NAME: PLUS(IDENT DOT)*IDENT;

//keyword
STRING:               STRING_F ~('"')* STRING_F;
BOOLEAN:              'true'|'false';
FLOAT:                DIGIT+ DOT DIGIT+;
INTEGER:              DIGIT+;

LINE_COMMENT:         '//';
BLOCK_COMMENT_START:  '/*';
BLOCK_COMMENT_END:    '*/' ;
IDENT:                (ALPHA|UNDERSCORE)(ALPHA|DIGIT|UNDERSCORE|'-')*;

// WHITE SPACE
WS:         [ \t\r\n]+ -> channel(HIDDEN) ;

fragment DIGIT:       [0-9];
fragment UNDERSCORE:  '_';
fragment ALPHA:       [a-zA-Z];
fragment STRING_F:    '"';

PLUS:                 '+';
ASSIGNMENT:           '=';
DOT:                  '.';


ERRCHAR
	:	.	-> channel(HIDDEN)
	;