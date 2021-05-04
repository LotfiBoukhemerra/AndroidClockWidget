/*
 * CopyRight © 2018, LOTFI BOUKHEMERRA.
 * All rights reserved.
 * Apache License
 * Version 2.0, January 2004
 * http://www.apache.org/licenses/
 */
package pkg;

import javafx.scene.image.Image;

/**
 * @author BOUKHEMERRA Lotfi.
 * @Version 1.0
 * @repository https://github.com/LotfiBoukhemerra
 * @JDK 1.8
 */
public class WidgetVersions {

    private final Image ICON_5 = new Image(getClass().getResourceAsStream("drawable/icon5.png"));
    private final Image BG_IMG_5 = new Image(getClass().getResourceAsStream("drawable/clock_bg_5.png"));
    private final Image HOUR_IMG_5 = new Image(getClass().getResourceAsStream("drawable/clock_hour_hand_5.png"));
    private final Image MINUTE_IMG_5 = new Image(getClass().getResourceAsStream("drawable/clock_minute_hand_5.png"));
    private final Image SECOND_IMG_5 = new Image(getClass().getResourceAsStream("drawable/clock_second_hand_5.png"));

    private final Image ICON_8 = new Image(getClass().getResourceAsStream("drawable/icon8.png"));
    private final Image BG_IMG_8 = new Image(getClass().getResourceAsStream("drawable/clock_bg_8.png"));
    private final Image HOUR_IMG_8 = new Image(getClass().getResourceAsStream("drawable/clock_hour_hand_8.png"));
    private final Image MINUTE_IMG_8 = new Image(getClass().getResourceAsStream("drawable/clock_minute_hand_8.png"));

    private final Image ICON_4 = new Image(getClass().getResourceAsStream("drawable/icon4.png"));
    private final Image BG_IMG_4 = new Image(getClass().getResourceAsStream("drawable/clock_bg_4.png"));
    private final Image HOUR_IMG_4 = new Image(getClass().getResourceAsStream("drawable/clock_hour_hand_4.png"));
    private final Image MINUTE_IMG_4 = new Image(getClass().getResourceAsStream("drawable/clock_minute_hand_4.png"));
    private final Image SECOND_IMG_4 = new Image(getClass().getResourceAsStream("drawable/clock_second_hand_4.png"));

    public final Image HIGHLIGHT_BG = new Image(getClass().getResourceAsStream("drawable/highlight.png"));
    public final Image LIGHT_BG = new Image(getClass().getResourceAsStream("drawable/light.png"));
    public Image[][] src;

    public WidgetVersions() {
        src = new Image[3][5];

        this.src[2][0] = ICON_4;
        this.src[2][1] = BG_IMG_4;
        this.src[2][2] = HOUR_IMG_4;
        this.src[2][3] = MINUTE_IMG_4;
        this.src[2][4] = SECOND_IMG_4;

        this.src[0][0] = ICON_5;// icon 00
        this.src[0][1] = BG_IMG_5;// background 01
        this.src[0][2] = HOUR_IMG_5;// hour 02
        this.src[0][3] = MINUTE_IMG_5;// minute 03
        this.src[0][4] = SECOND_IMG_5;// second 04

        this.src[1][0] = ICON_8;
        this.src[1][1] = BG_IMG_8;
        this.src[1][2] = HOUR_IMG_8;
        this.src[1][3] = MINUTE_IMG_8;
        this.src[1][4] = null;

    }// constractor

}// end WidgetVersions
