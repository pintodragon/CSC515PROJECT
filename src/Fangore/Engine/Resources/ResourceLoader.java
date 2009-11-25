/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Fangore.Engine.Resources;

import java.util.LinkedHashMap;
import javax.swing.JApplet;

/**
 *
 * @author justin.chrysler
 */
public interface ResourceLoader<T> {
    public LinkedHashMap<String, T> loadResource(JApplet parent);
}
