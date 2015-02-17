import java.io.*;
import java.util.*;
public class Machine {
	
	public static LinkedHashSet<String> listOfComponents(Vector<Juice> list)
	{
		LinkedHashSet<String> newList=new LinkedHashSet<String>();
		//возвращается список различных компонент 
    	Iterator<Juice> it=list.iterator();
    	for(int i=0;i<list.size();++i)
    	{
    		for(int j=0;j<list.get(i).getList().size();++j)
    		        newList.add(list.get(i).getList().get(j));
    	}
		return newList;
	}
	public static TreeSet<String> sortedListOfComponents(Vector<Juice> list)
	{
		TreeSet<String> newList=new TreeSet<String>();
		//возвращается отсортированный список различных компонент
		Iterator<Juice> it=list.iterator();
    	for(int i=0;i<list.size();++i)
    	{
    		for(int j=0;j<list.get(i).getList().size();++j)
    		        newList.add(list.get(i).getList().get(j));
    	}
		return newList;
	}
	public static int process(Vector<Juice> list)
	{
		//int n=list.size();
		
		int n=0;
		Vector<Integer> counts=new Vector<Integer>();
		Collections.sort(list,new JuiceComparator());//сортируем по количеству компанент
		for(int i=0;i<list.size();++i)//убираем одинаковые наборы
		{
			
			for(int j=i+1;j<list.size();++j)
			{
				boolean flag=true;
				if(list.get(i).getList().size()==list.get(j).getList().size()&&i!=j)
				for(int h=0;h<list.get(i).getList().size();++h){
					
						if(list.get(i).getList().get(h).equals(list.get(j).getList().get(h)))
						{}
							
						else
						{
							flag=false;
							break;
						
						}
					
				}
				else
					flag=false;
				if(flag){
					list.remove(j);
					--j;
				}
			}
		}
		System.out.println(list);
		int p=0;
		while(list.get(p).getList().size()==list.get(0).getList().size()&&p<list.size()-1)
		{
			++p;
		}
		int count=0;
		System.out.println(p);
		Vector<Juice> copylist=new Vector<Juice>();
		for(int i=0;i<list.size();++i)
		{
			copylist.add(list.get(i));
		}
		for(int w=0;w<p;++w){//пробегаемся по всем "маленьким" наборам фруктов, чтобы составить наименьшее количество цепочек
		for(int i=0;i<list.size();++i)
		{
			for(int j=i+1; j<list.size();++j){
				n=0;
				for(int k=0;k<list.get(i).getList().size();++k)
					for(int l=0;l<list.get(j).getList().size();++l)
						if(list.get(i).getList().get(k).equals(list.get(j).getList().get(l)))
							++n;
				if(n==list.get(i).getList().size()){
					if(list.get(j).son==null&&list.get(i).father==null||list.get(j).son!=null&&list.get(j).son.hight<=list.get(i).hight){//&&list.get(i).father.hight<list.get(i).hight){
					    list.get(j).son=list.get(i);
					    list.get(i).father=list.get(j);
					    list.get(j).hight++;
					}
					
				}
				
			}		
				
		}
		
		Vector<Juice> lj=new Vector<Juice>();
	    count=0;
		while(list.size()>0)
		{
			int y=0;
			while(true){
				lj.add(list.get(y));
				int o=list.indexOf(list.get(y).father);
				list.remove(y);
				o--;
				if(o<0)
				{
					++count;
					break;
				}
				y=o;
			}
		
		}
		
		System.out.println(lj+" "+count);
		Juice j=copylist.get(0);
		for(int h=0;h<p-1;++h)
		{
			copylist.set(h, copylist.get(h+1));
		}
		copylist.set(p-1, j);
		System.out.println("copylist "+copylist);
		for(int r=0;r<copylist.size();++r)
		{
			list.add(copylist.get(r));
			list.get(r).father=null;
			list.get(r).son=null;
			list.get(r).hight=0;
		}
		counts.add(count);
		}
		System.out.println(counts);
		int min=copylist.size();
		for(int i=0;i<counts.size();++i)
			if(min>counts.get(i))
				min=counts.get(i);
		System.out.println(min);
		return min;
	}
    public static void main(String[] args)
    {
    	String nameIn="juice.in.txt";
    	String nameOut1="juice1.out.txt";
    	String nameOut2="juice2.out.txt";
    	String nameOut3="juice3.out.txt";
    	Scanner sc=new Scanner();
    	Vector<Juice> juices=new Vector<Juice>();
    	Iterator<Juice> it=sc.read(nameIn).iterator();
    	while(it.hasNext())
    	{
             juices.add(it.next());
        }
    	for(int i=0;i<juices.size();++i)
    	{
    		System.out.println(juices.get(i).getList().toString());
    	}
    	try{
    	    sc.write(nameOut1, listOfComponents(juices));
    	    sc.write(nameOut2, sortedListOfComponents(juices));
    	    int n=process(juices);
    	    sc.write(nameOut3, n);
    	}
    	catch(IOException e)
    	{
    		System.err.println("Ошибка записи");
    	}
    	
    }
}
