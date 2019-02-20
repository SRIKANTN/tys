package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class fileDemo
{
	public static void main(String[] args) throws IOException 
	{
		//path exiting 
//		Path path = Paths.get("drivers/chromedriver");
//		System.out.println(Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));
//		//creating file
////		Path path1 = Paths.get("drivers/demo");
//		try
//		{
//			Path newDir = Files.createDirectory(path1);
//		} 
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//copy file
//		Path srcpath = Paths.get("Data/logging.properties");
//		Path destpath = Paths.get("Data/loggingm.properties");
//		Files.copy(srcpath, destpath,StandardCopyOption.REPLACE_EXISTING);
		//move the file 
//		Path srcpath = Paths.get("drivers/chromedriver");
//		Path destpath = Paths.get("data/chromedriver");
//		try {
//			Files.move(srcpath, destpath, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//file delete
//		Path path = Paths.get("Data/loggingm.properties");
//		Files.delete(path);
//		
		//to read all the lines in file
		Path path = Paths.get("Data/dd");
		if(Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}));
		{
			List<String> alllines = Files.readAllLines(path);
			System.out.println(alllines.size());
			for(String lines : alllines)
			{
				System.out.println(lines);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
