public class Flag {
    private final String flagName;

    public Flag(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString() {
        return flagName;
    }
}
