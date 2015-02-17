import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Scanner {
	public Vector<Juice> read(String name)
	{
		File file1 = new File( name);
		Vector<Juice> juices=new Vector<Juice>();
		try{
		    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file1 ), "cp1251"));
		    String line = null;
		    while ((line = br.readLine()) != null) {
		    	String[] mas=line.split("\\s");
		    	Juice myJuice=new Juice();
		    	for(int i=0;i<mas.length;i++){
		    		myJuice.getList().add(mas[i]);
		    	}
		    	juices.add(myJuice);
		   }
		}
		catch(Exception e)
		{
			System.out.println("Ошибка");
		}
		//считывает соки, создаёт коллекцию из объектов класса Juice
		return juices;
	}
	public void write(String name, Set<String> list) throws IOException
	{
		//для задания 1,2
		PrintWriter out = new PrintWriter(new FileWriter(name));
		Iterator<String> it=list.iterator();
		while(it.hasNext())
		{
			out.println(it.next());
		}
		out.close();
	}
	public void write(String name, int n) throws IOException
	{
		//для задания 3
		PrintWriter out = new PrintWriter(new FileWriter(name));
		out.println(n);

		out.close();
	}
}
