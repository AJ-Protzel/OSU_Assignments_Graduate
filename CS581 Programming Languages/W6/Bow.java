public class Bow {
    private String riser, limbs, string, style;
    private int weight;
    private double braceHeight;
    private boolean stabilizer, sight, wristStrap;

    public Bow(String riser, String limbs, String string, String style, int weight, double braceHeight, boolean stabilizer, boolean sight, boolean wristStrap) {
        this.riser = riser;
        this.limbs = limbs;
        this.string = string;
        this.style = style;
        this.weight = weight;
        this.braceHeight = braceHeight;
        this.stabilizer = stabilizer;
        this.sight = sight;
        this.wristStrap = wristStrap;
    }

    public String getRiser() { return riser; }
    public String getLimbs() { return limbs; }
    public String getString() { return string; }
    public String getStyle() { return style; }
    public int getWeight() { return weight; }
    public double getBraceHeight() { return braceHeight; }
    public boolean hasStabilizer() { return stabilizer; }
    public boolean hasSight() { return sight; }
    public boolean hasWristStrap() { return wristStrap; }

    public void setRiser(String riser) { this.riser = riser; }
    public void setLimbs(String limbs) { this.limbs = limbs; }
    public void setString(String string) { this.string = string; }
    public void setStyle(String style) { this.style = style; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setBraceHeight(double braceHeight) { this.braceHeight = braceHeight; }
    public void setStabilizer(boolean stabilizer) { this.stabilizer = stabilizer; }
    public void setSight(boolean sight) { this.sight = sight; }
    public void setWristStrap(boolean wristStrap) { this.wristStrap = wristStrap; }
}
