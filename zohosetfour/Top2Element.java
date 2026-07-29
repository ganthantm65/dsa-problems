package zohosetfour;

import java.util.Arrays;

class Pair{
    int i;
    int freq;

    public Pair(int i,int freq){
        this.i=i;
        this.freq=freq;
    }
}

public class Top2Element {
    static int[] findTop2(int[] arr){
        int count=1;
        Pair[] freqPairs=new Pair[arr.length];
        int k=0;
        for (int r = 1; r < arr.length; r++) {
            if(arr[r]!=arr[r-1]){
                freqPairs[k++]=new Pair(arr[r-1],count);
                count=1;
            }else{
                count++;
            }
        }
        freqPairs[k++] = new Pair(arr[arr.length - 1], count);
        freqPairs=Arrays.copyOf(freqPairs, k);

        for (int i = freqPairs.length/2-1; i >=0; i--) {
            heapify(freqPairs, i,k);
        }

        int[] res=new int[2];
        int size = k;

        res[0] = extractMax(freqPairs, size--).i;
        res[1] = extractMax(freqPairs, size--).i;

        return res;
    }
    static int[] anotherMethod(int[] arr){
        int first=0,firstFreq=-1;
        int second=0,secFreq=-1;
        int n=findMax(arr);
        int[] frequencies=new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            frequencies[arr[i]]++;
            if(frequencies[arr[i]]>firstFreq){
                secFreq=firstFreq;
                second=first;

                firstFreq=frequencies[arr[i]];
                first=arr[i];
            }else if(frequencies[arr[i]]>secFreq){
                secFreq=frequencies[arr[i]];
                second=arr[i];
            }
        }
        return new int[]{first,second};
    }

    static int findMax(int[] arr){
        int max=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    static Pair extractMax(Pair[] heap, int size) {

        Pair max = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = max;

        heapify(heap,0, size - 1);

        return max;
    }
    static void heapify(Pair[] heap, int i, int size) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left].freq > heap[largest].freq)
            largest = left;

        if (right < size && heap[right].freq > heap[largest].freq)
            largest = right;

        if (largest != i) {
            Pair temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            heapify(heap, largest, size);
        }
    }
    
    public static void main(String[] args) {
        int[] arr={1,1,1,1,2,2,2,3,3,4,5,5,5,5,5};
        int[] res=anotherMethod(arr);
        System.out.print(Arrays.toString(res));
    }
}
