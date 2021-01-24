package view.util;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ViewUtils {

    private ViewUtils() {
        // avoid instantiation
    }

    public static JLabel createCenteredLabel() {
        return createCenteredLabel(ViewConstants.EMPTY_STRING);
    }

    public static JLabel createCenteredLabel(final String text) {
        final JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

}
