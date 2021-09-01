package classes;

import java.awt.GridLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

public class List extends JPanel{
    
    List()
    {
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);

        this.setLayout(layout);
        this.setBackground(new Color(255, 204, 0));
    }

    public void updateNumbers()
    {
        Component[] listItems = this.getComponents();

        for (int i = 0; i<listItems.length; i++ )
        {
            if (listItems[i] instanceof Task)
            {
                ((Task)listItems[i]).changeIndex(i+1);
            }
        }
        
    }

    public void removeCompletedTasks()
    {
        Component[] listItems = this.getComponents();

        for (Component c : listItems)
        {
            if (c instanceof Task)
            {
                if (((Task)c).getChecked())
                {
                    this.remove(c);
                }
            }
        }
        this.updateNumbers();
        revalidate();
    }
}
