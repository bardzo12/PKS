/**
 * 
 * @author Tomáš Baránek
 *
 */
public class IP extends RamecType {
		int options;
		int sourcePORT;
		int destinationPORT;
		FLAG flags=new FLAG();
		IPCKA ipcky = new IPCKA();
		ICMP icmp = new ICMP();
		
		
		public class ICMP{
			int Type;
			int Code;
		}
		
		public class FLAG{
			int ACK=0;
			int FIN=0;
			int RST=0;
			int SYN=0;
			int PSH=0;
			
		}
		
		public FLAG getFlags() {
			return flags;
		}

		public void setFlags(String flagsi) {
			int flag;
			int vysledok;
			flag=Integer.parseInt(flagsi,16);
			vysledok = (flag)& 1;
			if(vysledok>0) flags.FIN=1;
			vysledok = (flag>>1)& 1;
			if(vysledok>0) flags.SYN=1;
			vysledok = (flag>>2)& 1;
			if(vysledok>0) flags.RST=1;
			vysledok = (flag>>3)& 1;
			if(vysledok>0) flags.PSH=1;
			vysledok = (flag>>4)& 1;
			if(vysledok>0) flags.ACK=1;
		}

		public void setSourcePORT(String port){
			sourcePORT = Integer.parseInt(port,16);
		}
		
		public void setDestinationPORT(String port){
			destinationPORT = Integer.parseInt(port,16);
		}
		
		public void setOptions(int parseInt) {
			if(parseInt==5)
			options=0;
			else options=(parseInt-5)*4;
			
		}
		
}
