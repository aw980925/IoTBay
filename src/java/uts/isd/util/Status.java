/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.util;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author heeseong
 */
public class Status {
   private ArrayList exceptions;
   public Status() {exceptions=new ArrayList();}
   public boolean isSuccessful() {return (exceptions.isEmpty());}
   public void addException(Exception ex) {exceptions.add(ex);}
   public Iterator getExceptions() {return exceptions.iterator();}
}
