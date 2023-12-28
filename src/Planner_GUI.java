import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Planner_GUI extends JPanel {
    String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    JPanel[] day_Panels = new JPanel[7];
    JButton[][] buttons = new JButton[7][24];
    GridBagConstraints grid_constraints = new GridBagConstraints();

    public Planner_GUI() {
        // Layout of entire window
        setLayout(new GridBagLayout());
        grid_constraints.insets = new Insets(5,5,5,5);
        grid_constraints.gridwidth = 1;
        grid_constraints.gridy = 0;
        grid_constraints.gridx = 0;
        grid_constraints.anchor = GridBagConstraints.NORTHWEST;

        // Add Side timings
        JPanel side_times = new JPanel();
        side_times.setLayout(new GridBagLayout());
        side_times.setBorder(new TitledBorder("Times"));

        // Layout within time sidepanel
        GridBagConstraints time_grid = new GridBagConstraints();
        time_grid.insets = new Insets(1,5,5,5);
        time_grid.gridy=0;
        for (int hour=0; hour<24; hour++) {
            side_times.add(new JLabel(String.valueOf(hour+":00")), time_grid);
            time_grid.gridy++;
        }
        add(side_times, grid_constraints);

        // Add "+" Buttons and Panels
        for (int i=0; i<day_Panels.length; i++) {
            grid_constraints.gridx++;

            day_Panels[i] = new JPanel();
            day_Panels[i].setLayout(new GridBagLayout());
            day_Panels[i].setBorder(new TitledBorder(days[i]));

            GridBagConstraints event_grid = new GridBagConstraints();
            event_grid.insets = new Insets(1,1,5,1);
            event_grid.gridy = 0;
            event_grid.gridx = 0;

            for (int hour=0; hour<24; hour++) {
                JButton eventBtn = new JButton("");
                eventBtn.setPreferredSize(new Dimension(20, 16));

                //invisible buttons
                eventBtn.setOpaque(false);
                eventBtn.setContentAreaFilled(false);
                eventBtn.setBorderPainted(false);

                day_Panels[i].add(eventBtn, event_grid);
                buttons[i][hour] = eventBtn;
                event_grid.gridy++;
            }
            day_Panels[i].add(new JButton("+"), event_grid);

            add(day_Panels[i], grid_constraints);
        }
    }
    public static void main(String[] args) {
        Planner_GUI GUI = new Planner_GUI();
        JFrame jf = new JFrame();

        jf.setTitle("Timetable Planner");
        jf.setSize(600, 700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(GUI);
        jf.setVisible(true);
    }
}
