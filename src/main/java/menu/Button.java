package main.java.menu;

public class Button
{
    private String label;

    private Menu menu;
    private ActionScreen actionScreen;

    public Button(String label)
    {
        this.label = label;
        menu = null;
        actionScreen = null;
    }

    public void setMenu(Menu menu)
    {
        actionScreen = null;
        this.menu = menu;
    }

    public void setActionScreen(ActionScreen actionScreen)
    {
        menu = null;
        this.actionScreen = actionScreen;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public ActionScreen getActionScreen()
    {
        return actionScreen;
    }

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }
}
