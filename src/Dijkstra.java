import java.util.*;

public class Dijkstra {
    public static List<Vertex> shotestPath(Integer[][] data, int start) {
        List<Vertex> vertexList = new ArrayList<>();
        try {
            int length = data.length;

            for (int i = 0; i < length; i++) {
                vertexList.add(new Vertex(i));
            }
            Queue<Vertex> queue = new LinkedList<>();
            Vertex startVert = vertexList.get(start);
            startVert.setMinDistance(0);
            startVert.setVisited(true);
            queue.add(startVert);
            while (!queue.isEmpty()) {
                Vertex tmp = queue.poll();
                int id = tmp.getId();
                for (int i = 0; i < length; i++) {
                    if (data[id][i] == null) {
                        continue;
                    }
                    Vertex v = vertexList.get(i);
                    if (!v.isVisited()) {
                        queue.add(v);
                        Integer newDistance = tmp.getMinDistance() + data[id][i];
                        if (newDistance < v.getMinDistance()) {
                            v.setMinDistance(newDistance);
                            v.setPrev(tmp);
                        }
                    }
                    tmp.setVisited(true);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vertexList;
    }

    public static List<Vertex> getShortestPath(Integer[][] data, int start, int end) {
        List<Vertex> path = new ArrayList<>();
        try {
            List<Vertex> vertexList = shotestPath(data, start);
            Vertex tmp = vertexList.get(end);
            while (tmp != null) {
                path.add(tmp);
                tmp = tmp.getPrev();
            }
            Collections.reverse(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    public static void main(String[] args) {
        Integer[][] data = new Integer[5][5];
        data[0][1] = data[1][0] = 2;
        data[0][2] = data[2][0] = 3;
        data[2][3] = data[3][2] = 1;
        data[2][4] = data[4][2] = 2;
        data[1][4] = data[4][1] = 1;
        data[1][3] = data[3][1] = 5;
        List<Vertex> list = shotestPath(data, 7);
        Vertex rs = list.get(0);
        System.out.println(rs.getMinDistance());
        System.out.println(getShortestPath(data, 4, 0));
    }
}
