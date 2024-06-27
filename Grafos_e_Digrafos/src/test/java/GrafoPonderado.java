
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.project.GrafosPonderados;
import com.project.Vertice_Vizinho;

public class GrafoPonderado {

    @Test
    void InserirVertice(){

        HashMap<String, LinkedList<Vertice_Vizinho>> valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(valores_inseridos, "1");
        GrafosPonderados.InserirVertice(valores_inseridos, "2");
        GrafosPonderados.InserirVertice(valores_inseridos, "3");

        assertEquals(valores_inseridos.toString(), "{1=[], 2=[], 3=[]}");
        
    } 

    @Test
    void AdicionarAresta(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(Valores_inseridos, "1");
        GrafosPonderados.InserirVertice(Valores_inseridos, "2");

        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);

        assertEquals(Valores_inseridos.toString(),  "{1=[[Vertice Vizinho = 2 Peso da Aresta = 3.0]], 2=[[Vertice Vizinho = 1 Peso da Aresta = 3.0]]}");
        
    } 

    @Test
    void ConfereLacos(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(Valores_inseridos, "1");

        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "1", 3);

        assertEquals(GrafosPonderados.ConfereLacos(Valores_inseridos),  1);
        
        
    } 

    @Test
    void QtdArestaMultipla(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(Valores_inseridos, "1");
        GrafosPonderados.InserirVertice(Valores_inseridos, "2");
        GrafosPonderados.InserirVertice(Valores_inseridos, "3");

        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "2", "1", 4);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "3", "1", 4);

        assertEquals(GrafosPonderados.QtdArestaMultipla(Valores_inseridos),  2);
        
        
    } 

    @Test
    void GrafoCompleto(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(Valores_inseridos, "1");
        GrafosPonderados.InserirVertice(Valores_inseridos, "2");
        GrafosPonderados.InserirVertice(Valores_inseridos, "3");

        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "3", "2", 3);

        assertEquals(GrafosPonderados.GrafoCompleto(Valores_inseridos), true);
        
        
    } 

    @Test
    void VerificaGrau(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        GrafosPonderados.InserirVertice(Valores_inseridos, "1");
        GrafosPonderados.InserirVertice(Valores_inseridos, "2");
        GrafosPonderados.InserirVertice(Valores_inseridos, "3");

        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        GrafosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);

        assertEquals(GrafosPonderados.VerificaGrau(Valores_inseridos, "1"), 2);
        
        
    } 

    @Test
    void CaminhoMaisCurto(){

        HashMap<String, LinkedList<Vertice_Vizinho>> graph = new HashMap<>();

        GrafosPonderados.InserirVertice(graph, "1");
        GrafosPonderados.InserirVertice(graph, "2");
        GrafosPonderados.InserirVertice(graph, "3");

        GrafosPonderados.AdicionarAresta(graph, "1", "2", 3);
        GrafosPonderados.AdicionarAresta(graph, "2", "3", 5);
        GrafosPonderados.AdicionarAresta(graph, "1", "3", 2);

        assertEquals(GrafosPonderados.CaminhoMaisCurto(graph, "1", "3"), "\nPeso mínimo do caminho do vértice 1 para o vértice 3 é de 2.0 pelo caminho a seguir: 1 -> 3");
        
        
    } 
    
}
