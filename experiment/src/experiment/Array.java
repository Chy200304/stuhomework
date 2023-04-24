package experiment;
import java.util.Random;
public class Array {
    private int sum,max,min,data[];
    public int nDel;
    private double average;
    public Array(int data[])
    {
        this.data=data;
    }
    public int getSum()
    {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void Calculate()
    {
        min=max=data[0];sum=0;
        for(int i=0;i<data.length;i++)
        {
            if(data[i]<min) min=data[i];
            if(data[i]>max) max=data[i];
            sum+=data[i];
        }
        average=sum*1.0/data.length;
    }
    public void SortUp()
    {
        int i,j,t,len=data.length;
        for(i=0;i<len-1;i++)
        {
            for(j=i+1;j<len;j++)
            {
                if(data[j]<data[i])
                {
                    t=data[i];data[i]=data[j];data[j]=t;
                }
            }
        }
    }
    public void SortDown()
    {
        int i,j,t,len=data.length;
        for(i=0;i<len-1;i++)
        {
            for(j=i+1;j<len;j++)
            {
                if(data[j]>data[i])
                {
                    t=data[i];data[i]=data[j];data[j]=t;
                }
            }
        }
    }

    public void Insert(int x)	
    {   
        int i,j,len=data.length;
        for(i=0;i<len;i++)
        {
            if(data[i]>x)
            {
                for(j=len-2;j>=i;j--)data[j+1]=data[j];
                data[i]=x;break;
            }
        }
    }

    public void Delete(int x)
    {
    	nDel=0;
        int i,j,len=data.length;
        //this.printData();
        for(i=0;i<len;i++){
            if(data[i]==x){
                for(j=i;j<len-1;j++)data[j]=data[j+1];
                nDel++;i--;
            }
        }
        //this.printData();
    }

    public void Search(int x)
    {
        int a,b,k,flag=0,len=data.length;
        a=0;b=len-1;
        while(a<=b)
        {
            k=(a+b)/2;
            if(data[k]==x)
            {
                System.out.println(x+" found at postion "+k);
                flag=1;
                break;
            }
            else if(data[k]<x)a=k+1;
            else b=k-1;
        }
        if(flag==0)System.out.println(x+" not found in the array.");
    }

    public void Reverse()
    {
        int i,t,len=data.length;
        for(i=0;i<len/2;i++)
        {
            t=data[i];data[i]=data[len-1-i];data[len-1-i]=t;
        }
    }

    public void printData()
    {
        for(int i=0;i<data.length;i++)System.out.print(data[i]+"\t");
        System.out.print("\n");
    }

    public void test1()
    {
        int[] datax=new int [12];
        Random ran = new Random();
        ran.setSeed(12345678);
        for(int i=0;i<10;i++)datax[i]=ran.nextInt(50);
        this.setData(datax);
        this.printData();
        this.SortUp();
        this.printData();
        this.Reverse();
        this.printData();
        this.Calculate();
        System.out.println("min="+min+"\tmax="+max+"\tsum="+sum+
                "\taverage="+average+"\n");
        int x=15;
        this.Insert(x);
        this.printData();
    }

    public static int[] generateTestData(int N,int gap)
    {
        int[] datax=new int[N];
        Random ran=new Random();
        ran.setSeed(123456789);
        for(int i=0;i<N-gap;i++)datax[i]=ran.nextInt(50);
        return datax;
    }

    public String arrayToString(int[] arr)
    {
        StringBuilder s= new StringBuilder();
        for(int i=0;i<arr.length;i++) s.append(arr[i]).append(" ");
        return s.toString();
    }
    public String arrayToString(int[] arr,int n)
    {
        StringBuilder s= new StringBuilder();
        for(int i=0;i<n;i++) s.append(arr[i]).append(" ");
        return s.toString();
    }
}
