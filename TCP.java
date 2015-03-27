
public class TCP {
	int zacata=0;
	int ukoncena=0;
	public int getZacata() {
		return zacata;
	}
	public void setZacata(IndividualList[] komunikacie, int port) {
		for(int i=0;i<65535;i++){
		if(komunikacie[i]!=null)
			for(int j=0;j<komunikacie[i].size()-3;j++){
				if(komunikacie[i].get(j).destinationPORT==port && komunikacie[i].get(j+1).sourcePORT==port && komunikacie[i].get(j+2).destinationPORT==port)
					if(komunikacie[i].get(j).flags.SYN==1 
					&& komunikacie[i].get(j+1).flags.SYN==1 && komunikacie[i].get(j+1).flags.ACK==1
					&& komunikacie[i].get(j+2).flags.ACK==1 ){
						komunikacie[i].zacata=1;
						komunikacie[i].indexZacata=j;
					}
			}
		}
		//klient fin ack, server ack, server fin ack, klient ack. 
		//klient fin, server ack fin, klient ack
		//server fin ack, klient ack, klient rst ack. 
		//server rst.
		
		//Klient fin (ack), server fin ack, klient ack. 
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-2;j++){
					if(komunikacie[i].get(j).destinationPORT==port && komunikacie[i].get(j+1).sourcePORT==port && komunikacie[i].get(j+2).destinationPORT==port)
						if(komunikacie[i].get(j).flags.FIN==1
						&& komunikacie[i].get(j+1).flags.FIN==1 && komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.ACK==1 ){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
						
				}
			}
		}
		
		
		//klient fin (ack), server ack, server fin (ack), klient ack.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-3;j++){
					if(komunikacie[i].get(j).destinationPORT==port && komunikacie[i].get(j+1).sourcePORT==port && komunikacie[i].get(j+2).sourcePORT==port
							&& komunikacie[i].get(j+3).destinationPORT==port);
					if(komunikacie[i].get(j).flags.FIN==1 
						&& komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j).flags.FIN==1
						&& komunikacie[i].get(j+3).flags.ACK==1 ){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
		//server fin ack, klient ack, klient rst ack.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-2;j++){
					if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j+1).destinationPORT==port && komunikacie[i].get(j+2).destinationPORT==port);
					if(komunikacie[i].get(j).flags.FIN==1 && komunikacie[i].get(j).flags.ACK==1
						&& komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.RST==1 && komunikacie[i].get(j+2).flags.ACK==1){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
		//server rst.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size();j++){
					if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j).flags.RST==1){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
	}
	
	public void setZacataD(IndividualList[] komunikacie, int port) {
		for(int i=0;i<65535;i++){
		if(komunikacie[i]!=null)
			for(int j=0;j<komunikacie[i].size()-3;j++){
				if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j+1).destinationPORT==port && komunikacie[i].get(j+2).sourcePORT==port)
					if(komunikacie[i].get(j).flags.SYN==1 
					&& komunikacie[i].get(j+1).flags.SYN==1 && komunikacie[i].get(j+1).flags.ACK==1
					&& komunikacie[i].get(j+2).flags.ACK==1 ){
						komunikacie[i].zacata=1;
						komunikacie[i].indexZacata=j;
					}
			}
		}
		//klient fin ack, server ack, server fin ack, klient ack. 
		//klient fin, server ack fin, klient ack
		//server fin ack, klient ack, klient rst ack. 
		//server rst.
		
		//Klient fin ack, server fin ack, klient ack. 
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-2;j++){
					if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j+1).destinationPORT==port && komunikacie[i].get(j+2).sourcePORT==port)
						if(komunikacie[i].get(j).flags.FIN==1 &&  komunikacie[i].get(j).flags.ACK==1
						&& komunikacie[i].get(j+1).flags.FIN==1 && komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.ACK==1 ){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
						
				}
			}
		}
		
		//klient fin, server ack fin, klient ack ? ? ?
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-2;j++){
					if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j+1).destinationPORT==port && komunikacie[i].get(j+2).sourcePORT==port);
					if(komunikacie[i].get(j).flags.FIN==1
						&& komunikacie[i].get(j+1).flags.FIN==1 && komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.ACK==1 ){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
		//klient fin ack, server ack, server fin ack, klient ack.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-3;j++){
					if(komunikacie[i].get(j).sourcePORT==port && komunikacie[i].get(j+1).destinationPORT==port && komunikacie[i].get(j+2).destinationPORT==port
							&& komunikacie[i].get(j+3).sourcePORT==port);
					if(komunikacie[i].get(j).flags.FIN==1 && komunikacie[i].get(j).flags.ACK==1
						&& komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.ACK==1 && komunikacie[i].get(j).flags.FIN==1
						&& komunikacie[i].get(j+3).flags.ACK==1 ){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
		//server fin ack, klient ack, klient rst ack.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size()-2;j++){
					if(komunikacie[i].get(j).destinationPORT==port && komunikacie[i].get(j+1).sourcePORT==port && komunikacie[i].get(j+2).sourcePORT==port);
					if(komunikacie[i].get(j).flags.FIN==1 && komunikacie[i].get(j).flags.ACK==1
						&& komunikacie[i].get(j+1).flags.ACK==1
						&& komunikacie[i].get(j+2).flags.RST==1 && komunikacie[i].get(j+2).flags.ACK==1){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
		//server rst.
		for(int i=0;i<65535;i++){
			if(komunikacie[i]!=null && komunikacie[i].zacata==1 && komunikacie[i].ukoncena!=1){
				for(int j=komunikacie[i].indexZacata;j<komunikacie[i].size();j++){
					if(komunikacie[i].get(j).destinationPORT==port && komunikacie[i].get(j).flags.RST==1){
							komunikacie[i].ukoncena=1;
							komunikacie[i].indexKonca=j;
						}
				}
			}
		}
	}
	public int getUkoncena() {
		return ukoncena;
	}

}
