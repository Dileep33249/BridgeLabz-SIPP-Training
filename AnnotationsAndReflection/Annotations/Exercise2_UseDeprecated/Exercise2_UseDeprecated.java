class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Using old feature");
    }

    public void newFeature() {
        System.out.println("Using new feature");
    }
}

public class Exercise2_UseDeprecated {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();
        api.newFeature();
    }
}