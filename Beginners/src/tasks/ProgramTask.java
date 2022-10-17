package tasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Clock;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import java.util.Properties;

import util.CustomException;
import util.Evaluate;

public class ProgramTask
{
		String word;
	
	public ProgramTask(String term)
	{
		this.word=term;
	}
	
	
	public String toString()
	{
		return this.word;
	}
	
	public BufferedWriter getWriteFile(String fileName,String[] term) throws IOException, CustomException
	{
		Evaluate.verify(term);
		Evaluate.verify(fileName);
		try(FileWriter myFile=new FileWriter(fileName);
			BufferedWriter writer=new BufferedWriter(myFile);)
		{		
		 for(String word:term)
		 {
			 
			writer.write(word);
			writer.newLine();
		 }
		 writer.flush();
		 return writer;
		}
	}
	
	public  Properties getProperty()
	{
		Properties prop= new Properties();
		return prop;
	}
	
	public void getFileProperty(String fileName,Properties prop) throws IOException, CustomException
	{
		Evaluate.verify(prop);
		try(FileWriter myFile=new FileWriter(fileName);)
		{
		  prop.store(myFile, "Properties");//swami resolved
		}
	}
	
	public Properties getNewProperty(String myFile) throws FileNotFoundException, IOException
	{
		try(FileReader myRead=new FileReader(myFile);)
		{
			Properties newProp=getProperty();
			newProp.load(myRead);
			return newProp;
		}
	}
	
	public boolean createDirectory(String directoryName) throws FileNotFoundException, IOException
	{
		File myFile=new File(directoryName);
		boolean check= myFile.mkdir();	
		return check;
	}
	
	public LocalDateTime getTime()
	{
		LocalDateTime time=LocalDateTime.now();
		return time;
	}
	
	public LocalDateTime getZoneTime(ZoneId id)
	{
		LocalDateTime time=LocalDateTime.now(id);
		return time;
	}
	public LocalDateTime  getZoneID(String place)throws CustomException,ZoneRulesException,DateTimeException

	{
		Evaluate.verify(place);
		ZoneId zone = ZoneId.of(place);
		LocalDateTime time=getZoneTime(zone);
		return time;
	}
	public long getMilliSeconds()
	{
		//long seconds=System.currentTimeMillis();//swami
		long seconds=Clock.systemDefaultZone().millis();
		return seconds;
	}
	public Month getMonthName()
	{
		LocalDateTime time=getTime();
		Month name=time.getMonth();
		return name;
	}
	public DayOfWeek getWeek()
	{
		LocalDateTime time=getTime();
		DayOfWeek name=time.getDayOfWeek();
		return name;
	}
	public int getYear()
	{
		LocalDateTime time=getTime();
		int year=time.getYear();
		return year;
	}
	public Month getZonedMonth(String place)throws CustomException,ZoneRulesException,DateTimeException

	{
		Evaluate.verify(place);
		LocalDateTime time=getZoneID(place);
		Month name=time.getMonth();
		return name;
	}
	public DayOfWeek getZonedWeek(String place)throws CustomException,ZoneRulesException,DateTimeException

	{
		Evaluate.verify(place);
		LocalDateTime time=getZoneID(place);
		DayOfWeek name=time.getDayOfWeek();
		return name;
	}
	public int getZonedYear(String place)throws CustomException,ZoneRulesException,DateTimeException
	{
		Evaluate.verify(place);
		LocalDateTime time=getZoneID(place);
		int year=time.getYear();
		return year;
	}
	
		
	
}
