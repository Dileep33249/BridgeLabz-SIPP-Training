import java.lang.reflect.*;
import java.util.*;

@interface Inject {}

class Service {
    public void execute() {
        System.out.println("Service executing...");
    }
}

class Client {
    @Inject
    public Service service;
}

class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, new Service());
            }
        }
    }
}

public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        DIContainer.injectDependencies(client);
        client.service.execute();
    }
}