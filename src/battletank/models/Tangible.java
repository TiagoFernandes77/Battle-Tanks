/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battletank.models;

import battletank.utils.Point;

/**
 *
 * @author Tiago
 */
public interface Tangible {
    Point getPosition();
    public int getSize();
    boolean hasImpact(Tangible target);
    void wasStruck(Tangible obj);
    int causeDamage();
}
