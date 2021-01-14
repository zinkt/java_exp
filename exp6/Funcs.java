package exp6;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Funcs {
    public static GeometricObj creatGeometricObjByString(String s){
        GeometricObj g = null;
        String[] items = s.split(",");
        String type = items[1];
        switch (type) {
            case "circle":{
                g = new Circle(Integer.parseInt(items[0]), Double.parseDouble(items[2]));
            }
                break;
            case "rectangle":{
                g = new Rectangle(Integer.parseInt(items[0]), Double.parseDouble(items[2]), Double.parseDouble(items[3]));
            } break;
            case "triangle":{
                g = new Triangle(Integer.parseInt(items[0]), Double.parseDouble(items[2]), Double.parseDouble(items[3]), Double.parseDouble(items[4]));
            } break;
        }
        return g;
    }
    public static void sortAndOutput(String dataPath,String outputPath){
        Scanner input = null;
        PrintWriter pw = null;
        try {
            input = new Scanner(new FileInputStream(dataPath));
            pw = new PrintWriter(outputPath);
            ArrayList<GeometricObj> geoList = new ArrayList<GeometricObj>();

            //begin read
            String str;
            while (input.hasNext()) {
                str = input.nextLine();
                geoList.add(creatGeometricObjByString(str));
            }

            Collections.sort(geoList);
            for (GeometricObj geometricObj : geoList) {
                pw.println(geometricObj.toString());
            }


        } catch (IOException e) {
            System.out.println("Reading or Writing Error!");
            e.printStackTrace();
        } finally{
            input.close();
            pw.close();
        }

    }

}
