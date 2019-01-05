import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameExtractor {
public static String extractFileName(String dirtyFileName) {
        String date = "";
        StringBuffer sb = new StringBuffer();
        char[] fileNameLetters = dirtyFileName.toCharArray();

        //removing date from filename
        for (char c : fileNameLetters)
        {
            if (c != '_')
            {
                sb.append(c);
            }
            else
            {
                date = sb.toString();
                break;
            }
        }

        String datelessFileName = dirtyFileName.replace(date + "_", "");

        //identifying extra extension
        String secondFileExtension = getCharactersAfterSecondPeriod(datelessFileName); 
        
        //removing extra extension
        String datelessSingleExtensionFileName = datelessFileName.replace("." + secondFileExtension, "");
            
        return datelessSingleExtensionFileName;
        }

 public static String getCharactersAfterSecondPeriod(String fileName)
    {
        String[] split = fileName.split("\\.");        
        return split[2];
    }
 }