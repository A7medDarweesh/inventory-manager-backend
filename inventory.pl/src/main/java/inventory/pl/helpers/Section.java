/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.helpers;

/**
 *POJO class that holds section information, like id and name
 * @author ahmed_darweeesh
 */
public class Section {
    private int id;
    private String name;
    private String linkName;
    private String[]actions;
    private String[]sectionLinks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getActions() {
        return actions;
    }

    public void setActions(String[] actions) {
        this.actions = actions;
    }

    public String[] getSectionLinks() {
        return sectionLinks;
    }

    public void setSectionLinks(String[] sectionLinks) {
        this.sectionLinks = sectionLinks;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
    
}
