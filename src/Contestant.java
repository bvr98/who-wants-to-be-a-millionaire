public class Contestant {

    private String name;
    private boolean isPlaying;

    public Contestant(String name) {
        this.name = name;
        isPlaying = true;
    }

    public String getName() {

        return name;
    }

    public void stillPlaying(boolean Status) {

        isPlaying = Status;
    }

    public boolean isPlaying() {

        return isPlaying;
    }
}

