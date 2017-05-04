package edu.mum.jsf.bank;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="hello", eager=true)
public class Hello {

    public Hello() {
        System.out.println(getMessage());
    }

    public String getMessage() {
        return "Hello JSF";
    }
}