package Compiladores_Backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Semantico implements Constants {

    StringBuilder codigoGerado = new StringBuilder();
    Stack<Tipos> pilha = new Stack<Tipos>();
    List<String> listaVariaveis = new ArrayList<String>();

    public void executeAction(int action, Token token) throws SemanticError {
        Tipos tipo1;
        Tipos tipo2;
        switch (action) {
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
            case 17:
                codigoGerado.append("ret");
                criarFonte();
                break;
        }
    }

    public void pularLinha() {
        codigoGerado.append(System.getProperty("line.separator"));
    }

    public Boolean variavelExiste(String variavel) {
        if (listaVariaveis.contains(variavel)) {
            return true;
        }
        return false;
    }

    public void adicionarVariavel(String variavel) throws Exception {
        if (!variavelExiste(variavel)) {
            listaVariaveis.add(variavel);
        } else {
            throw new Exception("Variavel já usada.");
        }
    }

    public void criarFonte() {
        File file = new File("fonte.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(codigoGerado.toString());
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
