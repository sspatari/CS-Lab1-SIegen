import HelloWorld.*;           // The package containing our stubs.
import org.omg.CosNaming.*;  // CORBAClient will use the naming service.
import org.omg.CORBA.*;      // All CORBA applications need these classes.


public class HelloClient
{
  public static void main(String args[])
  {
    try{
      
      // Create and initialize the ORB
      ORB orb = ORB.init(args, null);
      
      // Get the root naming context
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
      
      // Resolve the object reference in naming
      NameComponent nc = new NameComponent("HelloWorld", "");
      NameComponent path[] = {nc};
      HelloFactory fact = HelloFactoryHelper.narrow(ncRef.resolve(path));
	  Hello helloRef = fact.createHello("Klaus");
	  Hello helloRef2 = HelloHelper.narrow(fact.createHello("Uwe"));
      
   	  System.out.println(helloRef.sayHello());
   	  System.out.println(helloRef.sayHello());
   	  System.out.println(helloRef2.sayHello());
  			
    } catch(Exception e) {
        System.out.println("ERROR : " + e);
        e.printStackTrace(System.out);
      }  
  }
}


