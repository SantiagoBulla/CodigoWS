/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author 57305
 */
public class PartesVO {
    private String id, name, effectiveLife;
    
    public PartesVO(){
        
    }

    public PartesVO(String id, String name, String effectiveLife) {
        this.id = id;
        this.name = name;
        this.effectiveLife = effectiveLife;
    }
    
    //setters y getters 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffectiveLife() {
        return effectiveLife;
    }

    public void setEffectiveLife(String effectiveLife) {
        this.effectiveLife = effectiveLife;
    }
    
}
