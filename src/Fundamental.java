/**
 * @author 武创
 */
public class Fundamental {
    public static void main(String[] args) {
        Passwordpanel passwordpanel=  new Passwordpanel();
        passwordpanel.setVisible(true);

        Music audioPlayWave = new Music("bgm.wav");
        audioPlayWave.start();
        @SuppressWarnings("unused")
        int musicOpenLab = 1;

    }
}
