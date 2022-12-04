package io.wonjin.nio;

public class ClientInfo {
    private boolean hasId = false;
    private String id;

    public boolean hasId() {
        return hasId;
    }

    private void check() {
        hasId = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        check();
    }
}
