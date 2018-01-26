public class Team {
    private final String teamName;
    private boolean hasTeamFlag = true;

    Team(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return teamName;
    }

    private boolean hasTeamFlag() {
        return hasTeamFlag;
    }

    private void setHasTeamFlag(boolean hasTeamFlag) {
        this.hasTeamFlag = hasTeamFlag;
    }

    private void waiting() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deadlock(Flag enemyFlag, Flag teamFlag) {
        synchronized(enemyFlag) {
            System.out.println(teamName + " got " + enemyFlag);
            waiting();
            synchronized(teamFlag) {
                System.out.println(teamName + " got " + teamFlag);
            }
        }
    }

    public void livelock(Team enemyTeam, Flag teamFlag) {
        while(enemyTeam.hasTeamFlag()) {
            System.out.println(teamName + " waiting for " + teamFlag);
            waiting();
        }

        System.out.println(teamName + " scored.");
        enemyTeam.setHasTeamFlag(false);
    }
}
