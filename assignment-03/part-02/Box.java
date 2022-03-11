public abstract class Box implements Comparable<Box>{
   String   label;
   String   location;
   int      size;

   public String getLabel(){ return this.label;}
   public int    getSize(){ return this.size;}
   public String getLocation(){ return this.location;}

   @Override
   public String toString(){
      return "(" + this.location + "," + this.label + "," + size + ")";
   }

}