package homeworks.hw3;import java.util.Arrays;public class MergeSort {    public static void main(String[] args) {        int[] arr = {5, 1, 6, 2, 3, 4, -1, -2};        System.out.println(Arrays.toString(mergeSort(arr)));    }    // public static int[] mergeSort(int[] a)    public static int[] mergeSort(int[] a) {        mergeSort1(a);        int[] res = new int[a.length];        for (int i = 0; i < a.length; i++) {            res[i] = a[i];        }        return res;    }    private static void mergeSort1(int[] arr) {        int n = arr.length;        if(n == 1) return;        int mid = n / 2;        int[] l = new int[mid];        int[] r = new int[n - mid];        for (int i = 0; i < mid; i++) {            l[i] = arr[i];        }        for (int i = mid; i < n; i++) {            r[i- mid] = arr[i];        }        mergeSort1(l);        mergeSort1(r);        merge(arr, l, r);    }    private static void merge(int[] arr, int[] l, int[] r) {        int left = l.length;        int right = r.length;        int i = 0;        int j = 0;        int idx = 0;        while (i < left && j < right) {            if (l[i] < r[j]) {                arr[idx] = l[i];                i++;                idx++;            } else {                arr[idx] = r[j];                j++;                idx++;            }        }        for (int ll = i; ll < left; ll++) {            arr[idx++] = l[ll];        }        for (int rr = j; rr < right; rr++){            arr[idx++] = r[rr];        }    }}