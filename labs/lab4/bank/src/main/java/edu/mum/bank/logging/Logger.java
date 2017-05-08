package edu.mum.bank.logging;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Logger implements ILogger {

    public void log(String logstring) {
        java.util.logging.Logger.getLogger("BankLogger").info(logstring);
    }

}
