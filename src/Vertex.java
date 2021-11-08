public class Vertex {
    private int id;
    private boolean isVisited;
    private Integer minDistance;
    private Vertex prev;

    public Vertex(int id) {
        this.id = id;
        this.isVisited = false;
        this.minDistance = Integer.MAX_VALUE;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Integer getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(Integer minDistance) {
        this.minDistance = minDistance;
    }

    public Vertex getPrev() {
        return prev;
    }

    public void setPrev(Vertex prev) {
        this.prev = prev;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" + this.getId();
    }
}
