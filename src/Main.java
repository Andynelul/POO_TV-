import Action.GetCommands;
import inputFiles.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
 class contor {
    static int contor;
}
public class Main {
    public static void main(String[] args) throws IOException {
        contor.contor ++;
      // File resultFile = new File(contor.contor+"results.json");
      File resultFile = new File("results.out");
        resultFile.delete();
        resultFile.createNewFile();
        ObjectMapper obj = new ObjectMapper();
//       InputData input = obj.readValue(new File("E:\\POO\\POO-TV-TRY2\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_8.json"), InputData.class);
       InputData input = obj.readValue(new File(args[0]), InputData.class);
      ArrayNode output = obj.createArrayNode();
        ObjectWriter objectWriter = obj.writerWithDefaultPrettyPrinter();
        GetCommands execute=new GetCommands();
        execute.execute(input,output);
        objectWriter.writeValue(resultFile, output);
    }
}
  //  InputData input = obj.readValue(new File("E:\\POO\\POO-TV-TRY2\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_6.json"), InputData.class);
//        InputData input = obj.readValue(new File(args[0]), InputData.class);