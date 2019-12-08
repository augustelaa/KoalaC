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
    Stack<String> listaVariaveis = new Stack<String>();
    List<Variavel> tabelaVariaveis = new ArrayList<Variavel>();
    Stack<String> rotulos = new Stack<String>();
    int tamanho = 0;
    Tipos tipo = null;
    int contadorRotulos = 0;


    public void executeAction(int action, Token token) throws SemanticError {
        Tipos tipo1 = null;
        Tipos tipo2 = null;
        Variavel variavel = null;
        String operador = null;

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
            case 6:
                pilha.push(Tipos.t_float64);
                codigoGerado.append("ldc.r8 ");
                codigoGerado.append(token.getLexeme());
                pularLinha();
                break;
            case 7:
                tipo1 = pilha.pop();
                if (tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) {
                    pilha.push(tipo1);
                } else {
                    throw new SemanticError("Erro semântico.");
                }
                break;
            case 8:
                tipo1 = pilha.pop();
                if (tipo1 == Tipos.t_float64 || tipo1 == Tipos.t_int64) {
                    pilha.push(tipo1);
                } else {
                    throw new SemanticError("Erro semântico.");
                }
                codigoGerado.append("ldc.i8 -1");
                pularLinha();
                codigoGerado.append("conv.r8");
                pularLinha();
                codigoGerado.append("mul");
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
                codigoGerado.append("ldc.i4.1");
                pularLinha();
                break;
            case 12:
                pilha.push(Tipos.t_bool);
                codigoGerado.append("ldc.i4.0");
                pularLinha();
                break;
            case 13:
                tipo1 = pilha.pop();
                if (tipo1.equals(Tipos.t_bool)) {
                    pilha.push(Tipos.t_bool);
                } else {
                    //Deu pai
                }
                codigoGerado.append("ldc.i4.1");
                pularLinha();
                codigoGerado.append("xor");
                pularLinha();
                break;
            case 14:
                tipo1 = pilha.pop();
                if (tipo1 == Tipos.t_int64) {
                    codigoGerado.append("conv.r8");
                    pularLinha();
                }
                codigoGerado.append("call void [mscorlib]System.Console::Write(");
                codigoGerado.append(tipo1);
                codigoGerado.append(")");
                pularLinha();
                break;
            case 15:
                codigoGerado.append(".assembly extern mscorlib {}");
                pularLinha();
                codigoGerado.append(".assembly _codigo_objeto {}");
                pularLinha();
                codigoGerado.append(".module _codigo_objeto.exe");
                pularLinha();
                codigoGerado.append(".class public _UNICA {");
                pularLinha();
                break;
            case 16:
                codigoGerado.append(".method static public void _principal() {");
                criarFonte();
                codigoGerado.append(".entrypoint");
                criarFonte();
                break;
            case 17:
                codigoGerado.append("ret");
                criarFonte();
                codigoGerado.append("}");
                criarFonte();
                codigoGerado.append("}");
                criarFonte();
                break;
            case 20:
                pilha.push(Tipos.t_string);
                codigoGerado.append("ldstr ");
                codigoGerado.append(token.getLexeme());
                pularLinha();
                break;
            case 30:
                operador = token.getLexeme().substring(0,1).toUpperCase();
                switch (operador) {
                    case "I":
                        tipo = Tipos.t_int64;
                        break;
                    case "F":
                        tipo = Tipos.t_float64;
                        break;
                    case "B":
                        tipo = Tipos.t_bool;
                        break;
                    case "S":
                        tipo = Tipos.t_string;
                        break;
                }
            case 31:
                for (String var : listaVariaveis) {
                    if (variavelExiste(var) != null) {
                        throw new SemanticError("Erro semântico");
                    }
                    variavel = new Variavel();
                    variavel.setTipo(tipo);
                    variavel.setTamanho(tamanho);
                    variavel.setId(var);
                    codigoGerado.append(".locals(");
                    codigoGerado.append(Tipos.retornarOperadorDotNet(tipo));
                    codigoGerado.append(" ");
                    codigoGerado.append(var);
                    codigoGerado.append(")");
                    pularLinha();
                }
                tamanho = 0;
                listaVariaveis.clear();
                break;
            case 32:
                listaVariaveis.push(token.getLexeme());
                break;
            case 33:
                operador = token.getLexeme();
                variavel = variavelExiste(operador);
                if (variavel == null) {
                    throw new SemanticError("Erro semântico");
                }
                tipo1 = variavel.getTipo();
                pilha.push(tipo1);
                codigoGerado.append("ldloc ");
                codigoGerado.append(operador);
                if (tipo1 == Tipos.t_int64) {
                    codigoGerado.append("conv.r8");
                }
                break;
            case 34:
                operador = listaVariaveis.pop();
                variavel = variavelExiste(operador);
                if (variavel == null) {
                    throw new SemanticError("Erro semântico");
                }
                tipo1 = variavel.getTipo();
                if (tipo1 == Tipos.t_int64) {
                    codigoGerado.append("conv.i8");
                }

                if (variavel.getTamanho() > 0) {
                    codigoGerado.append("stelem ");
                    codigoGerado.append(variavel.getTipo());
                    pularLinha();
                } else {
                    codigoGerado.append("stloc ");
                    codigoGerado.append(operador);
                }
                pularLinha();
                break;
            case 35:
                for(String id : listaVariaveis) {
                    variavel = variavelExiste(id);
                    if (variavel == null) {
                        throw new SemanticError("Erro semântico");
                    }
                    tipo1 = variavel.getTipo();
                    String classe = "";
                    String tipo = "";

                    if (tipo1 == Tipos.t_int64) {
                        classe = "Int64";
                    } else if (tipo1 == Tipos.t_float64) {
                        classe = "Double";
                    }

                    tipo = Tipos.retornarOperadorDotNet(tipo1);

                    codigoGerado.append("call string [mscorlib]System.Console::ReadLine()");
                    pularLinha();
                    codigoGerado.append("call ");
                    codigoGerado.append(tipo);
                    codigoGerado.append(" [mscorlib]System.");
                    codigoGerado.append(classe);
                    codigoGerado.append("::Parse(string)");
                    pularLinha();
                    codigoGerado.append("stloc ");
                    codigoGerado.append(id);
                    pularLinha();
                }
                listaVariaveis.clear();
                break;
            case 36:
                tamanho = Integer.parseInt(token.getLexeme());
                break;
            case 39:
                codigoGerado.append("brfalse ");
                codigoGerado.append(adicionarRotulo());
                pularLinha();
                break;
            case 40:
                codigoGerado.append(rotulos.pop());
                codigoGerado.append(":");
                pularLinha();
                break;
            case 41:
                String rotulo_aux = rotulos.pop();
                codigoGerado.append("br ");
                codigoGerado.append(adicionarRotulo());
                pularLinha();
                codigoGerado.append(rotulo_aux);
                codigoGerado.append(":");
                pularLinha();
        }
    }

    public void pularLinha() {
        codigoGerado.append(System.getProperty("line.separator"));
    }

    public Variavel variavelExiste(String id) {
        for (Variavel v : tabelaVariaveis) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public String adicionarRotulo() {
        String rotulo = "r" + (contadorRotulos+1);
        rotulos.push(rotulo);
        return rotulo;
    }

    public void adicionarVariavel(String id, Tipos tipo) throws Exception {
        if (variavelExiste(id) == null) {
            Variavel v = new Variavel();
            v.setId(id);
            v.setTipo(tipo);
            tabelaVariaveis.add(v);
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
