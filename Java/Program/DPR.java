package Program;
public class DPR
{
    private int id;
    private String name;
    private String bidang;
    private String partai;

    public DPR(){
        this.id = 0;
        this.name = "";
        this.bidang = "";
        this.partai = "";
    }

    public DPR(int id, String name, String bidang, String partai){
        this.id = id;
        this.name = name;
        this.bidang = bidang;
        this.partai = partai;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBidang(){
        return this.bidang;
    }

    public void setBidang(String bidang){
        this.bidang = bidang;
    }
    public String getPartai(){
        return this.partai;
    }

    public void setPartai(String partai){
        this.partai = partai;
    }
}