/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author:
 *
 *************************************************************************/

import java.awt.Color;

import javax.naming.directory.DirContext;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {

        this.collageDimension = 4;

        this.tileDimension = 100;

        this.original = new Picture(filename);

        this.collage = new Picture(this.tileDimension*this.collageDimension, this.tileDimension*this.collageDimension);

        for (int collageCol = 0; collageCol < tileDimension*collageDimension; collageCol++)
            for (int collageRow = 0; collageRow < collageDimension*tileDimension; collageRow++)
            {
                int originalCol = collageCol * original.width() / (tileDimension*collageDimension);
                int originalRow = collageRow * original.height() / (tileDimension*collageDimension);
                Color color = original.get(originalCol, originalRow);
                collage.set(collageCol, collageRow, color);
        }
        
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

        this.collageDimension=cd;

         this.tileDimension = td;
        
        this.original = new Picture(filename);

        this.collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);

        for (int collageCol = 0; collageCol < td*cd; collageCol++)
            for (int collageRow = 0; collageRow < cd*td; collageRow++)
            {
                int originalCol = collageCol * original.width() / (tileDimension*collageDimension);
                int originalRow = collageRow * original.height() / (tileDimension*collageDimension);
                Color color = original.get(originalCol, originalRow);
                collage.set(collageCol, collageRow, color);
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	    return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	    return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	    return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	    return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

	    original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

	    collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

        Picture original = new Picture(filename);
        
	    for (int cCol = 0; cCol < tileDimension; cCol++){
            for (int cRow = 0; cRow < tileDimension; cRow++)
            {
                int originalCol = cCol * original.width()/ tileDimension;
                int originalRow = cRow * original.height()/ tileDimension;
                
                //Picture original = new Picture(filename);
                Color color = original.get(originalCol, originalRow);
                collage.set(cCol +(collageCol*tileDimension),cRow+(collageRow*tileDimension) , color);
                
                

            }
        }
        }
    

        
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {
       //Picture pic = new Picture(collageDimension,tileDimension);
        for(int nCol = 0; nCol< collageDimension; nCol++){
            int tileMove = nCol*tileDimension;
            //System.out.println(tileMove);
            for(int nRow = 0; nRow < collageDimension; nRow++){
                int tileMove2 = nRow*tileDimension;
                //System.out.println(tileMove2);
	    for (int collageCol = 0; collageCol < tileDimension; collageCol++){
            for (int collageRow = 0; collageRow < tileDimension; collageRow++)
            {
               
                
                
                int originalCol = collageCol * original.width()/ tileDimension;
                int originalRow = collageRow * original.height()/ tileDimension;
                //count++;
                //System.out.println(count);

                Color color = original.get(originalCol, originalRow);
                collage.set(collageCol +tileMove,collageRow+tileMove2 , color);

            }
        }
        }
    }
}
    

        /*int rr=tileDimension*collageDimension;
    int cc=tileDimension*collageDimension;
    for( int i=0;i< collageDimension;i++)
    {
        for(int j=0;j<collageDimension;j++)
        {
            for(int r=tileDimension*i;r<tileDimension*(i+1);r++)
            {                     
                for(int c= tileDimension*j;c<tileDimension*(j+1);c++)
                { 
                    int m=0;
                    while(m<cc)
                    {
                    int n=0;
                    while(n<rr)
                    {
                    Color color = original.get(m,n);//(tileDimension*j),(tileDimension*i));//, c-(tileDimension*j));
                    collage.set(r,c,color);                        
                   n++;
                    }
                    m++;
                    }}}}}}/*
        
    

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {
        
       // Picture original = new Picture(component);
        for (int cCol = 0; cCol < tileDimension; cCol++){
            for (int cRow = 0; cRow < tileDimension; cRow++)
            {
                //Color color = collage.get(cCol+(collageCol*tileDimension), cRow+(collageCol*tileDimension));

                
                
                
                int pixel = collage.getRGB(cCol+(collageCol*tileDimension),cRow+(collageRow*tileDimension));   
                              
                
                int a = (pixel>>24) & 0xff;                 
                int r = (pixel>>16) & 0xff;                  
                int g = (pixel>>8) & 0xff;                  
                int b = pixel & 0xff;                   
                                 
                if(component == "blue"){
                    r = 0;
                    g = 0;
                    pixel = (a<<24) | (r<<16) | (g<<8) | b;
                    
                }
                else if( component == "red"){
                    b = 0;
                    g = 0;
                    pixel = (a<<24) | (r<<16) | (g<<8) | b;
                }
                else if ( component == "green"){
                    b = 0;
                    r = 0;
                    pixel = (a<<24) | (r<<16) | (g<<8) | b;
                }
                //System.out.println("before color change"+ cCol +"collagecol" + collageCol+"roe"+collageRow);
                //original.show();
                //collage.setRGB( cCol +(collageCol*tileDimension), cRow+(collageCol*tileDimension), pixel);
                Color color = new Color(pixel);
                collage.set(cCol +(collageCol*tileDimension),cRow+(collageRow*tileDimension) , color);
                //System.out.println("after color change");
                //original.show();

            }
        }
	    
    }

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void grayscaleTile (int collageCol, int collageRow) {
        
        for (int cCol = 0; cCol < tileDimension; cCol++){
            for (int cRow = 0; cRow < tileDimension; cRow++)
            {
                //int originalCol = cCol * original.width()/ tileDimension;
                //int originalRow = cRow * original.height()/ tileDimension;
                
                //Picture original = new Picture(filename);
                Color color = collage.get(cCol+(collageCol*tileDimension), cRow+(collageRow*tileDimension));
                color = Luminance.toGray(color);
                collage.set(cCol +(collageCol*tileDimension),cRow+(collageRow*tileDimension) , color);
                
                

            }
        }
        }
	    
    


    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0],300,2); 
        art.makeCollage();
        art.replaceTile(args[1], 1, 1);
        art.replaceTile(args[2], 0, 0);
        art.replaceTile(args[3], 0, 1);
        art.grayscaleTile(1, 1);
        art.grayscaleTile(1, 0);
        art.grayscaleTile(0, 1);
        //art.colorizeTile("red", 1, 1);
        //art.colorizeTile("green", 0, 0);
        //art.colorizeTile("blue", 0, 1);
        art.showCollagePicture();
    }
}
