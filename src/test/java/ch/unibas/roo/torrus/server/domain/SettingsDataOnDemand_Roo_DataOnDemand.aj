// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package ch.unibas.roo.torrus.server.domain;

import ch.unibas.roo.torrus.server.domain.Settings;
import ch.unibas.roo.torrus.server.domain.SettingsDataOnDemand;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Component;

privileged aspect SettingsDataOnDemand_Roo_DataOnDemand {
    
    declare @type: SettingsDataOnDemand: @Component;
    
    private Random SettingsDataOnDemand.rnd = new SecureRandom();
    
    private List<Settings> SettingsDataOnDemand.data;
    
    public Settings SettingsDataOnDemand.getNewTransientSettings(int index) {
        Settings obj = new Settings();
        setCurrentValue(obj, index);
        setDefaultValue(obj, index);
        setName(obj, index);
        return obj;
    }
    
    public void SettingsDataOnDemand.setCurrentValue(Settings obj, int index) {
        String currentValue = "currentValue_" + index;
        obj.setCurrentValue(currentValue);
    }
    
    public void SettingsDataOnDemand.setDefaultValue(Settings obj, int index) {
        String defaultValue = "defaultValue_" + index;
        obj.setDefaultValue(defaultValue);
    }
    
    public void SettingsDataOnDemand.setName(Settings obj, int index) {
        String name = "name_" + index;
        obj.setName(name);
    }
    
    public Settings SettingsDataOnDemand.getSpecificSettings(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Settings obj = data.get(index);
        Long id = obj.getId();
        return Settings.findSettings(id);
    }
    
    public Settings SettingsDataOnDemand.getRandomSettings() {
        init();
        Settings obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return Settings.findSettings(id);
    }
    
    public boolean SettingsDataOnDemand.modifySettings(Settings obj) {
        return false;
    }
    
    public void SettingsDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = Settings.findSettingsEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Settings' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Settings>();
        for (int i = 0; i < 10; i++) {
            Settings obj = getNewTransientSettings(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}