import java.util.Arrays;

public class MergeSort {

    private MergeSort(){}

    public static<E extends Comparable<E>> void sort(E[] arr){

        sort(arr,0,arr.length-1);

    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r){
        if(l>=r)return;
        int mid=l+(r-l)/2; //防止越界
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static<E extends Comparable<E>> void sort2(E[] arr){

        sort2(arr,0,arr.length-1);

    }

    private static <E extends Comparable<E>> void sort2(E[] arr,int l,int r){
        if(l>=r)return;
        int mid=l+(r-l)/2; //防止越界
        sort2(arr,l,mid);
        sort2(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }

    public static<E extends Comparable<E>> void sort3(E[] arr){

        sort3(arr,0,arr.length-1);

    }

    private static <E extends Comparable<E>> void sort3(E[] arr,int l,int r){
       // if(l>=r)return;
        if(r-l<=15){

        }
        int mid=l+(r-l)/2; //防止越界
        sort3(arr,l,mid);
        sort3(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }

    //自底向上
    public static <E extends Comparable<E>> void sortBU(E[] arr){

        E[] temp=Arrays.copyOf(arr,arr.length);

        int n=arr.length;

        //遍历合并的区间长度
        for(int sz=1;sz<n;sz+=sz){

            //遍历合并的两个区间的起始位置i
            for(int i=0;i+sz<n;i+=sz+sz)
                if(arr[i+sz-1].compareTo(arr[i+sz])>0)
                    merge(arr,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
        }
    }
    private static <E extends Comparable<E>> void merge(E[]arr,int l,int mid,int r){

        E[] temp=Arrays.copyOfRange(arr,l,r+1);

        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){

            if(i>mid){
                arr[k]=temp[j-l];j++;
            }
            else if(j>r){
                arr[k]=temp[i-l];i++;
            }
            else if(temp[i-l].compareTo(temp[j-l])<=0){
                arr[k]=temp[i-l];i++;
            }
            else{
                arr[k]=temp[i-l];i++;
            }
        }

    }
}
