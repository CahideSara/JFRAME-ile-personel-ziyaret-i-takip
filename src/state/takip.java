package state;

public  class takip {

	 private takipDurumu tDurumu;
	 
	  public  takip () {
	 tDurumu=new personelTakip();
	    
	  } 

	  public void giris(String deger1,String deger2) {
	    tDurumu.giris(deger1, deger2);
	  }

	  public void cikis(String deger1,String deger2) {
	   tDurumu.cikis(deger1, deger2);
	  }

	  public void durumDeðiþtir( final takipDurumu tDurumu ) {
	    this.tDurumu = tDurumu;
	  }
	  

}
