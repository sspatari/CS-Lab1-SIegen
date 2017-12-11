// The package containing our stubs.
import HelloWorld.*;

// HelloServer will use the naming service.
import org.omg.CosNaming.*;

// The package containing special exceptions thrown by the name service.
import org.omg.CosNaming.NamingContextPackage.*;

// All CORBA applications need these classes.
import org.omg.CORBA.*;
import org.omg.PortableServer.*;

public class HelloServer 
{
  public static void main(String args[])
  {
    try{
    
      // Create and initialize the ORB
      ORB orb = ORB.init(args, null);
     
      // Create the servant object
      HelloServant helloRef = new HelloServant();
     
      POA rootpoa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
      
	  org.omg.CORBA.Object ref= rootpoa.servant_to_reference(helloRef);
      Hello href=HelloHelper.narrow(ref);
      
      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
         
      NameComponent path[] = ncRef.to_name("HelloWorld");
    
      ncRef.rebind(path, href);

	  System.out.println("HelloServer is running...");
	  
	  orb.run();
      
    } catch(Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }  
  }
}



class HelloServant extends HelloPOA
{  
	int i=0;
    public String sayHello(String Name)
    {
		i++;
  		return "The world says HELLO to " + Name + " for the " + i + ". time.";
	}
}
