// The package containing our stubs.
import HelloWorld.*;

// HelloServer will use the naming service.
import org.omg.CosNaming.*;

// The package containing special exceptions thrown by the name service.
import org.omg.CosNaming.NamingContextPackage.*;

// All CORBA applications need these classes.
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

public class HelloServer 
{
  public static void main(String args[])
  {
    try {
    
      // Create and initialize the ORB
      ORB orb = ORB.init(args, null);
      
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();
      
      // Create the servant object
      HelloFactoryServant helloRef = new HelloFactoryServant();
      
	  org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloRef);
      HelloFactory href = HelloFactoryHelper.narrow(ref);
      
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
	String name;
	int i=0;
	public HelloServant(String aName)
	{
		name = aName;
	}
    public String sayHello()
    {
		i++;
  		return "The world says HELLO to " + name + " for the " + i + ". time.";
	}
}

class HelloFactoryServant extends HelloFactoryPOA
{  
    public Hello createHello(String name)
    {
		Hello res = null;

        try {
			HelloServant helloRef = new HelloServant(name);
         	org.omg.CORBA.Object ref = _poa().servant_to_reference(helloRef);
            res = HelloHelper.narrow(ref);
        } catch(Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
        return res;
	}
}
