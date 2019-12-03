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
    String operador = null;

    public void executeAction(int action, Token token) throws SemanticError {
        Tipos tipo1 = null;
        Tipos tipo2 = null;
        switch (action) {

            case 1:
                tipo1 = pilha.pop();
                tipo2 = pilha.pop();

                if ((tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) && (tipo2 == Tipos.t_float64 || tipo2 == Tipos.t_int64)) {

                    if (tipo1 == Tipos.t_float64 || tipo2 == Tipos.t_float64) {
                        pilha.push(Tipos.t_float64);
                    } else {
                        pilha.push(Tipos.t_int64);
                    }
                    codigoGerado.append("add");
                    this.pularLinha();
                } else {

                }
                break;

            case 2:
                tipo1 = pilha.pop();
                tipo2 = pilha.pop();

                if ((tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) && (tipo2 == Tipos.t_float64 || tipo2 == Tipos.t_int64)) {

                    if (tipo1 == Tipos.t_float64 || tipo2 == Tipos.t_float64) {
                        pilha.push(Tipos.t_float64);
                    } else {
                        pilha.push(Tipos.t_int64);
                    }
                    codigoGerado.append("sub");
                    this.pularLinha();
                } else {

                }
                break;
            case 3:
                tipo1 = pilha.pop();
                tipo2 = pilha.pop();

                if ((tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) && (tipo2 == Tipos.t_float64 || tipo2 == Tipos.t_int64)) {

                    if (tipo1 == Tipos.t_float64 || tipo2 == Tipos.t_float64) {
                        pilha.push(Tipos.t_float64);
                    } else {
                        pilha.push(Tipos.t_int64);
                    }
                    codigoGerado.append("mul");
                    this.pularLinha();
                } else {

                }
                break;
            case 4:
                tipo1 = pilha.pop();
                tipo2 = pilha.pop();

                if ((tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) && (tipo2 == Tipos.t_float64 || tipo2 == Tipos.t_int64)) {

                    if (tipo1.equals(tipo2)) {
                        pilha.push(tipo1);
                    } else {
                        //Deu pau
                    }
                    codigoGerado.append("div");
                    this.pularLinha();
                } else {

                }
                break;
            case 5:
                pilha.push(Tipos.t_int64);
                codigoGerado.append("ldc.i8 ");
                codigoGerado.append(token.getLexeme());
                pularLinha();
                codigoGerado.append("conv.r8");
                pularLinha();
                break;
            case 9:
                operador = token.getLexeme();
                break;
            case 10:
                tipo1 = pilha.pop();
                tipo2 = pilha.pop();

                if ((tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) && (tipo2 == Tipos.t_float64 || tipo2 == Tipos.t_int64)) {

                    if (tipo1.equals(tipo2)) {
                        pilha.push(Tipos.t_bool);
                    } else {
                        //Deu pau
                    }
                    switch (operador) {
                        case ">":
                            codigoGerado.append("cgt");
                            break;
                        case "<":
                            codigoGerado.append("clt");
                            break;
                        case "=":
                            codigoGerado.append("ceq");
                            break;

                    }
                    this.pularLinha();
                } else {

                }
                break;
            case 11:
                pilha.push(Tipos.t_bool);
                codigoGerado.append("ldc.i4.1"); //REvisar
                pularLinha();
                break;
            case 12:
                pilha.push(Tipos.t_bool);
                codigoGerado.append("ldc.i4.0"); //REvisar
                pularLinha();
                break;
            case 15:
                codigoGerado.append(".assembly extern mscorlib ..."); //REvisar
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
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
