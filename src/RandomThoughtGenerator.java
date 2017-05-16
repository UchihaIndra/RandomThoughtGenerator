
package randomthoughtgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class RandomThoughtGenerator {
    ArrayList<String> al=new ArrayList<>();
    Random rnd=new Random();
    String thought;

    public static void main(String[] args) throws FileNotFoundException {
        RandomThoughtGenerator rtg=new RandomThoughtGenerator();  
        MainAppWindow mainAppWindow = new MainAppWindow();
        mainAppWindow.setVisible(true);
        
    }

    public RandomThoughtGenerator() throws FileNotFoundException {
        File fi=new File("/home/fawkes/Documents/NetBeansProjects/RandomThoughtGenerator/src/Quotes");
        secondgenerator();
        Scanner in=new Scanner(fi);      
        try{
            String pattern= "\u005c\u0022";
            while (in.hasNextLine()) {     
                int count=1,last=0,initial=0;
                String temp = "";
                String s=in.nextLine();                
                initial=s.indexOf("\"");
                last=s.lastIndexOf("\"");
                if(last==0){
                    temp=temp+"\n"+s; 
                    s=in.nextLine();
                    while(count!=2){
                        if(s.contains("\"")){
                            temp=temp+"\n"+s;
                            count++;
                        }
                        else{
                            temp=temp+"\n"+s;
                            s=in.nextLine();
                           
                        }
                    }
                    //System.out.println(temp);
                    al.add(temp);
                }
                else{
                    temp=s.substring(initial, last+1);
                    if(s.length()-last!=0){
                        temp=temp+s.substring(last);
                    }
                    //System.out.println(temp);
                    al.add(temp);
                }             
            }
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        int a=rnd.nextInt(al.size()-1);
        thought=al.get(a);
       // System.out.print(al.get(a));
      
    }  

    private void secondgenerator() throws FileNotFoundException {
        File fi=new File("/home/fawkes/Documents/NetBeansProjects/RandomThoughtGenerator/src/Quotes_1");
        Scanner in=new Scanner(fi);
        try{
            while(in.hasNextLine()){
                //System.out.println(in.nextLine());
                al.add(in.nextLine());
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
