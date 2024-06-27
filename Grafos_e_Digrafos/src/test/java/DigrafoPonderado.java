
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import com.project.DigrafrosPonderados;
import com.project.Vertice_Vizinho;

public class DigrafoPonderado {

    @Test
    void InserirVertice(){

        HashMap<String, LinkedList<Vertice_Vizinho>> valores_inseridos = new HashMap<>();

       DigrafrosPonderados.InserirVertice(valores_inseridos, "1");
       DigrafrosPonderados.InserirVertice(valores_inseridos, "2");
       DigrafrosPonderados.InserirVertice(valores_inseridos, "3");

        assertEquals(valores_inseridos.toString(), "{1=[], 2=[], 3=[]}");
        
    } 

    @Test
    void AdicionarAresta(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        DigrafrosPonderados.InserirVertice(Valores_inseridos, "1");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "2");

        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "2", "1", 3);

        assertEquals(Valores_inseridos.toString(),  "{1=[[Vertice Vizinho = 2 Peso da Aresta = 3.0]], 2=[]}");
        
    } 

    @Test
    void ConfereLacos(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        DigrafrosPonderados.InserirVertice(Valores_inseridos, "1");

        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "1", 3);

        assertEquals(DigrafrosPonderados.ConfereLacos(Valores_inseridos),  1);
        
        
    } 

    @Test
    void QtdArestaMultipla(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        DigrafrosPonderados.InserirVertice(Valores_inseridos, "1");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "2");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "3");

        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "2", "1", 4);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "3", "1", 4);

        assertEquals(DigrafrosPonderados.QtdArestaMultipla(Valores_inseridos),  2);
        
        
    } 

    @Test
    void GrafoCompleto(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        DigrafrosPonderados.InserirVertice(Valores_inseridos, "1");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "2");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "3");

        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "3", "2", 3);

        assertEquals(DigrafrosPonderados.GrafoCompleto(Valores_inseridos), true);
        
        
    } 

    @Test
    void VerificaGrau(){

        HashMap<String, LinkedList<Vertice_Vizinho>> Valores_inseridos = new HashMap<>();

        DigrafrosPonderados.InserirVertice(Valores_inseridos, "1");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "2");
        DigrafrosPonderados.InserirVertice(Valores_inseridos, "3");

        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "2", 3);
        DigrafrosPonderados.AdicionarAresta(Valores_inseridos, "1", "3", 3);

        assertEquals(DigrafrosPonderados.VerificaGrau(Valores_inseridos, "1"), 2);
        
        
    } 

    @Test
    void CaminhoMaisCurto(){

        HashMap<String, LinkedList<Vertice_Vizinho>> graph = new HashMap<>();

        DigrafrosPonderados.InserirVertice(graph, "1");
        DigrafrosPonderados.InserirVertice(graph, "2");
        DigrafrosPonderados.InserirVertice(graph, "3");

        DigrafrosPonderados.AdicionarAresta(graph, "2", "1", 3);
        DigrafrosPonderados.AdicionarAresta(graph, "3", "2", 5);
        DigrafrosPonderados.AdicionarAresta(graph, "3", "1", 2);

        assertEquals(DigrafrosPonderados.CaminhoMaisCurto(graph, "1", "3"), "\nPeso mínimo do caminho do vértice 1 para o vértice 3 é de 2.0 pelo caminho a seguir: 1 -> 3");
        
    } 
    
}
