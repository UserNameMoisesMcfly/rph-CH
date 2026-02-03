package Formularios;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
/**
 * @see https://www.jc-mouse.net
 * @author mouse
 */
public class Miprintable1 implements Printable {
    
    private final Component component;

    public Miprintable1(Component component) {
        this.component = component;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D) graphics;        
        g2d.translate(0,0);
        g2d.scale(0.98,0.98);
        component.paint(g2d);        
        return PAGE_EXISTS;
    }
    
}