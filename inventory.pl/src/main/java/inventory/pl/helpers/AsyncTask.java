/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventory.pl.helpers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 *
 * @author ahmed_darweeesh
 */
public class AsyncTask extends FutureTask<String> implements PropertyChangeListener {

    public AsyncTask(Callable<String> callable) {
        super(callable);
        
    }

    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
