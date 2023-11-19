package org.uplift.wealthmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class CreateObject {

    Register r1=new Register();
    public void catchException(Customer c)throws NotEligibleException {
        try {
            r1.checkEligibility(c);
        }
        catch(NotEligibleException e){
            System.out.println(e.getMessage());
        }
    }
   public void createCutomerObject()throws ParseException,NotEligibleException {
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
       Map<String,Double> assets1=new HashMap<>();
       assets1.put("House",500000000000000.0);
       assets1.put("Car",500000.0);
       Map<String,Double> libilities1=new HashMap<>();
       libilities1.put("personal loan",20000.0);
       libilities1.put("home loan",50000.0);

       Customer c1=new Customer("ABC",sdf.parse("11-01-2009"),assets1,libilities1,"345678","4567899999");
       catchException(c1);

       Map<String,Double> assets2=new HashMap<>();
       assets2.put("House",500000.0);
       assets2.put("Car",500000.0);
       Map<String,Double> libilities2=new HashMap<>();
       libilities2.put("personal loan",20000.0);
       libilities2.put("home loan",50000.0);
       Customer c2=new Customer("DEF",sdf.parse("10-02-2003"),assets2,libilities2,"987654","5465768");
       catchException(c2);

       System.out.println("Prime Customer is : "+r1.customerSet);
   }
}
