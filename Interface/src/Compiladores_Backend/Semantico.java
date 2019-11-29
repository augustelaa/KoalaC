package Compiladores_Backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
                pularLinha();
                break;
            case 5:
                pilha.push(Tipos.t_int64);
                codigoGerado.append("ldc.i8 ");
                codigoGerado.append(token.getLexeme());
                pularLinha();
                codigoGerado.append("conv.r8");
                pularLinha();
                break;
            case 17:
                codigoGerado.append("ret");
                criarFonte();
                break;
        }
    }

    public void pularLinha() {
        codigoGerado.append(System.getProperty("line.separator"));
    }

    public void criarFonte() {
        File file = new File("fonte.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(codigoGerado.toString());
            if (writer != null) writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

