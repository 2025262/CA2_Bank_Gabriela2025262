/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author gabi.richardz
 */

//class for bank managers
public class Manager {

    private String managerName;
    private String managerType; // here we can add a typo of manager
    private int managerId;

    public Manager(String managerName, String managerType, int managerId) {
        this.managerName = managerName;
        this.managerType = managerType;
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerType() {
        return managerType;
    }

    public void setManagerType(String managerType) {
        this.managerType = managerType;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return managerType + ": " + managerName + " (ID: " + managerId + ")";
    }

}
