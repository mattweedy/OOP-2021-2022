package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star{
    private boolean hab;
    private String displayName;
    private float dist;
    private float xG;
    private float yG;
    private float zG;
    private float absMag;

    @Override
    public String toString() {
        return "Star [absMag=" + absMag + ", displayName=" + displayName + ", dist=" + dist + ", hab=" + hab + ", xG="
                + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    public Star(TableRow tr) {
        this(
            tr.getInt("Hab?") == 1,
            tr.getString("Display Name"),
            tr.getFloat("Distance"),
            tr.getFloat("Xg"),
            tr.getFloat("Yg"),
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }

    public Star(boolean hab, String displayName, float dist, float xG, float yG, float zG, float absMag) {
        this.hab = hab;
        this.displayName = displayName;
        this.dist = dist;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    public boolean isHab() {
        return hab;
    }
    public void setHab(boolean hab) {
        this.hab = hab;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public float getDist() {
        return dist;
    }
    public void setDist(float dist) {
        this.dist = dist;
    }
    public float getxG() {
        return xG;
    }
    public void setxG(float xG) {
        this.xG = xG;
    }
    public float getyG() {
        return yG;
    }
    public void setyG(float yG) {
        this.yG = yG;
    }
    public float getzG() {
        return zG;
    }
    public void setzG(float zG) {
        this.zG = zG;
    }
    public float getAbsMag() {
        return absMag;
    }
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public void render(StarMap pa) {
        float x = PApplet.map(xG, -5, 5, pa.border, pa.width-pa.border);
        float y = PApplet.map(yG, -5, 5, pa.border, pa.height-pa.border);

        pa.stroke(255, 255, 0);
        pa.line(x, y-5, x, y+5);
        pa.line(x-5, y, x+5, y);
        pa.stroke(255, 0, 0);
        pa.noFill();
        pa.circle(x, y, absMag);
        pa.fill(255);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.textSize(15);
        pa.text(displayName, x+20, y);
    }
}
