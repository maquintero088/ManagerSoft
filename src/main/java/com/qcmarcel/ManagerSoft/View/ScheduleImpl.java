// Error reading included file Templates/Classes/Templates/Licenses/license-default.txt
package com.qcmarcel.ManagerSoft.View;

/**
 *
 * @author Márcel
 */
public class ScheduleImpl {

    private String page_string;

    public String init(int Model) {
        switch (Model) {
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            }
        }
        return page_string;
    }

    public String search(String[] values, int Model) {
        System.out.println("-> dentro de search(" + values.length + "," + Model + ")");
        switch (Model) {
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            }
        }
        return page_string;
    }
}

