
package publics;

import java.awt.Component;

import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.TableCellRenderer;

/**
 * The renderer for the row headers.
 *
 * @author Ainam Jean Paul
 * Date of creation 11 Nov 2013
 * Date of modification : 05 - June - 2014
 */
public class RowHeadersRenderer extends JToggleButton implements TableCellRenderer {

    public RowHeadersRenderer() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setBorderPainted(true);
        setBorder(null);
        setMargin(new Insets(0, 0, 0, 0));
        setContentAreaFilled(false);
        setOpaque(true);
        setSize(3, 3);
        //setPreferredSize(new Dimension(5, 3));
        
        //setBackground(new Color(0xEEE));
        setText("" + value);
        return this;
    }
    
}
