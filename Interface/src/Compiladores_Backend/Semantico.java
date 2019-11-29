package Compiladores_Backend;

import java.util.Stack;

public class Semantico implements Constants {

    StringBuilder codigoGerado = new StringBuilder();
    Stack<Tipos> pilha = new Stack<Tipos>();

    public void executeAction(int action, Token token) throws SemanticError {
        Tipos tipo1;
        Tipos tipo2;
        switch (action) {
            case 15:
                codigoGerado.append(".assembly extern mscorlib ..."); //COmpletar
                break;
            case 5:
                pilha.push(Tipos.t_int64);
                codigoGerado.append("ldc.i8 ");
                codigoGerado.append(token.getLexeme());
                codigoGerado.append("\n conv.r8");
                break;
            case 1: 
                Tipos tipo1 = pilha.pop();
                Tipos tipo2 = pilha.pop();
                
                if (tipo1 == Tipos.t_float64 || tipo2 == Tipos.t_float64) { 
                    pilha.push(Tipos.t_float64);
                } else {
                    pilha.push(Tipos.t_int64);
                }
                codigoGerado.append("add");
                break;
                
                case 2:
                Tipos tipo1 = pilha.pop();
                Tipos tipo2 = pilha.pop();
                
                if (tipo1 == Tipos.t_float64 || tipo2 == Tipos.t_float64) { 
                    pilha.push(Tipos.t_float64);
                } else {
                    pilha.push(Tipos.t_int64);
                }
                codigoGerado.append("add");
                break;    
        }
    }
}
