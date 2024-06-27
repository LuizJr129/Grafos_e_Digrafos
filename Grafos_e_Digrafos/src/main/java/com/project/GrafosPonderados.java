package com.project;

import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GrafosPonderados extends Vertice_Vizinho {

    public GrafosPonderados(float valor_peso, String valor_vertice) {
        super(valor_peso, valor_vertice);
    }

    public static void main(String[] args) {

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>(); // Guarda os valores com a
                                                                                          // chave e a
        // lista de vertice que se conectam
        String opcao_usuario; // para seguir os passos dos usuarios.
        Scanner sc = new Scanner(System.in); // Usado para a leitura da entrada do usuario

        do { // usado na logica do while

            System.out.println(
                    "\nEscolha uma das opções abaixo: \n 1 - Adicionar Vértice \n 2 - Adicionar Aresta \n 3 - Verificar a Quantidade de Laços no Grafo \n 4 - Verificar a Quantidade de Aresta Múltiplas \n 5 - Verificar se o Grafo é completo \n 6 - Conferir o grau de um Vértices específico \n 7 - Imprimir o menor caminho de um vértice ao outro  \n 8 - Sair do Programa");
            // texto que aparece pro usuario
            System.out.println("\n");
            opcao_usuario = sc.nextLine(); // Oque o Usuario escolheu
            switch (opcao_usuario) { // Pega oque o usuario adicionou e para cada caso de entrada, faça oque deve ser
                                     // feito
                case "1": // Adicionar Vértice
                    String inserir_vertice; // para inserir o nome dos vertices.
                    System.out.println("Insira o nome do Vértice: ");
                    inserir_vertice = sc.nextLine(); // Lê oque o usuario colocou
                    InserirVertice(Valores_inseridos, inserir_vertice);
                    // um LinkedList vazio
                    System.out.println("\n");

                    break;
                case "2":

                    boolean verifica_existencia_vertice = false;
                    String vertice_saida; // auxilia na adição
                    String vertice_entrada; // auxilia na adição
                    float peso;

                    do {

                        System.out.println("Insira o nome do Vértice de origem: ");
                        vertice_saida = sc.nextLine(); // Lê oque o usuario colocou
                        System.out.println("\n");
                        System.out.println("Insira o nome do Vértice de destino: ");
                        vertice_entrada = sc.nextLine(); // Lê oque o usuario colocou
                        System.out.println("\n");

                        System.out.println("Insira o peso desta aresta: ");
                        peso = sc.nextFloat(); // Lê oque o usuario colocou
                        sc.nextLine(); // limpar scanner
                        System.out.println("\n");

                        if (Valores_inseridos.containsKey(vertice_saida)
                                && Valores_inseridos.containsKey(vertice_entrada)) { // Verifica se os dois vertices
                                                                                     // existem
                            AdicionarAresta(Valores_inseridos, vertice_entrada, vertice_saida, peso);

                            System.out.println("Aresta saindo do vértice " + vertice_saida + " ligando-se ao vértice "
                                    + vertice_entrada + " com o peso de " + peso + " adicionado!");
                            System.out.println("\n");
                            verifica_existencia_vertice = true;

                        } else {

                            System.out.println("Algum dos vértices não existe!! Tente novamente!!");
                            System.out.println("\n");
                            verifica_existencia_vertice = false;
                        }
                    } while (verifica_existencia_vertice != true); // Enquanto não adicionar valores verdadeiros ao dos
                                                                   // vertices existes, fica repetindo

                    break;
                case "3":
                    System.out.println("Existe " + ConfereLacos(Valores_inseridos) + " laços no Grafo.");
                    System.out.println("\n");
                    break;
                case "4":
                    System.out.println("\nExiste " + QtdArestaMultipla(Valores_inseridos) + " Arestas Múltiplas.");
                    break;
                case "5":
                    if (GrafoCompleto(Valores_inseridos) == true) {
                        System.out.println("\nÉ um grafo completo!!");
                    } else {
                        System.out.println("\nÉ um grafo incompleto!!");
                    } // retorno
                    break;

                case "6":

                    boolean verifica_existencia_verticee = false; // para verificar se o vertice colocado existe
                    String vertice_grau; // auxilia na adição
                    do {
                        System.out.println("Qual vértice deverá verificar o grau?");
                        vertice_grau = sc.nextLine(); // Lê oque o usuario colocou
                        System.out.println("\n");
                        if (Valores_inseridos.containsKey(vertice_grau)) { // Verifica se o vertice existe

                            System.out.println("O grau do vértice " + vertice_grau + " é de "
                                    + (VerificaGrau(Valores_inseridos, vertice_grau))); // imprime o grau
                            verifica_existencia_verticee = true;
                        } else {

                            System.out.println("O vértice não existe!! Tente novamente!!");
                            System.out.println("\n");
                            verifica_existencia_verticee = false;
                        }
                    } while (verifica_existencia_verticee != true); // Enquanto não adicionar valores verdadeiros ao dos
                                                                    // vertices existes, fica repetindo

                    break;
                case "7":

                    // Método para encontrar o caminho mais curto entre dois vértices em um grafo
                    boolean verifica_existencia_vertice_caminho = false;
                    String source;
                    String destination;

                    do {
                        System.out.print("Digite o vértice de origem: ");
                        source = sc.nextLine();
                        System.out.print("Digite o vértice de destino: ");
                        destination = sc.nextLine();

                        if (Valores_inseridos.containsKey(source)
                                && Valores_inseridos.containsKey(destination)) { // Verifica se os dois vertices
                                                                     // existem
                                                                     verifica_existencia_vertice_caminho = true;

                        } else {

                            System.out.println("Algum dos vértices não existe!! Tente novamente!!");
                            System.out.println("\n");
                            verifica_existencia_vertice_caminho = false;
                        }
                    } while (verifica_existencia_vertice_caminho != true); // Enquanto não adicionar valores verdadeiros ao dos
                                                                   // vertices existes, fica repetindo

                    System.out.println(CaminhoMaisCurto(Valores_inseridos, source, destination));    
                    
                    break;
                case "8":
                    System.out.println("Programa encerrado!!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha novamente.");
                    break;
            }

        } while (!opcao_usuario.equals("8")); // continue enquanto a escolha for diferente de 4(exit)
        // for (String key : Valores_inseridos.keySet()) {
        // System.out.println(key + ": " + Valores_inseridos.get(key));
        // }
    }

    public static String CaminhoMaisCurto(HashMap<String, LinkedList<Vertice_Vizinho>> graph, String source, String destination) {
        // Método para encontrar o caminho mais curto entre dois vértices em um grafo
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        // Cria um novo objeto da classe DijkstraAlgorithm e passa o grafo para ele

        HashMap<String, Float> shortestPaths = dijkstra.findShortestPaths(source);
        // Encontra os caminhos mais curtos a partir do vértice de origem

        HashMap<String, String> predecessors = dijkstra.getPredecessors();
        // Obtém os predecessores dos vértices no caminho mais curto

        if (shortestPaths.get(destination) == Float.MAX_VALUE) {
            // Se não houver caminho do vértice de origem para o vértice de destino
            System.out.println("\nNão há caminho do vértice " + source + " para o vértice " + destination);
        } else {
            // Se houver caminho do vértice de origem para o vértice de destino
            
            
                   String x = "\nPeso mínimo do caminho do vértice " + source + " para o vértice " + destination + " é de "
                            + shortestPaths.get(destination) + " pelo caminho a seguir: "
                            + formatPath(buildPath(predecessors, destination));

                            return x;
        }
        return destination;
    }

    private static String formatPath(List<String> path) {
        // Método para formatar o caminho em uma string no formato "1 -> 3 -> 4"
        return String.join(" -> ", path);
    }

    private static List<String> buildPath(HashMap<String, String> predecessors, String destination) {
        // Método para construir o caminho a partir dos predecessores
        List<String> path = new LinkedList<>();
        for (String at = destination; at != null; at = predecessors.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static int VerificaGrau(HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos, String vertice_grau) {

        int grau = 0; // para contar o grau
        for (String chave : Valores_inseridos.keySet()) { // passa por todos os hashmaps

            if (chave.equals(vertice_grau)) { // Se a chave for igual ao adicionado pelo usuario
                grau += Valores_inseridos.get(chave).size(); // soma ao grau o tamanho da linkedlist
                                                             // da key
            }
        }

        for (String chaves : Valores_inseridos.keySet()) { // passa por todos os hashmaps
            if (!chaves.equals(vertice_grau)) { // se for diferente da chave procurada
                for (Vertice_Vizinho elemento : Valores_inseridos.get(chaves)) { // verifica nos linkedlist
                    // se existe o vertice
                    // solicitado pelo usuario
                    if (elemento.getValor_vertice().contains(vertice_grau)) { // se existe
                        grau++; // conta mais 1
                    }
                }
            }

        }

        return grau / 2;

    }

    public static boolean GrafoCompleto(HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos) {
        HashMap<String, String> todascombinacoes = new HashMap<>(); // criado para adicionar uma string que
        // junta todas as ligações da
        // chave(vertice)

        for (String key : Valores_inseridos.keySet()) { // Passa por todos os Hashmaps
            StringBuilder builder = new StringBuilder(); // cria um stringbuilder para juntar as ligações

            for (Vertice_Vizinho elemento : Valores_inseridos.get(key)) { // Passa por todos os elementos da lista
                // desta chave
                builder = builder.append(elemento.getValor_vertice()); // vai adicionando os elementos no string
                // builder(juntando eles)
            }

            String todas_combinacoes_string = builder.toString(); // cria a frase com o string builder

            todascombinacoes.put(key, todas_combinacoes_string); // adiciona a chave e suas ligações no
            // hashmap
        } // faz para todos os strings

        boolean grafo_completo = false; // criado para ver se o grafo são completo ou incompleto
        for (String key : todascombinacoes.keySet()) { // Passa por todos os Hashmaps
            for (String keys : todascombinacoes.keySet()) { // Passa por todos os Hashmaps
                if (!key.equals(keys)) { // Só não passa por ele mesmo.
                    if (todascombinacoes.get(key).contains(keys)) { // Se na lista desta chave, contém a
                        // chave das proximas.
                        grafo_completo = true; // completo
                    } else {
                        grafo_completo = false; // se não, incompleto
                        if (todascombinacoes.get(keys).contains(key)) { // e verifica se na sua lista,
                            // existe a ligação com a chave que
                            // estava comparando.
                            grafo_completo = true; // se sim, é completo
                        } else {
                            grafo_completo = false; // se não, é incompleto
                        }
                    }
                }

            }
            if (Valores_inseridos.size() == 1 && !todascombinacoes.isEmpty()) { // tratamento de erro,
                // quando tem apenas um
                // vertice que é ligado a si
                // mesmo.
                grafo_completo = true;
            }

        } // faz para todos os strings

        return grafo_completo;

    }

    public static int QtdArestaMultipla(HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos) {
        LinkedList<String> auxiliar_multipla = new LinkedList<>(); // Auxilia para guardar as combinações

        int qtd_multipla = 0; // indice que contará quantas multiplas tem.

        HashSet<String> elementosunicos = new HashSet<>(); // Evita de colocar ligações duplicadas para a
                                                           // contagem.

        for (String key : Valores_inseridos.keySet()) { // Passa por todos os Hashmaps
            for (Vertice_Vizinho elemento : Valores_inseridos.get(key)) { // Passa por todos os elementos da lista
                // desta chave
                String auxilar_junção = key + elemento.getValor_vertice(); // junta a chave com a sua ligação.
                if (elementosunicos.add(auxilar_junção)) { // Se for adicionado no HashSet, ou seja, não é
                                                           // elemento repetido, faça....

                    auxiliar_multipla.add(auxilar_junção); // adiciona a junção de elementos a lista
                                                           // auxiliar
                }
            }
        }

        for (String str1 : auxiliar_multipla) { // os str1 recebe a lista auxiliar
            for (String str2 : auxiliar_multipla) { // os str2 recebe a lista auxiliar
                if (!str1.equals(str2)) { // Evita comparar a mesma string, só compara os que são
                                          // diferentes.
                    if (compararStrings(str1, str2)) { // chama o metodo para comparar se são iguais as
                                                       // string, já ordenadas.
                        qtd_multipla++; // caso sim, soma 1 no indice contador.
                    }
                }
            }
        } // faz para todos os strings

        qtd_multipla = qtd_multipla / 2; // Como ele passa por todos os elementos, ele faz o processo para
                                         // todos, sendo assim, duplica o resultado, precisando que o
                                         // resultado final seja divido pro 2.
        return qtd_multipla;
    }

    public static int ConfereLacos(HashMap<String, LinkedList<Vertice_Vizinho>> valores_inseridos) {
        int qtd_lacos = 0;
        for (String key : valores_inseridos.keySet()) { // Passa por todos os Hashmaps
            for (Vertice_Vizinho elemento : valores_inseridos.get(key)) { // Passa por todos os elementos da lista
                // desta chave
                if (elemento.getValor_vertice().equals(key)) { // se o elemento for igual a chave
                    qtd_lacos++; // soma mais 1
                }

            }
        }
        qtd_lacos = qtd_lacos / 2;
        return qtd_lacos;
    }

    public static void AdicionarAresta(HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos,
            String vertice_entrada, String vertice_saida, float peso) {

        Vertice_Vizinho vertice_vizinho = new Vertice_Vizinho(peso, vertice_entrada);

        Valores_inseridos.get(vertice_saida).add(vertice_vizinho);

        Vertice_Vizinho vertice_vizinho_volta = new Vertice_Vizinho(peso, vertice_saida);

        Valores_inseridos.get(vertice_entrada).add(vertice_vizinho_volta);

    }

    public static void InserirVertice(HashMap<String, LinkedList<Vertice_Vizinho>> valores_inseridos,
            String inserir_vertice) {

        valores_inseridos.put(inserir_vertice, new LinkedList<Vertice_Vizinho>()); // Adiciona como Key do Hashmap e
                                                                                   // cria

    }

    public static boolean compararStrings(String str1, String str2) { // compara se as string são iguais, e retorna em
                                                                      // boolean..
        // Remove os espaços em branco e ordena os caracteres
        String str1Ordenada = ordenarString(str1.replaceAll("\\s", ""));
        String str2Ordenada = ordenarString(str2.replaceAll("\\s", ""));

        // Compara as strings ordenadas
        return str1Ordenada.equals(str2Ordenada);
    }

    public static String ordenarString(String str) { // metodo para ordenar a string
        char[] chars = str.toCharArray(); // transforma a string em um array de caracter
        java.util.Arrays.sort(chars); // metodo para ordenar o array de string
        return new String(chars); // transforma os caracteres ordenados em uma string
    }
}

class DijkstraAlgorithm {

    private HashMap<String, LinkedList<Vertice_Vizinho>> graph; // hashmap das listas
    private HashMap<String, String> predecessors; // armazenar os vertice que ja passou

    // construtor da classe
    public DijkstraAlgorithm(HashMap<String, LinkedList<Vertice_Vizinho>> graph) {
        this.graph = graph;
        this.predecessors = new HashMap<>();
    }

    public HashMap<String, Float> findShortestPaths(String source) {
        HashMap<String, Float> distances = new HashMap<>();
        HashSet<String> visited = new HashSet<>();

        // Inicialização das distâncias com valor infinito, exceto para o vértice de
        // origem que tem distância 0
        for (String vertex : graph.keySet()) {
            distances.put(vertex, Float.MAX_VALUE);
        }
        distances.put(source, 0f);

        while (visited.size() < graph.size()) {
            // Encontra o vértice não visitado com a menor distância
            String current = findMinDistanceVertex(distances, visited);
            // Se não houver mais vértices disponíveis, interrompe o loop
            if (current == null)
                break;
            visited.add(current); // Marca o vértice atual como visitado
            LinkedList<Vertice_Vizinho> neighbors = graph.get(current); // Obtém os vizinhos do vértice atual
            if (neighbors != null) {
                // Para cada vizinho do vértice atual
                for (Vertice_Vizinho neighbor : neighbors) {
                    String neighborVertex = neighbor.getValor_vertice(); // Obtém o vértice vizinho
                    float neighborWeight = neighbor.getValor_peso(); // Obtém o peso da aresta entre o vértice atual e o
                                                                     // vizinho
                    float distanceThroughCurrent = distances.get(current) + neighborWeight; // Calcula a distância até o
                                                                                            // vizinho passando pelo
                                                                                            // vértice atual
                    // Se a nova distância for menor que a distância atual conhecida para o vizinho
                    if (distanceThroughCurrent < distances.get(neighborVertex)) {
                        distances.put(neighborVertex, distanceThroughCurrent); // Atualiza a distância mínima para o
                                                                               // vizinho
                        predecessors.put(neighborVertex, current); // Define o vértice atual como predecessor do vizinho
                    }
                }
            }
        }
        return distances; // Retorna as distâncias mínimas a partir do vértice de origem para todos os
                          // outros vértices

    }

    private String findMinDistanceVertex(HashMap<String, Float> distances, HashSet<String> visited) {
        float minDistance = Float.MAX_VALUE;
        String minVertex = null;
        for (String vertex : distances.keySet()) {
            if (!visited.contains(vertex) && distances.get(vertex) < minDistance) {
                minDistance = distances.get(vertex);
                minVertex = vertex;
            }
        }
        return minVertex;
    }

    public HashMap<String, String> getPredecessors() {
        return predecessors;
    }
}
