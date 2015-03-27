/**
 * Trieda pre jednolivé rámce
 * @author Tomáš Baránek
 *
 */
public class RamecType {
	public int number;
	public int driverSize;
	public int Size;
	public String SourceMac;
	public String DestinationMac;
	public int typ_ramca;
	public int typ802_3;
	public String data;

	public void setTyp_ramca(String typ){
		typ_ramca = Integer.parseInt(typ,16);
	}
	public int getTyp_ramca(){
		return typ_ramca;
	}
}
