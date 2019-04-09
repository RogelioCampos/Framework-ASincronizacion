package thismother;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.geom.*;

public class Estado {
    private Rectangle2D forma;
    private Color color;

    public Estado(Rectangle2D forma, Color color) {
        this.forma = forma;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setForma(Rectangle2D forma) {
        this.forma = forma;
    }

    public Color getColor() {
        return color;
    }

    public Rectangle2D getForma() {
        return forma;
    }
}
