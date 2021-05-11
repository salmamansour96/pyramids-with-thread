package pyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PyramidDAO extends Thread {
	public final List<Pyramid> p_list=new ArrayList<Pyramid>();
	
	public void readcsv(String path) throws FileNotFoundException  {
		BufferedReader br=new BufferedReader(new FileReader(path));
		String line="";
		
		try {
			 line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(line!=null)
			System.out.println(line);
		do
		{   try {
			line=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(line!=null)
			{
				
			//System.out.println("Line After reading"+"  "+line);
			String [] parts=line.split(",");
			if (parts[7].isEmpty()) {
				
				p_list.add(new Pyramid(parts[0],parts[2],parts[4],Double.parseDouble("20")));
				
			}
			else
				
			  {
				p_list.add(new Pyramid(parts[0],parts[2],parts[4],Double.parseDouble(parts[7])));
				
			  }
		}}while(line!=null);
		for(int i=0;i<p_list.size();i++)
		{
			
			System.out.println("#"+(i+1)+" "+p_list.get(i).getPharaoh()+","+p_list.get(i).getModern_name()+","+p_list.get(i).getSite()+","+p_list.get(i).getHeight());
		}
	   	
	}
	public void run()
	{
		try {
			readcsv("E:\\linux course\\java\\pyramids.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Pyramid  createpyramid(String [] data)
	
	{
		return new Pyramid(data[0],data[2],data[4],Double.parseDouble(data[7]));
		
	}
    
}
