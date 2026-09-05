import java.util.*;
class DFS {
    static void dfs(
        String current,
        Map<String, List<String>> graph,
        Set<String> visited
        ){
            visited.add(current);
            System.out.print(current + " ");
            for(String neighbor : graph.get(current)){
                if(!visited.contains(neighbor)){
                    dfs(neighbor, graph, visited);
                }
            }
        }
        
    public static void main(String[] args) {
        Map <String, List<String>> graph = new HashMap<>();
        
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "E"));
        graph.put("D", Arrays.asList("B", "E"));
        graph.put("E", Arrays.asList("C", "D"));
        
        Set<String> visited = new HashSet<>();
        
        dfs("A", graph, visited);
        
    }
}
