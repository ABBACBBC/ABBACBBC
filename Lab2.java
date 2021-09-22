import java.io.*;
import java.util.Scanner;
public class Lab2 {
	public static void main(String args[]) {
		Scanner si = new Scanner (System.in);
		System.out.print("Please enter the path of document: ");
		String path=si.nextLine();
		System.out.print("Please enter the level: ");
		int level=si.nextInt();
		si.close();
		System.out.println(keyCounter(path,level));
	}
	
	public static String keyCounter(String path,int level) {
		String res="";
		String txt=readFile(path);
		Scanner sc = new Scanner(txt);
		String stringArr[] = {"auto","double","int","struct","break","long","enum","registe","typedef","char","extern","return","union","const","float","short","unsigned","continue","for","signed","void","default","goto","sizeof","volatile","do","static","while"};
		int numberArr[] = new int [28];
		int switchCount=0,ifCount0=0,ifIfCount0=0,elseCount=0,ifCount=0;
		int caseArr[]= new int [255];
		int total=0;
		boolean begin=false;
		//Counting part
		while(sc.hasNext()) {
			String str=sc.nextLine();
			for(int a=0;a<28;a++) {
				if(str.contains(stringArr[a])) {
					if(str.contains("double")) {//因为double和do会重复计算一次，所以当搜索的关键字是double时，do的出现次数-1，25为词库中do的位置。
						if(a!=25) {
							total++;
							numberArr[a]++;
						 	numberArr[25]--;
						}
					}else {
						total++;
						numberArr[a]++;
					}
					
				}
			}
			if(str.contains("switch")) {
				total++;
				switchCount++;
			}else if(str.contains("case")) {
				total++;
				caseArr[switchCount]++;
			}else if(str.contains("if")) {
				if(!str.contains("else if")) {
					total++;
					ifCount0++;
					ifCount++;
					begin=true;
				}else if(str.contains("else if")) {
					total+=2;
					elseCount++;
					ifCount++;
					if(begin) {
						ifCount0--;
						ifIfCount0++;
						begin=false;
					}
				}
			}else if(str.contains("else")) {
				total++;
				elseCount++;
			}
		}
		sc.close();
		//Output part
		if(level==1) {
			res+="total num: "+total+'\n';
		}else if(level==2) {
			res+="total num: "+total+'\n';
			if(switchCount!=0) {
				res+="switch num: "+switchCount+'\n';
				res+="case num: ";
				for(int b=1;b<=switchCount;b++) {
					res+=caseArr[b]+" ";
				}
				res+='\n';
			}
		}else if(level==3) {
			res+="total num: "+total+'\n';
			if(switchCount!=0) {
				res+="switch num: "+switchCount+'\n';
				res+="case num: ";
				for(int b=1;b<=switchCount;b++) {
					res+=caseArr[b]+" ";
				}
				res+='\n';
			}
			if(ifCount0!=0) {
				res+="if-else num: "+ifCount0+'\n';
			}
		}else if(level==4) {
			res+="total num: "+total+'\n';
			if(switchCount!=0) {
				res+="switch num: "+switchCount+'\n';
				res+="case num: ";
				for(int b=1;b<=switchCount;b++) {
					res+=caseArr[b]+" ";
				}
				res+='\n';
			}
			if(ifCount0!=0) {
				res+="if-else num: "+ifCount0+'\n';
			}
			if(ifIfCount0!=0) {
				res+="if-elseif-else num: "+ifIfCount0+'\n';
			}
		}
		return res;
	}
	
	public static String readFile(String path){
	        File file = new File(path);
	        StringBuilder result = new StringBuilder();
	        try{
	            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
	            String s = null;
	            while((s = br.readLine())!=null){
	                result.append( System.lineSeparator() + s+'\n');
	            }
	            br.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return result.toString();
	 }
}
