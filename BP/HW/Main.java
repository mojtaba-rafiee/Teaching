import java.util.*;

public class Main {


    static void Quiz1()
    {
        Scanner reader=new Scanner(System.in);

        int num= reader.nextInt();
        reader.nextLine();

        String [] STR;
        HashMap<String,Double> HM=new HashMap<String, Double>(num);
        int i=1;
        while (i<=num){
            String str=reader.nextLine();
            STR=str.split(" ");
            int n1=Integer.parseInt(STR[1]);
            int n2=Integer.parseInt(STR[2]);
            double len=Math.sqrt(Math.pow(n1,2.0)+Math.pow(n2,2));
            HM.put(STR[0],len);
            i++;
        }

        /*
        (k1,v1),....,(kn,vn)
         */

        double min=10000;
        for (double val: HM.values()) {
            if (min > val)
                min=val;
        }

        for (String point: HM.keySet()) {
            if (HM.get(point)==min)
                System.out.println(point);
        }
    }

    static boolean IsPrime(int num){
        int count=0;
        for (int i=1;i<=Math.sqrt(num);i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count==1 && num !=1){
            return true;
        }
        else{
            return false;
        }
    }

    static void Quiz2(){
        int num=0;
        Scanner reader=new Scanner(System.in);
        num= reader.nextInt();

        ArrayList<Integer> PrimeNum=new ArrayList<Integer>();

        for (int i=1;i<=num;i++)
        {
            if (IsPrime(i)){
                PrimeNum.add(i);
            }
        }

        boolean flag=true;
        /*
            p1 p2 p3 ..... pn-3 pn-2 pn-1 pn
         */

        int i=0,j=0;
        int locp=0,locq=0;
        for (i=PrimeNum.size()-2;i>=0;i--)
        {
            if (flag==true) {
                for (j = i; j <=PrimeNum.size()-1; j++) {
                    if ((PrimeNum.get(i) + PrimeNum.get(j)) == num) {
                        flag = false;
                        locp=i;
                        locq=j;
                        break;
                    }
                }
            }
            else
                break;
        }
        System.out.println(PrimeNum);
        System.out.println("p: "+PrimeNum.get(locp)+" q:"+PrimeNum.get(locq));
    }

    static void Quiz3(){

        Scanner reader=new Scanner(System.in);
        String w= reader.nextLine();
        String s= reader.nextLine();

        ArrayList<Integer> MatchIndex=new ArrayList<>();

        char [] CH=s.toCharArray();

        int k=0;
        for(char ch:CH){
            MatchIndex.add(w.indexOf(ch,k));
            k=w.indexOf(ch,k)+1;
        }

        boolean flag=true;
        for(int i=0;i< MatchIndex.size();i++){
            if (MatchIndex.get(i)==-1){
                System.out.println("NO");
                flag=false;
                break;
            }
        }
        if (flag)
            System.out.println("YES");
    }

    public static void main(String[] args) {

        Quiz1();
        //Quiz2();
        //Quiz3();

    }

}
