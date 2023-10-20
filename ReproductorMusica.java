import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;

public class ReproductorMusica extends Thread {
    private volatile boolean reproduciendo = true;

    public void detenerReproduccion() {
        reproduciendo = false;
    }

    @Override
    public void run() {
        try {
            File archivo = new File("UEFA.wav");
            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(archivo));
            clip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        reproduciendo = false;
                    }
                }
            });

            clip.start();

            while (reproduciendo) {
                Thread.sleep(1000);
            }

            clip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
