/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gabi.richardz
 */

//enum with menu options
public enum MenuOption {
    
    SORT(1, "Sort applicants list"),
    SEARCH(2, "Search for employee"),
    ADD(3, "Add new record"),
    TREE(4, "Create employee hierarchy"),
    EXIT(5, "Exit program");

    private final int code;
    private final String description;

    MenuOption(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

//converts the number entered by the user into an option
    public static MenuOption fromCode(int code) {
        for (MenuOption option : MenuOption.values()) {
            if (option.code == code) {
                return option;
            }
        }
        return null;
    }
}


