import Action.GetCommands;
import inputFiles.InputData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File resultFile = new File("results.out");
        resultFile.delete();
        resultFile.createNewFile();
        ObjectMapper obj = new ObjectMapper();
       InputData input = obj.readValue(new File(args[0]), InputData.class);
      ArrayNode output = obj.createArrayNode();
        ObjectWriter objectWriter = obj.writerWithDefaultPrettyPrinter();
        GetCommands execute=new GetCommands();
        execute.execute(input,output);
        objectWriter.writeValue(resultFile, output);
    }
}