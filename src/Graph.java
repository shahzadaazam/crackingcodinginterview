import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {

    private HashMap<Integer, Node> nodeLookup = new HashMap<>();

    public Graph() {

        //Creating an example graph
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(4, 5);
        addEdge(4, 6);
        //System.out.println(getNode(2).adjacent.size());
    }

    private static class Node {

        private int data;
        public LinkedList<Node> adjacent = new LinkedList<>();

        public Node(int data) {
            this.data = data;
        }
    }

    public void addEdge(int source, int destination) {
        Node s;
        Node d;
        if (nodeLookup.get(source) != null) {
            s = nodeLookup.get(source);
            //System.out.println("Old");
        } else {
            s = new Node(source);
            nodeLookup.put(source, s);
            //System.out.println("New");
        }

        if (nodeLookup.get(destination) != null) {
            d = nodeLookup.get(destination);
            //System.out.println("Old");
        } else {
            d = new Node(destination);
            nodeLookup.put(destination, d);
            //System.out.println("New");
        }
        s.adjacent.add(d);
    }

    public Node getNode(int data) {
        return nodeLookup.get(data);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {

        //if node is already visited
        if (visited.contains(source.data)) {
            return false;
        }

        //Marking node as visited
        visited.add(source.data);

        //Base case: if source is equal to destination
        if (source == destination) {
            return true;
        }

        //Search through all adjacent nodes
        for (Node node : source.adjacent) {
            if (hasPathDFS(node, destination, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);

        if (s == null || d == null) {
            return false;
        }
        HashSet<Integer> visited = new HashSet<>();
        Queue queue = new Queue();
        queue.push(s);
        while (!queue.isEmpty()) {
            Node current = (Node)queue.pop();
            if (visited.contains(current.data)) {
                continue;
            }
            visited.add(current.data);

            if (current.data == destination) {
                return true;
            }

            for (Node node : current.adjacent) {
                queue.push(node); }

        }
        return false;
    }
}
