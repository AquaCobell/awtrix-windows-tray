package utils;
public class Timer {
    private long startTime;     // Zeitpunkt, zu dem der Timer gestartet wurde
    private long pauseTime;     // Zeitpunkt, zu dem der Timer pausiert wurde
    private long duration;      // Gesamtdauer des Timers
    private boolean isRunning;  // Gibt an, ob der Timer gerade läuft

    public Timer() {
        isRunning = false;
    }

    // Methode zum Starten des Timers mit einer gegebenen Dauer in Millisekunden
    public void start(long duration) {
        if (!isRunning) {
            this.duration = duration;
            startTime = System.currentTimeMillis();
            isRunning = true;
        }
    }

    // Methode zum Stoppen des Timers
    public void stop() {
        if (isRunning) {
            isRunning = false;
            pauseTime = System.currentTimeMillis();
        }
    }

    // Methode zum Pausieren des Timers
    public void pause() {
        if (isRunning) {
            isRunning = false;
            pauseTime = System.currentTimeMillis();
        }
    }

    // Methode zum Fortsetzen des Timers nach dem Pausieren
    public void resume() {
        if (!isRunning) {
            long pausedDuration = System.currentTimeMillis() - pauseTime;
            startTime += pausedDuration;
            isRunning = true;
        }
    }

    // Methode zur Berechnung des aktuellen Fortschritts in Prozent (0-100)
    public double getProgress() {
        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            return Math.min(100.0, (double) elapsedTime / (double) duration * 100.0);
        } else {
            return 0.0;
        }
    }

    // Methode zur Überprüfung, ob der Timer abgelaufen ist
    public boolean isFinished() {
        if (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            return elapsedTime >= duration;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();

        // Timer mit einer Dauer von 5000 Millisekunden (5 Sekunden) starten
        timer.start(5000);

        while (!timer.isFinished()) {
            System.out.println("Fortschritt: " + timer.getProgress() + "%");
            try {
                Thread.sleep(1000); // Timer alle 1 Sekunde überprüfen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Timer ist abgelaufen!");
    }
}
