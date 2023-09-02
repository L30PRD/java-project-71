package hexlet.code;

public class Difference {
    private final String status;
    private final String name;
    private final Object object1;
    private final Object object2;

    public Difference(String status, String name, Object object1, Object object2) {
        this.status = status;
        this.name = name;
        this.object1 = object1;
        this.object2 = object2;
    }

    public Difference(String status, String name, Object object1) {
        this.status = status;
        this.name = name;
        this.object1 = object1;
        this.object2 = null;
    }

    public String getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Object getObject1() {
        return object1;
    }

    public Object getObject2() {
        return object2;
    }

}
