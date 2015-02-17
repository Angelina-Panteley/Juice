import java.io.*;
import java.util.*;

public class Juice{
    private Vector<String> list;
    Juice son=null, father=null;
    int hight=0;
    Juice ()
    {
    	list=new Vector<String>();
    }
    Juice (Vector<String> list1)
    {
    	list=new Vector<String>();
    	for(int i=0;i<list1.size();++i)
    	{
    		list.add(list1.get(i));
    	}
    }
    public Vector<String> getList()
    {
    	return list;
    }
    public String toString()
    {
    	return list.toString();
    }
    public int size()
    {
    	return list.size();
    }
 
}
