package main.java.menu;

import java.util.ArrayList;

public class Menu
{
    private String label;

    private ArrayList<Button> buttonList;
    private Menu prevMenu;


    public Menu(String label)
    {
        this.label = label;
        buttonList = new ArrayList<>();
        prevMenu = null;
    }

    public void addButton(Button button)
    {
        for(int i = 0; i < buttonList.size(); i++)
        {
            if(button.getLabel().equals(buttonList.get(i).getLabel()))
                return;
        }

        buttonList.add(button);
    }

    public void setPrevMenu(Menu prevMenu)
    {
        this.prevMenu = prevMenu;
    }

    public Menu getPrevMenu()
    {
        return prevMenu;
    }

    public ArrayList<Button> getButtonlist()
    {
        return buttonList;
    }

    public String getLabel()
    {
        return label;
    }
}
