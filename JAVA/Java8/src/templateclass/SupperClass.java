package templateclass;

import java.util.List;

public class SupperClass<T> {
    List<T> user;

    public List<T> getUser() {
        return user;
    }

    public void setUser(List<T> user) {
        this.user = user;
    }
}
