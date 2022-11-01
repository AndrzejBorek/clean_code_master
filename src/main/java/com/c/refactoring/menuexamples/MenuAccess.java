package com.c.refactoring.menuexamples;

import java.util.List;

public class MenuAccess {

    public void setAuthorizationsInEachMenus(
            List<MenuItem> menuItemsList, Role[] roles) {
        for (MenuItem menuItem : menuItemsList) {
            if (roles != null) {
                for (Role role : roles) {
                    if (role.getName().equals(menuItem.getReadAccessRole())
                            && !Constants.WRITE.equals(
                            menuItem
                                    .getAccess())) {
                        menuItem.setAccess(Constants.READ);
                        menuItem.setVisible(true);
                    } else if (role.getName().equals(
                            menuItem.getWriteAccessRole())) {
                        menuItem.setAccess(Constants.WRITE);
                        menuItem.setVisible(true);
                    }
                }

            }

        }

    }

}
