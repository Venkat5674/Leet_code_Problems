import java.util.*;
class BFS {
    public static void main(String[] args) {
        Map <String, List<String>> graph = new HashMap<>();
        
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D"));
        graph.put("C", Arrays.asList("A", "E"));
        graph.put("D", Arrays.asList("B", "E"));
        graph.put("E", Arrays.asList("C", "D"));
        
        Queue <String> queue = new LinkedList<>();
        
        Set<String> visited = new HashSet<>();
        
        queue.add("A");
        visited.add("A");
        
        while(!queue.isEmpty()){
            String current = queue.poll();
            System.out.print(current + " -> ");
            
            for(String neighbor : graph.get(current)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
}
