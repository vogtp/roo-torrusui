// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.roo.torrus.server.domain;

import ch.unibas.roo.torrus.server.domain.Settings;

privileged aspect Settings_Roo_JavaBean {
    
    public String Settings.getName() {
        return this.name;
    }
    
    public void Settings.setName(String name) {
        this.name = name;
    }
    
    public String Settings.getCurrentValue() {
        return this.currentValue;
    }
    
    public void Settings.setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }
    
    public String Settings.getDefaultValue() {
        return this.defaultValue;
    }
    
    public void Settings.setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    
}
