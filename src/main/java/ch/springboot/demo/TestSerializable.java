package ch.springboot.demo;

/**
 * Created by Walter Oesch on 09.11.2018.
 */
public class TestSerializable {
    private final long id;
    private final String content;

    public TestSerializable(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
