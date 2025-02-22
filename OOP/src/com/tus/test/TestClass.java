package com.tus.test;

public class TestClass {

	public static void main(String[] args) {
		System.out.println(TestClass.transformNumber(7));
	}

public static int transformNumber(int n){
   int radix = 2;
   int output = 0;
   output += radix*n;
   
   radix = output/radix;

   
   if(output<14){
       return output;
   }
   else if (output > 14){
       output = output*radix/2;
       return output;
   }
   else {
       return output/2;
   }
}

}
