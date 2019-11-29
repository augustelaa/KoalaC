package Compiladores_Backend;

import java.util.Stack;

public class Semantico implements Constants
{
    StringBuilder codigoGerado = new StringBuilder();
    Stack<Tipos> pilha = new Stack<Tipos>();

    public void executeAction(int action, Token token)	throws SemanticError
    {
        switch(action) {
            case 15:
                codigoGerado.append(".assembly extern mscorlib ...");
                break;
            case 5:
                pilha.push(Tipos.t_int64);
                codigoGerado.append("ldc.i8 ");
                codigoGerado.append(token.getLexeme());
                codigoGerado.append("\n conv.r8");
                break;
        }
    }	
}

