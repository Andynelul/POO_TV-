import Action.GetCommands;
import Input.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
 class count{
    static int count=0;
}
public class Main {
    public static void main(String[] args) throws IOException {
 //       args =new String[10];
   // args[0]="checker/resources/in/basic_2.json";
//        ObjectMapper obj = new ObjectMapper();
//        File directory = new File("checker/resources/in/");
//        for ( File file : Objects.requireNonNull(directory.listFiles()) ) {
//            InputData input = obj.readValue(new File(directory.getPath() +"/basic_6.json" /*file.getName()*/), InputData.class);
//            ArrayNode output = obj.createArrayNode();
//            GetCommands execute=new GetCommands();
//            execute.action(input,output);
//            ObjectWriter objectWriter = obj.writerWithDefaultPrettyPrinter();
//            File out = new File("results.out");
//            boolean iscreated = out.createNewFile();
//            if ( iscreated )
//                objectWriter.writeValue(new File("results.out"), output);
//            else
//                System.out.println("nu e creat bos");
//            System.out.println(iscreated);
      //  for(int i=0;i< Arrays.stream(args).count();i++)
      //  {
      //  Path path = Paths.get(CheckerConstants.RESULT_PATH);

count.count++;
            File resultFile = new File(count.count +" results.out");
            resultFile.delete();
            resultFile.createNewFile();
                       ObjectMapper obj = new ObjectMapper();
                InputData input = obj.readValue(new File(args[0]), InputData.class);
                ArrayNode output = obj.createArrayNode();
                ObjectWriter objectWriter = obj.writerWithDefaultPrettyPrinter();
            GetCommands execute=new GetCommands();
                execute.action(input,output);
                objectWriter.writeValue(resultFile, output);
         //   }
        }
    }


