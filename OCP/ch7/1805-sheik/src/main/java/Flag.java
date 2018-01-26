public class Flag {
    private final String flagName;

    Flag(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString() {
        return flagName;
    }
}
