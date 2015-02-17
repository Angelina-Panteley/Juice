import java.util.Collections;
import java.util.Comparator;

public class JuiceComparator implements Comparator<Juice>{
    public int compare(Juice o1, Juice o2) {
	    	//объекты будут сравниваться таким образом, чтобы пришлось мыть посуду минимальное количесвто раз 
    	    Collections.sort(o1.getList());
    	    Collections.sort(o2.getList());
    	    if(o1.getList().size()==o2.getList().size())
    	    	return 0;
    	    if(o1.getList().size()>o2.getList().size())
    	    	return 1;
    	    else
    	    	return -1;
    	    
	    }
}
