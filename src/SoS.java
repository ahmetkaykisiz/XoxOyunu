import java.util.Scanner;

public class SoS {
//[17:05, 20.12.2019] 🐎🐎 Ahmet Kaykisiz: Kapak  içerik amaç kapsamı veri dogrulugu Kaynak kod fotoğraf
	public static void main(String args[]) {
		Scanner input=new Scanner(System.in);//Değerlerin istenileceği komut.
		char oyunTahtasi[][]={{'*','*','*'},{'*','*','*'},{'*','*','*'}},oyuncular[]     = {'X','O'};
		//oyuncuların tablosu ve oyuncuların tanıtıldığı kısım.
			
		int xSira=0,deger;
		for (int i = 0; i < oyuncular.length; i++) {
				int sira=i+1;
				System.out.println(sira+"oyuncu:"+oyuncular[i]);
				}
				
		  do{
		         oyunGoster(oyunTahtasi);
		         do{
		            System.out.print((xSira + 1)+". Oyuncuda sıra  : ");
		            deger = input.nextInt();
		         }while(deger < 1 || deger > 9 || tabloKontrol(deger, oyunTahtasi) == false);//sayının 1 ile 9 arasında olup olmadığı ve orayadaha önce oynanılmadığının kontrolü sağlanır
		         oyunTahtasi = tabloKontrol(deger,oyunTahtasi,oyuncular[xSira]);
		         xSira = (oyuncular.length) - 1 == xSira ? 0 : xSira + 1;
		      }while(oyunKontrol(oyunTahtasi) && xoxKontrol(oyunTahtasi));
		      oyunGoster(oyunTahtasi);
		      kimYendi(oyunTahtasi);  
		   }
	public static void kimYendi(char [][] x) {
		boolean[] oyuncu= {false,false};
		String [][] hepsi=xoxKontrol_t(x);
		String[] satir=hepsi[0],deger= {"XXX","OOO"},sutun=hepsi[1],capraz=hepsi[2];
		for (int i = 0; i < x.length; i++) {
			oyuncu[0]=(satir[i].contains(deger[0]) || sutun[i].contains(deger[0]) || capraz[i].contains(deger[0])) ?  true  : oyuncu[0];
			oyuncu[1]=(satir[i].contains(deger[1]) || sutun[i].contains(deger[1]) ||capraz[i].contains(deger[1])) ?  true  : oyuncu[1];
		//      
		}
		int kac=oyuncu[0] ? 1 : ( oyuncu[1] ? 2 :0);
		
		System.out.println(kac>0? kac+" kazandı":"oyun berabere");	
	}
	public static String[][] xoxKontrol_t(char[][] x){
		String[] satir = {"","",""},sutun = {"","",""},capraz = {"","",""},temp = new String[2];
		int lenght=x.length;
		for (int i = 0; i < lenght; i++) {
			for (int j = 0; j < x[i].length; j++) {
				temp[0]=Character.toString(x[i][j]);
				satir[j]+=temp[0];
				satir[i]+=temp[0];
				if((i==0 && j==0 || i==2 && j==2))
					capraz[0]+=temp[0];
				else if((i==0 && j==2) || (j==2 && j==0))
					capraz[1]+=temp[0];
				if(i==1&&j==1) {
					capraz[0]+=temp[0];
					capraz[1]+=temp[0];
				}
			}
		}
		String t[][]= {satir,sutun,capraz};
		return t;
	}
	public static boolean xoxKontrol(char[][] x ) {
		boolean kontrol=true;
		String[][] hepsi=xoxKontrol_t(x);
		String[] satir=hepsi[0],deger= {"XXX","OOO"},sutun = hepsi[1],capraz = hepsi[2];
		for (int i = 0; i < x.length; i++) 
			kontrol=(capraz[1].contains(deger[0]) || capraz[1].contains(deger[1]) ||capraz[0].contains(deger[0]) || capraz[0].contains(deger[1]) || satir[i].contains(deger[0]) || satir[i].contains(deger[1]) ||  sutun[i].contains(deger[0]) || sutun[i].contains(deger[1])) ?  false  : kontrol; 
		return kontrol;
		
	}
	 public static boolean oyunKontrol(char[][] x){
			boolean rt=false;
			char t='*';
			for (int j = 0; j < x.length; j++) {
				for (int j2 = 0; j2 < x.length; j2++) 
					if(x[j][j2]==t)
						rt=true;
				}
			return rt;
			
		}
		public static boolean tabloKontrol(int deger,char x[][]){
				char t='*';
				int i,j,degeri=deger,count=x.length;
				if(deger%count==0)
					deger--;
				double id=deger/count;
				i=(int) Math.floor(id);
				if(i>=x.length)
					i=x.length-1;
				j=(degeri-(i*count))-1;
				if(x[i][j]==t)
					return true;
				else
					return false;
			}
			public static char[][] tabloKontrol(int deger,char x[][],char t){
			if(tabloKontrol(deger,x)) {
				int i,j,degeri=deger,count=x.length;
				if(deger%count==0)
					deger--;
				double id=deger/count;
				i=(int) Math.floor(id);
				if(i>=x.length)
					i=x.length-1;
				j=(degeri-(i*count))-1;
				x[i][j]=t;
				return x;
			}	else {
				return x;
			}
		}
		public static void oyunGoster(char x[][]) {
			System.out.println();
			 for(int i = 0 ; i < x.length;i++){
		         for(int j = 0 ; j < x[i].length;j++){  
		            System.out.print((j < x[i].length) ? "\t" : "");   
		            System.out.print(x[i][j]);
		         }
			System.out.println();
		}
		}
		
}
